// A fast and super-slim Javascript implementation of AES.
// IMPLEMENTATION:
// var key = AES.Codec.strToWords("a non secret key"),
// block = AES.Codec.strToWords("a non secret msg");
// cipher = new AES.ECB(key);
// cipher.encrypt(block);

var AES = {
    
    Codec: {
  
      strToWords: function (str) {
  
        if (str.constructor !== String)
          throw 'Input must be a string.';
  
        var utf8Str = unescape(encodeURIComponent(str)),
            strLen = utf8Str.length;
        
        var words = [], tmp = 0;
        
        for (var i = 0; i < strLen; i++) {
          tmp = tmp << 8 | utf8Str.charCodeAt(i);
          if ((i & 3) === 3) {
            words.push(tmp); tmp = 0;
          }
        }
        
        if (i & 3) {
          words.push(this.encodePartial(8*(i&3), tmp));
        }
        
        return words;
  
      },
      
      wordsToStr: function (words) {
  
        if (words.constructor !== Array)
          throw 'Input must be an array.';
  
        var bitLength = this.bitLength(words),
            utf8Str = '', tmp;
  
        for (var i = 0; i < bitLength / 8; i++) {
          if ((i & 3) === 0) tmp = words[i/4];
          utf8Str += String.fromCharCode(tmp >>> 24);
          tmp <<= 8;
        }
        
        return decodeURIComponent(escape(utf8Str));
  
      },
      
      encodePartial: function (len, x, _end) {
        if (len === 32) { return x; }
        return (_end ? x | 0 : x << (32-len)) + len * 0x10000000000;
      },
      
      getPartial: function (x) {
        return Math.round(x/0x10000000000) || 32;
      },
      
      bitLength: function (a) {
        var l = a.length, x;
        if (l === 0) { return 0; }
        x = a[l - 1];
        return (l-1) * 32 + this.getPartial(x);
      }
  
    },
    
    CTR: function (key, iv) {
      
      this._ecb = new AES.ECB(key);
      this._ctr = iv.concat([0,0,0]).slice(0,4);
      
      var _this = this;
      
      this.encrypt = function (data) {
        
        var enc;
        
        for (var i = 0; i < data.length; i+= 4) {
          
          enc = _this._ecb.encrypt(_this._ctr);
          
          _this._ctr[3]++;
          
          data[i]   ^= enc[0];
          data[i+1] ^= enc[1];
          data[i+2] ^= enc[2];
          data[i+3] ^= enc[3];
          
        }
        
        return data;
        
      };
      
    },
    
    ECB: function (key) {
  
      if (!this._tables[0][0][0]) {
        this._precompute();
      }
        
      var i, j, tmp,
        encKey, decKey,
        sbox = this._tables[0][4], decTable = this._tables[1],
        keyLen = key.length, rcon = 1;
  
      if (keyLen !== 4 && keyLen !== 6 && keyLen !== 8)
        throw 'Invalid AES key size.';
  
      this._key = [encKey = key.slice(0), decKey = []];
  
      for (i = keyLen; i < 4 * keyLen + 28; i++) {
        tmp = encKey[i-1];
  
        if (i%keyLen === 0 || (keyLen === 8 && i%keyLen === 4)) {
          tmp = sbox[tmp>>>24]<<24 ^ sbox[tmp>>16&255]<<16 ^ sbox[tmp>>8&255]<<8 ^ sbox[tmp&255];
  
          if (i%keyLen === 0) {
            tmp = tmp<<8 ^ tmp>>>24 ^ rcon<<24;
            rcon = rcon<<1 ^ (rcon>>7)*283;
          }
        }
  
        encKey[i] = encKey[i-keyLen] ^ tmp;
      }
  
      for (j = 0; i; j++, i--) {
        tmp = encKey[j&3 ? i : i - 4];
        if (i<=4 || j<4) {
          decKey[j] = tmp;
        } else {
          decKey[j] = decTable[0][sbox[tmp>>>24      ]] ^
                      decTable[1][sbox[tmp>>16  & 255]] ^
                      decTable[2][sbox[tmp>>8   & 255]] ^
                      decTable[3][sbox[tmp      & 255]];
        }
      }
      
      this.encrypt = function (data) {
        return this._crypt(data,0);
      }
  
      this.decrypt = function (data) {
        return this._crypt(data,1);
      }
  
      this._crypt = function (input, dir) {
        
        if (input.length !== 4)
          throw 'Invalid AES block size.';
  
        var key = this._key[dir],
            a = input[0]           ^ key[0],
            b = input[dir ? 3 : 1] ^ key[1],
            c = input[2]           ^ key[2],
            d = input[dir ? 1 : 3] ^ key[3],
            a2, b2, c2,
  
            nInnerRounds = key.length/4 - 2,
            i,
            kIndex = 4,
            out = [0,0,0,0],
            table = this._tables[dir],
  
            t0    = table[0],
            t1    = table[1],
            t2    = table[2],
            t3    = table[3],
            sbox  = table[4];
  
        for (i = 0; i < nInnerRounds; i++) {
          a2 = t0[a>>>24] ^ t1[b>>16 & 255] ^ t2[c>>8 & 255] ^ t3[d & 255] ^ key[kIndex];
          b2 = t0[b>>>24] ^ t1[c>>16 & 255] ^ t2[d>>8 & 255] ^ t3[a & 255] ^ key[kIndex + 1];
          c2 = t0[c>>>24] ^ t1[d>>16 & 255] ^ t2[a>>8 & 255] ^ t3[b & 255] ^ key[kIndex + 2];
          d  = t0[d>>>24] ^ t1[a>>16 & 255] ^ t2[b>>8 & 255] ^ t3[c & 255] ^ key[kIndex + 3];
          kIndex += 4;
          a=a2; b=b2; c=c2;
        }
  
        for (i = 0; i < 4; i++) {
          out[dir ? 3&-i : i] =
            sbox[a>>>24      ]<<24 ^ 
            sbox[b>>16  & 255]<<16 ^
            sbox[c>>8   & 255]<<8  ^
            sbox[d      & 255]     ^
            key[kIndex++];
          a2=a; a=b; b=c; c=d; d=a2;
        }
  
        return out;
      }
  
    }
    
  };
  
  AES.ECB.prototype._precompute = function () {
    
    var encTable = this._tables[0], decTable = this._tables[1],
       sbox = encTable[4], sboxInv = decTable[4],
       i, x, xInv, d=[], th=[], x2, x4, x8, s, tEnc, tDec;
  
    for (i = 0; i < 256; i++) {
     th[( d[i] = i<<1 ^ (i>>7)*283 )^i]=i;
    }
  
    for (x = xInv = 0; !sbox[x]; x ^= x2 || 1, xInv = th[xInv] || 1) {
     s = xInv ^ xInv<<1 ^ xInv<<2 ^ xInv<<3 ^ xInv<<4;
     s = s>>8 ^ s&255 ^ 99;
     sbox[x] = s;
     sboxInv[s] = x;
  
     x8 = d[x4 = d[x2 = d[x]]];
     tDec = x8*0x1010101 ^ x4*0x10001 ^ x2*0x101 ^ x*0x1010100;
     tEnc = d[s]*0x101 ^ s*0x1010100;
  
     for (i = 0; i < 4; i++) {
       encTable[i][x] = tEnc = tEnc<<24 ^ tEnc>>>8;
       decTable[i][s] = tDec = tDec<<24 ^ tDec>>>8;
     }
    }
  
    for (i = 0; i < 5; i++) {
     encTable[i] = encTable[i].slice(0);
     decTable[i] = decTable[i].slice(0);
    }
       
  };
  
  AES.ECB.prototype._tables = [[[],[],[],[],[]],[[],[],[],[],[]]];