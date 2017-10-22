/**
 * Implementation of "tweaked" version of Anubis block cipher. Cipher Block
 * Chaining (CBC) mode used to encrypt and decrypt data that are longer
 * than 16 octets.
 *
 * ANUBIS is a block cipher designed by Vincent Rijmen and
 * Paulo S. L. M. Barreto that operates on data blocks of length 128 bits,
 * and uses keys of length 128 to 320 bits in steps of 32 bits.
 *
 * ANUBIS is not (and will never be) patented. It may be used free of charge
 * for any purpose.
 *
 */

/**
* USAGE:
* To use this Cryptographic algorithm, install crypto-js module : npm install crypto-js --save 
* Then import this file to the location : var crypto=require('./anubis.js');
* Finally implement the function: var anubis= new crypto.Anubis();
*                                 anubis.setKey('secret_key');
*                                 var enc = anubis.encrypt('Hellow world', false, false);
*                                 var dec = anubis.decrypt(enc, false, false);
**/

var CryptoJS = require("crypto-js");
module.exports.Base64 = {

	// private property
	_keyStr : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",

	// public method for encoding
	encode : function (input, fix) {
		if(fix == undefined) fix = false;
		
	    var output = "";
	    var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
	    var i = 0;

	    if(!fix) input = Base64._utf8_encode(input);

	    while (i < input.length) {

	        chr1 = input.charCodeAt(i++);
	        chr2 = input.charCodeAt(i++);
	        chr3 = input.charCodeAt(i++);

	        enc1 = chr1 >> 2;
	        enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
	        enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
	        enc4 = chr3 & 63;

	        if (isNaN(chr2)) {
	            enc3 = enc4 = 64;
	        } else if (isNaN(chr3)) {
	            enc4 = 64;
	        }

	        output = output +
	        this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) +
	        this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);

	    }

	    return output;
	},

	// public method for decoding
	decode : function (input, fix) {
		if(fix == undefined) fix = false;

	    var output = "";
	    var chr1, chr2, chr3;
	    var enc1, enc2, enc3, enc4;
	    var i = 0;

	    input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

	    while (i < input.length) {

	        enc1 = this._keyStr.indexOf(input.charAt(i++));
	        enc2 = this._keyStr.indexOf(input.charAt(i++));
	        enc3 = this._keyStr.indexOf(input.charAt(i++));
	        enc4 = this._keyStr.indexOf(input.charAt(i++));

	        chr1 = (enc1 << 2) | (enc2 >> 4);
	        chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
	        chr3 = ((enc3 & 3) << 6) | enc4;

	        output = output + String.fromCharCode(chr1);

	        if (enc3 != 64) {
	            output = output + String.fromCharCode(chr2);
	        }
	        if (enc4 != 64) {
	            output = output + String.fromCharCode(chr3);
	        }

	    }

	    if(!fix) output = Base64._utf8_decode(output);

	    return output;

	},

	// private method for UTF-8 encoding
	_utf8_encode : function (string) {
	    string = string.replace(/\r\n/g,"\n");
	    var utftext = "";

	    for (var n = 0; n < string.length; n++) {

	        var c = string.charCodeAt(n);

	        if (c < 128) {
	            utftext += String.fromCharCode(c);
	        }
	        else if((c > 127) && (c < 2048)) {
	            utftext += String.fromCharCode((c >> 6) | 192);
	            utftext += String.fromCharCode((c & 63) | 128);
	        }
	        else {
	            utftext += String.fromCharCode((c >> 12) | 224);
	            utftext += String.fromCharCode(((c >> 6) & 63) | 128);
	            utftext += String.fromCharCode((c & 63) | 128);
	        }

	    }

	    return utftext;
	},

	// private method for UTF-8 decoding
	_utf8_decode : function (utftext) {
	    var string = "";
	    var i = 0;
	    var c = c1 = c2 = 0;

	    while ( i < utftext.length ) {

	        c = utftext.charCodeAt(i);

	        if (c < 128) {
	            string += String.fromCharCode(c);
	            i++;
	        }
	        else if((c > 191) && (c < 224)) {
	            c2 = utftext.charCodeAt(i+1);
	            string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
	            i += 2;
	        }
	        else {
	            c2 = utftext.charCodeAt(i+1);
	            c3 = utftext.charCodeAt(i+2);
	            string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
	            i += 3;
	        }

	    }

	    return string;
	}

};

module.exports.Anubis=function() {
	/**
	 * Initial vector
	 * @var array
	 */
	var T0 = [
		0xba69d2bb, 0x54a84de5, 0x2f5ebce2, 0x74e8cd25,
		0x53a651f7, 0xd3bb6bd0, 0xd2b96fd6, 0x4d9a29b3,
		0x50a05dfd, 0xac458acf, 0x8d070e09, 0xbf63c6a5,
		0x70e0dd3d, 0x52a455f1, 0x9a29527b, 0x4c982db5,
		0xeac98f46, 0xd5b773c4, 0x97336655, 0xd1bf63dc,
		0x3366ccaa, 0x51a259fb, 0x5bb671c7, 0xa651a2f3,
		0xdea15ffe, 0x48903dad, 0xa84d9ad7, 0x992f5e71,
		0xdbab4be0, 0x3264c8ac, 0xb773e695, 0xfce5d732,
		0xe3dbab70, 0x9e214263, 0x913f7e41, 0x9b2b567d,
		0xe2d9af76, 0xbb6bd6bd, 0x4182199b, 0x6edca579,
		0xa557aef9, 0xcb8b0b80, 0x6bd6b167, 0x95376e59,
		0xa15fbee1, 0xf3fbeb10, 0xb17ffe81, 0x0204080c,
		0xcc851792, 0xc49537a2, 0x1d3a744e, 0x14285078,
		0xc39b2bb0, 0x63c69157, 0xdaa94fe6, 0x5dba69d3,
		0x5fbe61df, 0xdca557f2, 0x7dfae913, 0xcd871394,
		0x7ffee11f, 0x5ab475c1, 0x6cd8ad75, 0x5cb86dd5,
		0xf7f3fb08, 0x264c98d4, 0xffe3db38, 0xedc79354,
		0xe8cd874a, 0x9d274e69, 0x6fdea17f, 0x8e010203,
		0x19326456, 0xa05dbae7, 0xf0fde71a, 0x890f1e11,
		0x0f1e3c22, 0x070e1c12, 0xaf4386c5, 0xfbebcb20,
		0x08102030, 0x152a547e, 0x0d1a342e, 0x04081018,
		0x01020406, 0x64c88d45, 0xdfa35bf8, 0x76ecc529,
		0x79f2f90b, 0xdda753f4, 0x3d7af48e, 0x162c5874,
		0x3f7efc82, 0x376edcb2, 0x6ddaa973, 0x3870e090,
		0xb96fdeb1, 0x73e6d137, 0xe9cf834c, 0x356ad4be,
		0x55aa49e3, 0x71e2d93b, 0x7bf6f107, 0x8c050a0f,
		0x72e4d531, 0x880d1a17, 0xf6f1ff0e, 0x2a54a8fc,
		0x3e7cf884, 0x5ebc65d9, 0x274e9cd2, 0x468c0589,
		0x0c183028, 0x65ca8943, 0x68d0bd6d, 0x61c2995b,
		0x03060c0a, 0xc19f23bc, 0x57ae41ef, 0xd6b17fce,
		0xd9af43ec, 0x58b07dcd, 0xd8ad47ea, 0x66cc8549,
		0xd7b37bc8, 0x3a74e89c, 0xc88d078a, 0x3c78f088,
		0xfae9cf26, 0x96316253, 0xa753a6f5, 0x982d5a77,
		0xecc59752, 0xb86ddab7, 0xc7933ba8, 0xae4182c3,
		0x69d2b96b, 0x4b9631a7, 0xab4b96dd, 0xa94f9ed1,
		0x67ce814f, 0x0a14283c, 0x478e018f, 0xf2f9ef16,
		0xb577ee99, 0x224488cc, 0xe5d7b364, 0xeec19f5e,
		0xbe61c2a3, 0x2b56acfa, 0x811f3e21, 0x1224486c,
		0x831b362d, 0x1b366c5a, 0x0e1c3824, 0x23468cca,
		0xf5f7f304, 0x458a0983, 0x214284c6, 0xce811f9e,
		0x499239ab, 0x2c58b0e8, 0xf9efc32c, 0xe6d1bf6e,
		0xb671e293, 0x2850a0f0, 0x172e5c72, 0x8219322b,
		0x1a34685c, 0x8b0b161d, 0xfee1df3e, 0x8a09121b,
		0x09122436, 0xc98f038c, 0x87132635, 0x4e9c25b9,
		0xe1dfa37c, 0x2e5cb8e4, 0xe4d5b762, 0xe0dda77a,
		0xebcb8b40, 0x903d7a47, 0xa455aaff, 0x1e3c7844,
		0x85172e39, 0x60c09d5d, 0x00000000, 0x254a94de,
		0xf4f5f702, 0xf1ffe31c, 0x94356a5f, 0x0b162c3a,
		0xe7d3bb68, 0x75eac923, 0xefc39b58, 0x3468d0b8,
		0x3162c4a6, 0xd4b577c2, 0xd0bd67da, 0x86112233,
		0x7efce519, 0xad478ec9, 0xfde7d334, 0x2952a4f6,
		0x3060c0a0, 0x3b76ec9a, 0x9f234665, 0xf8edc72a,
		0xc6913fae, 0x13264c6a, 0x060c1814, 0x050a141e,
		0xc59733a4, 0x11224466, 0x77eec12f, 0x7cf8ed15,
		0x7af4f501, 0x78f0fd0d, 0x366cd8b4, 0x1c387048,
		0x3972e496, 0x59b279cb, 0x18306050, 0x56ac45e9,
		0xb37bf68d, 0xb07dfa87, 0x244890d8, 0x204080c0,
		0xb279f28b, 0x9239724b, 0xa35bb6ed, 0xc09d27ba,
		0x44880d85, 0x62c49551, 0x10204060, 0xb475ea9f,
		0x84152a3f, 0x43861197, 0x933b764d, 0xc2992fb6,
		0x4a9435a1, 0xbd67cea9, 0x8f030605, 0x2d5ab4ee,
		0xbc65caaf, 0x9c254a6f, 0x6ad4b561, 0x40801d9d,
		0xcf831b98, 0xa259b2eb, 0x801d3a27, 0x4f9e21bf,
		0x1f3e7c42, 0xca890f86, 0xaa4992db, 0x42841591
	];

	/**
	 * Initial vector
	 * @var array
	 */
	var T1 = [
		0x69babbd2, 0xa854e54d, 0x5e2fe2bc, 0xe87425cd,
		0xa653f751, 0xbbd3d06b, 0xb9d2d66f, 0x9a4db329,
		0xa050fd5d, 0x45accf8a, 0x078d090e, 0x63bfa5c6,
		0xe0703ddd, 0xa452f155, 0x299a7b52, 0x984cb52d,
		0xc9ea468f, 0xb7d5c473, 0x33975566, 0xbfd1dc63,
		0x6633aacc, 0xa251fb59, 0xb65bc771, 0x51a6f3a2,
		0xa1defe5f, 0x9048ad3d, 0x4da8d79a, 0x2f99715e,
		0xabdbe04b, 0x6432acc8, 0x73b795e6, 0xe5fc32d7,
		0xdbe370ab, 0x219e6342, 0x3f91417e, 0x2b9b7d56,
		0xd9e276af, 0x6bbbbdd6, 0x82419b19, 0xdc6e79a5,
		0x57a5f9ae, 0x8bcb800b, 0xd66b67b1, 0x3795596e,
		0x5fa1e1be, 0xfbf310eb, 0x7fb181fe, 0x04020c08,
		0x85cc9217, 0x95c4a237, 0x3a1d4e74, 0x28147850,
		0x9bc3b02b, 0xc6635791, 0xa9dae64f, 0xba5dd369,
		0xbe5fdf61, 0xa5dcf257, 0xfa7d13e9, 0x87cd9413,
		0xfe7f1fe1, 0xb45ac175, 0xd86c75ad, 0xb85cd56d,
		0xf3f708fb, 0x4c26d498, 0xe3ff38db, 0xc7ed5493,
		0xcde84a87, 0x279d694e, 0xde6f7fa1, 0x018e0302,
		0x32195664, 0x5da0e7ba, 0xfdf01ae7, 0x0f89111e,
		0x1e0f223c, 0x0e07121c, 0x43afc586, 0xebfb20cb,
		0x10083020, 0x2a157e54, 0x1a0d2e34, 0x08041810,
		0x02010604, 0xc864458d, 0xa3dff85b, 0xec7629c5,
		0xf2790bf9, 0xa7ddf453, 0x7a3d8ef4, 0x2c167458,
		0x7e3f82fc, 0x6e37b2dc, 0xda6d73a9, 0x703890e0,
		0x6fb9b1de, 0xe67337d1, 0xcfe94c83, 0x6a35bed4,
		0xaa55e349, 0xe2713bd9, 0xf67b07f1, 0x058c0f0a,
		0xe47231d5, 0x0d88171a, 0xf1f60eff, 0x542afca8,
		0x7c3e84f8, 0xbc5ed965, 0x4e27d29c, 0x8c468905,
		0x180c2830, 0xca654389, 0xd0686dbd, 0xc2615b99,
		0x06030a0c, 0x9fc1bc23, 0xae57ef41, 0xb1d6ce7f,
		0xafd9ec43, 0xb058cd7d, 0xadd8ea47, 0xcc664985,
		0xb3d7c87b, 0x743a9ce8, 0x8dc88a07, 0x783c88f0,
		0xe9fa26cf, 0x31965362, 0x53a7f5a6, 0x2d98775a,
		0xc5ec5297, 0x6db8b7da, 0x93c7a83b, 0x41aec382,
		0xd2696bb9, 0x964ba731, 0x4babdd96, 0x4fa9d19e,
		0xce674f81, 0x140a3c28, 0x8e478f01, 0xf9f216ef,
		0x77b599ee, 0x4422cc88, 0xd7e564b3, 0xc1ee5e9f,
		0x61bea3c2, 0x562bfaac, 0x1f81213e, 0x24126c48,
		0x1b832d36, 0x361b5a6c, 0x1c0e2438, 0x4623ca8c,
		0xf7f504f3, 0x8a458309, 0x4221c684, 0x81ce9e1f,
		0x9249ab39, 0x582ce8b0, 0xeff92cc3, 0xd1e66ebf,
		0x71b693e2, 0x5028f0a0, 0x2e17725c, 0x19822b32,
		0x341a5c68, 0x0b8b1d16, 0xe1fe3edf, 0x098a1b12,
		0x12093624, 0x8fc98c03, 0x13873526, 0x9c4eb925,
		0xdfe17ca3, 0x5c2ee4b8, 0xd5e462b7, 0xdde07aa7,
		0xcbeb408b, 0x3d90477a, 0x55a4ffaa, 0x3c1e4478,
		0x1785392e, 0xc0605d9d, 0x00000000, 0x4a25de94,
		0xf5f402f7, 0xfff11ce3, 0x35945f6a, 0x160b3a2c,
		0xd3e768bb, 0xea7523c9, 0xc3ef589b, 0x6834b8d0,
		0x6231a6c4, 0xb5d4c277, 0xbdd0da67, 0x11863322,
		0xfc7e19e5, 0x47adc98e, 0xe7fd34d3, 0x5229f6a4,
		0x6030a0c0, 0x763b9aec, 0x239f6546, 0xedf82ac7,
		0x91c6ae3f, 0x26136a4c, 0x0c061418, 0x0a051e14,
		0x97c5a433, 0x22116644, 0xee772fc1, 0xf87c15ed,
		0xf47a01f5, 0xf0780dfd, 0x6c36b4d8, 0x381c4870,
		0x723996e4, 0xb259cb79, 0x30185060, 0xac56e945,
		0x7bb38df6, 0x7db087fa, 0x4824d890, 0x4020c080,
		0x79b28bf2, 0x39924b72, 0x5ba3edb6, 0x9dc0ba27,
		0x8844850d, 0xc4625195, 0x20106040, 0x75b49fea,
		0x15843f2a, 0x86439711, 0x3b934d76, 0x99c2b62f,
		0x944aa135, 0x67bda9ce, 0x038f0506, 0x5a2deeb4,
		0x65bcafca, 0x259c6f4a, 0xd46a61b5, 0x80409d1d,
		0x83cf981b, 0x59a2ebb2, 0x1d80273a, 0x9e4fbf21,
		0x3e1f427c, 0x89ca860f, 0x49aadb92, 0x84429115
	];

	/**
	 * Initial vector
	 * @var array
	 */
	var T2 = [
		0xd2bbba69, 0x4de554a8, 0xbce22f5e, 0xcd2574e8,
		0x51f753a6, 0x6bd0d3bb, 0x6fd6d2b9, 0x29b34d9a,
		0x5dfd50a0, 0x8acfac45, 0x0e098d07, 0xc6a5bf63,
		0xdd3d70e0, 0x55f152a4, 0x527b9a29, 0x2db54c98,
		0x8f46eac9, 0x73c4d5b7, 0x66559733, 0x63dcd1bf,
		0xccaa3366, 0x59fb51a2, 0x71c75bb6, 0xa2f3a651,
		0x5ffedea1, 0x3dad4890, 0x9ad7a84d, 0x5e71992f,
		0x4be0dbab, 0xc8ac3264, 0xe695b773, 0xd732fce5,
		0xab70e3db, 0x42639e21, 0x7e41913f, 0x567d9b2b,
		0xaf76e2d9, 0xd6bdbb6b, 0x199b4182, 0xa5796edc,
		0xaef9a557, 0x0b80cb8b, 0xb1676bd6, 0x6e599537,
		0xbee1a15f, 0xeb10f3fb, 0xfe81b17f, 0x080c0204,
		0x1792cc85, 0x37a2c495, 0x744e1d3a, 0x50781428,
		0x2bb0c39b, 0x915763c6, 0x4fe6daa9, 0x69d35dba,
		0x61df5fbe, 0x57f2dca5, 0xe9137dfa, 0x1394cd87,
		0xe11f7ffe, 0x75c15ab4, 0xad756cd8, 0x6dd55cb8,
		0xfb08f7f3, 0x98d4264c, 0xdb38ffe3, 0x9354edc7,
		0x874ae8cd, 0x4e699d27, 0xa17f6fde, 0x02038e01,
		0x64561932, 0xbae7a05d, 0xe71af0fd, 0x1e11890f,
		0x3c220f1e, 0x1c12070e, 0x86c5af43, 0xcb20fbeb,
		0x20300810, 0x547e152a, 0x342e0d1a, 0x10180408,
		0x04060102, 0x8d4564c8, 0x5bf8dfa3, 0xc52976ec,
		0xf90b79f2, 0x53f4dda7, 0xf48e3d7a, 0x5874162c,
		0xfc823f7e, 0xdcb2376e, 0xa9736dda, 0xe0903870,
		0xdeb1b96f, 0xd13773e6, 0x834ce9cf, 0xd4be356a,
		0x49e355aa, 0xd93b71e2, 0xf1077bf6, 0x0a0f8c05,
		0xd53172e4, 0x1a17880d, 0xff0ef6f1, 0xa8fc2a54,
		0xf8843e7c, 0x65d95ebc, 0x9cd2274e, 0x0589468c,
		0x30280c18, 0x894365ca, 0xbd6d68d0, 0x995b61c2,
		0x0c0a0306, 0x23bcc19f, 0x41ef57ae, 0x7fced6b1,
		0x43ecd9af, 0x7dcd58b0, 0x47ead8ad, 0x854966cc,
		0x7bc8d7b3, 0xe89c3a74, 0x078ac88d, 0xf0883c78,
		0xcf26fae9, 0x62539631, 0xa6f5a753, 0x5a77982d,
		0x9752ecc5, 0xdab7b86d, 0x3ba8c793, 0x82c3ae41,
		0xb96b69d2, 0x31a74b96, 0x96ddab4b, 0x9ed1a94f,
		0x814f67ce, 0x283c0a14, 0x018f478e, 0xef16f2f9,
		0xee99b577, 0x88cc2244, 0xb364e5d7, 0x9f5eeec1,
		0xc2a3be61, 0xacfa2b56, 0x3e21811f, 0x486c1224,
		0x362d831b, 0x6c5a1b36, 0x38240e1c, 0x8cca2346,
		0xf304f5f7, 0x0983458a, 0x84c62142, 0x1f9ece81,
		0x39ab4992, 0xb0e82c58, 0xc32cf9ef, 0xbf6ee6d1,
		0xe293b671, 0xa0f02850, 0x5c72172e, 0x322b8219,
		0x685c1a34, 0x161d8b0b, 0xdf3efee1, 0x121b8a09,
		0x24360912, 0x038cc98f, 0x26358713, 0x25b94e9c,
		0xa37ce1df, 0xb8e42e5c, 0xb762e4d5, 0xa77ae0dd,
		0x8b40ebcb, 0x7a47903d, 0xaaffa455, 0x78441e3c,
		0x2e398517, 0x9d5d60c0, 0x00000000, 0x94de254a,
		0xf702f4f5, 0xe31cf1ff, 0x6a5f9435, 0x2c3a0b16,
		0xbb68e7d3, 0xc92375ea, 0x9b58efc3, 0xd0b83468,
		0xc4a63162, 0x77c2d4b5, 0x67dad0bd, 0x22338611,
		0xe5197efc, 0x8ec9ad47, 0xd334fde7, 0xa4f62952,
		0xc0a03060, 0xec9a3b76, 0x46659f23, 0xc72af8ed,
		0x3faec691, 0x4c6a1326, 0x1814060c, 0x141e050a,
		0x33a4c597, 0x44661122, 0xc12f77ee, 0xed157cf8,
		0xf5017af4, 0xfd0d78f0, 0xd8b4366c, 0x70481c38,
		0xe4963972, 0x79cb59b2, 0x60501830, 0x45e956ac,
		0xf68db37b, 0xfa87b07d, 0x90d82448, 0x80c02040,
		0xf28bb279, 0x724b9239, 0xb6eda35b, 0x27bac09d,
		0x0d854488, 0x955162c4, 0x40601020, 0xea9fb475,
		0x2a3f8415, 0x11974386, 0x764d933b, 0x2fb6c299,
		0x35a14a94, 0xcea9bd67, 0x06058f03, 0xb4ee2d5a,
		0xcaafbc65, 0x4a6f9c25, 0xb5616ad4, 0x1d9d4080,
		0x1b98cf83, 0xb2eba259, 0x3a27801d, 0x21bf4f9e,
		0x7c421f3e, 0x0f86ca89, 0x92dbaa49, 0x15914284
	];

	/**
	 * Initial vector
	 * @var array
	 */
	var T3 = [
		0xbbd269ba, 0xe54da854, 0xe2bc5e2f, 0x25cde874,
		0xf751a653, 0xd06bbbd3, 0xd66fb9d2, 0xb3299a4d,
		0xfd5da050, 0xcf8a45ac, 0x090e078d, 0xa5c663bf,
		0x3ddde070, 0xf155a452, 0x7b52299a, 0xb52d984c,
		0x468fc9ea, 0xc473b7d5, 0x55663397, 0xdc63bfd1,
		0xaacc6633, 0xfb59a251, 0xc771b65b, 0xf3a251a6,
		0xfe5fa1de, 0xad3d9048, 0xd79a4da8, 0x715e2f99,
		0xe04babdb, 0xacc86432, 0x95e673b7, 0x32d7e5fc,
		0x70abdbe3, 0x6342219e, 0x417e3f91, 0x7d562b9b,
		0x76afd9e2, 0xbdd66bbb, 0x9b198241, 0x79a5dc6e,
		0xf9ae57a5, 0x800b8bcb, 0x67b1d66b, 0x596e3795,
		0xe1be5fa1, 0x10ebfbf3, 0x81fe7fb1, 0x0c080402,
		0x921785cc, 0xa23795c4, 0x4e743a1d, 0x78502814,
		0xb02b9bc3, 0x5791c663, 0xe64fa9da, 0xd369ba5d,
		0xdf61be5f, 0xf257a5dc, 0x13e9fa7d, 0x941387cd,
		0x1fe1fe7f, 0xc175b45a, 0x75add86c, 0xd56db85c,
		0x08fbf3f7, 0xd4984c26, 0x38dbe3ff, 0x5493c7ed,
		0x4a87cde8, 0x694e279d, 0x7fa1de6f, 0x0302018e,
		0x56643219, 0xe7ba5da0, 0x1ae7fdf0, 0x111e0f89,
		0x223c1e0f, 0x121c0e07, 0xc58643af, 0x20cbebfb,
		0x30201008, 0x7e542a15, 0x2e341a0d, 0x18100804,
		0x06040201, 0x458dc864, 0xf85ba3df, 0x29c5ec76,
		0x0bf9f279, 0xf453a7dd, 0x8ef47a3d, 0x74582c16,
		0x82fc7e3f, 0xb2dc6e37, 0x73a9da6d, 0x90e07038,
		0xb1de6fb9, 0x37d1e673, 0x4c83cfe9, 0xbed46a35,
		0xe349aa55, 0x3bd9e271, 0x07f1f67b, 0x0f0a058c,
		0x31d5e472, 0x171a0d88, 0x0efff1f6, 0xfca8542a,
		0x84f87c3e, 0xd965bc5e, 0xd29c4e27, 0x89058c46,
		0x2830180c, 0x4389ca65, 0x6dbdd068, 0x5b99c261,
		0x0a0c0603, 0xbc239fc1, 0xef41ae57, 0xce7fb1d6,
		0xec43afd9, 0xcd7db058, 0xea47add8, 0x4985cc66,
		0xc87bb3d7, 0x9ce8743a, 0x8a078dc8, 0x88f0783c,
		0x26cfe9fa, 0x53623196, 0xf5a653a7, 0x775a2d98,
		0x5297c5ec, 0xb7da6db8, 0xa83b93c7, 0xc38241ae,
		0x6bb9d269, 0xa731964b, 0xdd964bab, 0xd19e4fa9,
		0x4f81ce67, 0x3c28140a, 0x8f018e47, 0x16eff9f2,
		0x99ee77b5, 0xcc884422, 0x64b3d7e5, 0x5e9fc1ee,
		0xa3c261be, 0xfaac562b, 0x213e1f81, 0x6c482412,
		0x2d361b83, 0x5a6c361b, 0x24381c0e, 0xca8c4623,
		0x04f3f7f5, 0x83098a45, 0xc6844221, 0x9e1f81ce,
		0xab399249, 0xe8b0582c, 0x2cc3eff9, 0x6ebfd1e6,
		0x93e271b6, 0xf0a05028, 0x725c2e17, 0x2b321982,
		0x5c68341a, 0x1d160b8b, 0x3edfe1fe, 0x1b12098a,
		0x36241209, 0x8c038fc9, 0x35261387, 0xb9259c4e,
		0x7ca3dfe1, 0xe4b85c2e, 0x62b7d5e4, 0x7aa7dde0,
		0x408bcbeb, 0x477a3d90, 0xffaa55a4, 0x44783c1e,
		0x392e1785, 0x5d9dc060, 0x00000000, 0xde944a25,
		0x02f7f5f4, 0x1ce3fff1, 0x5f6a3594, 0x3a2c160b,
		0x68bbd3e7, 0x23c9ea75, 0x589bc3ef, 0xb8d06834,
		0xa6c46231, 0xc277b5d4, 0xda67bdd0, 0x33221186,
		0x19e5fc7e, 0xc98e47ad, 0x34d3e7fd, 0xf6a45229,
		0xa0c06030, 0x9aec763b, 0x6546239f, 0x2ac7edf8,
		0xae3f91c6, 0x6a4c2613, 0x14180c06, 0x1e140a05,
		0xa43397c5, 0x66442211, 0x2fc1ee77, 0x15edf87c,
		0x01f5f47a, 0x0dfdf078, 0xb4d86c36, 0x4870381c,
		0x96e47239, 0xcb79b259, 0x50603018, 0xe945ac56,
		0x8df67bb3, 0x87fa7db0, 0xd8904824, 0xc0804020,
		0x8bf279b2, 0x4b723992, 0xedb65ba3, 0xba279dc0,
		0x850d8844, 0x5195c462, 0x60402010, 0x9fea75b4,
		0x3f2a1584, 0x97118643, 0x4d763b93, 0xb62f99c2,
		0xa135944a, 0xa9ce67bd, 0x0506038f, 0xeeb45a2d,
		0xafca65bc, 0x6f4a259c, 0x61b5d46a, 0x9d1d8040,
		0x981b83cf, 0xebb259a2, 0x273a1d80, 0xbf219e4f,
		0x427c3e1f, 0x860f89ca, 0xdb9249aa, 0x91158442
	];

	/**
	 * Initial vector
	 * @var array
	 */
	var T4 = [
		0xbabababa, 0x54545454, 0x2f2f2f2f, 0x74747474,
		0x53535353, 0xd3d3d3d3, 0xd2d2d2d2, 0x4d4d4d4d,
		0x50505050, 0xacacacac, 0x8d8d8d8d, 0xbfbfbfbf,
		0x70707070, 0x52525252, 0x9a9a9a9a, 0x4c4c4c4c,
		0xeaeaeaea, 0xd5d5d5d5, 0x97979797, 0xd1d1d1d1,
		0x33333333, 0x51515151, 0x5b5b5b5b, 0xa6a6a6a6,
		0xdededede, 0x48484848, 0xa8a8a8a8, 0x99999999,
		0xdbdbdbdb, 0x32323232, 0xb7b7b7b7, 0xfcfcfcfc,
		0xe3e3e3e3, 0x9e9e9e9e, 0x91919191, 0x9b9b9b9b,
		0xe2e2e2e2, 0xbbbbbbbb, 0x41414141, 0x6e6e6e6e,
		0xa5a5a5a5, 0xcbcbcbcb, 0x6b6b6b6b, 0x95959595,
		0xa1a1a1a1, 0xf3f3f3f3, 0xb1b1b1b1, 0x02020202,
		0xcccccccc, 0xc4c4c4c4, 0x1d1d1d1d, 0x14141414,
		0xc3c3c3c3, 0x63636363, 0xdadadada, 0x5d5d5d5d,
		0x5f5f5f5f, 0xdcdcdcdc, 0x7d7d7d7d, 0xcdcdcdcd,
		0x7f7f7f7f, 0x5a5a5a5a, 0x6c6c6c6c, 0x5c5c5c5c,
		0xf7f7f7f7, 0x26262626, 0xffffffff, 0xedededed,
		0xe8e8e8e8, 0x9d9d9d9d, 0x6f6f6f6f, 0x8e8e8e8e,
		0x19191919, 0xa0a0a0a0, 0xf0f0f0f0, 0x89898989,
		0x0f0f0f0f, 0x07070707, 0xafafafaf, 0xfbfbfbfb,
		0x08080808, 0x15151515, 0x0d0d0d0d, 0x04040404,
		0x01010101, 0x64646464, 0xdfdfdfdf, 0x76767676,
		0x79797979, 0xdddddddd, 0x3d3d3d3d, 0x16161616,
		0x3f3f3f3f, 0x37373737, 0x6d6d6d6d, 0x38383838,
		0xb9b9b9b9, 0x73737373, 0xe9e9e9e9, 0x35353535,
		0x55555555, 0x71717171, 0x7b7b7b7b, 0x8c8c8c8c,
		0x72727272, 0x88888888, 0xf6f6f6f6, 0x2a2a2a2a,
		0x3e3e3e3e, 0x5e5e5e5e, 0x27272727, 0x46464646,
		0x0c0c0c0c, 0x65656565, 0x68686868, 0x61616161,
		0x03030303, 0xc1c1c1c1, 0x57575757, 0xd6d6d6d6,
		0xd9d9d9d9, 0x58585858, 0xd8d8d8d8, 0x66666666,
		0xd7d7d7d7, 0x3a3a3a3a, 0xc8c8c8c8, 0x3c3c3c3c,
		0xfafafafa, 0x96969696, 0xa7a7a7a7, 0x98989898,
		0xecececec, 0xb8b8b8b8, 0xc7c7c7c7, 0xaeaeaeae,
		0x69696969, 0x4b4b4b4b, 0xabababab, 0xa9a9a9a9,
		0x67676767, 0x0a0a0a0a, 0x47474747, 0xf2f2f2f2,
		0xb5b5b5b5, 0x22222222, 0xe5e5e5e5, 0xeeeeeeee,
		0xbebebebe, 0x2b2b2b2b, 0x81818181, 0x12121212,
		0x83838383, 0x1b1b1b1b, 0x0e0e0e0e, 0x23232323,
		0xf5f5f5f5, 0x45454545, 0x21212121, 0xcececece,
		0x49494949, 0x2c2c2c2c, 0xf9f9f9f9, 0xe6e6e6e6,
		0xb6b6b6b6, 0x28282828, 0x17171717, 0x82828282,
		0x1a1a1a1a, 0x8b8b8b8b, 0xfefefefe, 0x8a8a8a8a,
		0x09090909, 0xc9c9c9c9, 0x87878787, 0x4e4e4e4e,
		0xe1e1e1e1, 0x2e2e2e2e, 0xe4e4e4e4, 0xe0e0e0e0,
		0xebebebeb, 0x90909090, 0xa4a4a4a4, 0x1e1e1e1e,
		0x85858585, 0x60606060, 0x00000000, 0x25252525,
		0xf4f4f4f4, 0xf1f1f1f1, 0x94949494, 0x0b0b0b0b,
		0xe7e7e7e7, 0x75757575, 0xefefefef, 0x34343434,
		0x31313131, 0xd4d4d4d4, 0xd0d0d0d0, 0x86868686,
		0x7e7e7e7e, 0xadadadad, 0xfdfdfdfd, 0x29292929,
		0x30303030, 0x3b3b3b3b, 0x9f9f9f9f, 0xf8f8f8f8,
		0xc6c6c6c6, 0x13131313, 0x06060606, 0x05050505,
		0xc5c5c5c5, 0x11111111, 0x77777777, 0x7c7c7c7c,
		0x7a7a7a7a, 0x78787878, 0x36363636, 0x1c1c1c1c,
		0x39393939, 0x59595959, 0x18181818, 0x56565656,
		0xb3b3b3b3, 0xb0b0b0b0, 0x24242424, 0x20202020,
		0xb2b2b2b2, 0x92929292, 0xa3a3a3a3, 0xc0c0c0c0,
		0x44444444, 0x62626262, 0x10101010, 0xb4b4b4b4,
		0x84848484, 0x43434343, 0x93939393, 0xc2c2c2c2,
		0x4a4a4a4a, 0xbdbdbdbd, 0x8f8f8f8f, 0x2d2d2d2d,
		0xbcbcbcbc, 0x9c9c9c9c, 0x6a6a6a6a, 0x40404040,
		0xcfcfcfcf, 0xa2a2a2a2, 0x80808080, 0x4f4f4f4f,
		0x1f1f1f1f, 0xcacacaca, 0xaaaaaaaa, 0x42424242
	];

	/**
	 * Initial vector
	 * @var array
	 */
	var T5 = [
		0x00000000, 0x01020608, 0x02040c10, 0x03060a18,
		0x04081820, 0x050a1e28, 0x060c1430, 0x070e1238,
		0x08103040, 0x09123648, 0x0a143c50, 0x0b163a58,
		0x0c182860, 0x0d1a2e68, 0x0e1c2470, 0x0f1e2278,
		0x10206080, 0x11226688, 0x12246c90, 0x13266a98,
		0x142878a0, 0x152a7ea8, 0x162c74b0, 0x172e72b8,
		0x183050c0, 0x193256c8, 0x1a345cd0, 0x1b365ad8,
		0x1c3848e0, 0x1d3a4ee8, 0x1e3c44f0, 0x1f3e42f8,
		0x2040c01d, 0x2142c615, 0x2244cc0d, 0x2346ca05,
		0x2448d83d, 0x254ade35, 0x264cd42d, 0x274ed225,
		0x2850f05d, 0x2952f655, 0x2a54fc4d, 0x2b56fa45,
		0x2c58e87d, 0x2d5aee75, 0x2e5ce46d, 0x2f5ee265,
		0x3060a09d, 0x3162a695, 0x3264ac8d, 0x3366aa85,
		0x3468b8bd, 0x356abeb5, 0x366cb4ad, 0x376eb2a5,
		0x387090dd, 0x397296d5, 0x3a749ccd, 0x3b769ac5,
		0x3c7888fd, 0x3d7a8ef5, 0x3e7c84ed, 0x3f7e82e5,
		0x40809d3a, 0x41829b32, 0x4284912a, 0x43869722,
		0x4488851a, 0x458a8312, 0x468c890a, 0x478e8f02,
		0x4890ad7a, 0x4992ab72, 0x4a94a16a, 0x4b96a762,
		0x4c98b55a, 0x4d9ab352, 0x4e9cb94a, 0x4f9ebf42,
		0x50a0fdba, 0x51a2fbb2, 0x52a4f1aa, 0x53a6f7a2,
		0x54a8e59a, 0x55aae392, 0x56ace98a, 0x57aeef82,
		0x58b0cdfa, 0x59b2cbf2, 0x5ab4c1ea, 0x5bb6c7e2,
		0x5cb8d5da, 0x5dbad3d2, 0x5ebcd9ca, 0x5fbedfc2,
		0x60c05d27, 0x61c25b2f, 0x62c45137, 0x63c6573f,
		0x64c84507, 0x65ca430f, 0x66cc4917, 0x67ce4f1f,
		0x68d06d67, 0x69d26b6f, 0x6ad46177, 0x6bd6677f,
		0x6cd87547, 0x6dda734f, 0x6edc7957, 0x6fde7f5f,
		0x70e03da7, 0x71e23baf, 0x72e431b7, 0x73e637bf,
		0x74e82587, 0x75ea238f, 0x76ec2997, 0x77ee2f9f,
		0x78f00de7, 0x79f20bef, 0x7af401f7, 0x7bf607ff,
		0x7cf815c7, 0x7dfa13cf, 0x7efc19d7, 0x7ffe1fdf,
		0x801d2774, 0x811f217c, 0x82192b64, 0x831b2d6c,
		0x84153f54, 0x8517395c, 0x86113344, 0x8713354c,
		0x880d1734, 0x890f113c, 0x8a091b24, 0x8b0b1d2c,
		0x8c050f14, 0x8d07091c, 0x8e010304, 0x8f03050c,
		0x903d47f4, 0x913f41fc, 0x92394be4, 0x933b4dec,
		0x94355fd4, 0x953759dc, 0x963153c4, 0x973355cc,
		0x982d77b4, 0x992f71bc, 0x9a297ba4, 0x9b2b7dac,
		0x9c256f94, 0x9d27699c, 0x9e216384, 0x9f23658c,
		0xa05de769, 0xa15fe161, 0xa259eb79, 0xa35bed71,
		0xa455ff49, 0xa557f941, 0xa651f359, 0xa753f551,
		0xa84dd729, 0xa94fd121, 0xaa49db39, 0xab4bdd31,
		0xac45cf09, 0xad47c901, 0xae41c319, 0xaf43c511,
		0xb07d87e9, 0xb17f81e1, 0xb2798bf9, 0xb37b8df1,
		0xb4759fc9, 0xb57799c1, 0xb67193d9, 0xb77395d1,
		0xb86db7a9, 0xb96fb1a1, 0xba69bbb9, 0xbb6bbdb1,
		0xbc65af89, 0xbd67a981, 0xbe61a399, 0xbf63a591,
		0xc09dba4e, 0xc19fbc46, 0xc299b65e, 0xc39bb056,
		0xc495a26e, 0xc597a466, 0xc691ae7e, 0xc793a876,
		0xc88d8a0e, 0xc98f8c06, 0xca89861e, 0xcb8b8016,
		0xcc85922e, 0xcd879426, 0xce819e3e, 0xcf839836,
		0xd0bddace, 0xd1bfdcc6, 0xd2b9d6de, 0xd3bbd0d6,
		0xd4b5c2ee, 0xd5b7c4e6, 0xd6b1cefe, 0xd7b3c8f6,
		0xd8adea8e, 0xd9afec86, 0xdaa9e69e, 0xdbabe096,
		0xdca5f2ae, 0xdda7f4a6, 0xdea1febe, 0xdfa3f8b6,
		0xe0dd7a53, 0xe1df7c5b, 0xe2d97643, 0xe3db704b,
		0xe4d56273, 0xe5d7647b, 0xe6d16e63, 0xe7d3686b,
		0xe8cd4a13, 0xe9cf4c1b, 0xeac94603, 0xebcb400b,
		0xecc55233, 0xedc7543b, 0xeec15e23, 0xefc3582b,
		0xf0fd1ad3, 0xf1ff1cdb, 0xf2f916c3, 0xf3fb10cb,
		0xf4f502f3, 0xf5f704fb, 0xf6f10ee3, 0xf7f308eb,
		0xf8ed2a93, 0xf9ef2c9b, 0xfae92683, 0xfbeb208b,
		0xfce532b3, 0xfde734bb, 0xfee13ea3, 0xffe338ab
	];

	/**
	 * Key schedule to encode
	 * @var array
	 */
	var roundKeyEnc = [];

	/**
	 * Key schedule to decode
	 * @var array
	 */
	var roundKeyDec = [];


	/**
	 * Salt to use with key derivation function (KDF). Just use zero-octets
	 * string because we don't need to hide password we just need to make it
	 * random-like.
	 * @var string
	 */
	var KDF_salt = "\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0";

	/**
	 * Hash algorithm to use with KDF. Use strong hash function to avoid
	 * collisions.
	 * @var string
	 */
	var KDF_algo = 'SHA256';

	/**
	 * Shift $value to $r bits like $value >> $r.
	 * This is messy hack for 32-bit signed integer values for x86 systems.
	 */
	var rot = function (value, r) {
		if (r === 0) return value;
		if (r > 0) {
			var result = value >> r;
			
			if ((Math.pow(2, 53)+'').length === 8) return result;
			
			var mask = 0xffffffff;
			
			switch(r) {
				case 24: mask = 0x000000ff; break;
				case 16: mask = 0x0000ffff; break;
				case  8: mask = 0x00ffffff; break;
			}
			return result & mask;
		}
	}

	/**
	 * Create binary key of length 128, 160, 192, 224, 256, 288, or 320 bit
	 * from text string of arbitrary length using kdf() method.
		*
	 * @param string $src_key Text representation of cypher key.
	 * @return string Binary key. It will be always the same length or a
	 *                bit more as $src_key.
	 */
	var keyPrepare = function (src_key) {
		//key length must be multiple of 32 bit (multiple of 4 chars),
		//between 128 bit (16 chars) and 320 bit (40 chars) with the step of
		//32 bit (4 chars)
		var length = 16;
		
		//key is more than 128 bit (16 chars)
		if (src_key.length > 16) {
			//key is bigger than 320 bit (40 chars)
			if (src_key.length >= 40) {
				length = 40;
			} else {
				length = Math.ceil(src_key.length / 4) * 4;
			}
		}
		
		return kdf(KDF_algo, src_key, KDF_salt, length); // key
	}

	/**
	 * Create the Anubis key schedule for a given cipher key.
		*
	 * @param Key The 32N-bit cipher key.
	 */
	var keySetup = function(key) {
		
		//determine the N length parameter:
		var N = key.length / 4; // consider only the first 4 * N octets
		if (parseInt(N) != N || N < 4 || N > 10) {
			throw new Error("Invalid Anubis key size: " + (32 * N) + " bits.");
		}
		
		//arrays of size $N
		var kappa = [];
		var inter = [];
		var v, i, r, t, pos;
		
		//determine number of rounds from key size:
		var R = 8 + N;
		
		
		//map byte array cipher key to initial key state (mu):
		for (i = 0, pos = 0; i < N; i++) {
			kappa[i] =
			((ord(key[pos++])       ) << 24) ^
			((ord(key[pos++]) & 0xff) << 16) ^
			((ord(key[pos++]) & 0xff) <<  8) ^
			((ord(key[pos++]) & 0xff)      );
		}
		
		
		//generate R + 1 round keys:
		for (r = 0; r <= R; r++) {
			//generate r-th round key K^r:
			var K0 = T4[rot(kappa[N - 1], 24)       ];
			var K1 = T4[rot(kappa[N - 1], 16) & 0xff];
			var K2 = T4[rot(kappa[N - 1],  8) & 0xff];
			var K3 = T4[   (kappa[N - 1]    ) & 0xff];
			
			
			for (t = N - 2; t >= 0; t--) {
				K0 = T4[rot(kappa[t], 24)] ^
				(T5[rot(K0, 24)       ] & 0xff000000) ^
				(T5[rot(K0, 16) & 0xff] & 0x00ff0000) ^
				(T5[rot(K0,  8) & 0xff] & 0x0000ff00) ^
				(T5[   (K0    ) & 0xff] & 0x000000ff);
				
				K1 = T4[rot(kappa[t], 16) & 0xff] ^
				(T5[rot(K1, 24)       ] & 0xff000000) ^
				(T5[rot(K1, 16) & 0xff] & 0x00ff0000) ^
				(T5[rot(K1,  8) & 0xff] & 0x0000ff00) ^
				(T5[   (K1    ) & 0xff] & 0x000000ff);
				
				K2 = T4[rot(kappa[t], 8) & 0xff] ^
				(T5[rot(K2, 24)       ] & 0xff000000) ^
				(T5[rot(K2, 16) & 0xff] & 0x00ff0000) ^
				(T5[rot(K2,  8) & 0xff] & 0x0000ff00) ^
				(T5[   (K2    ) & 0xff] & 0x000000ff);
				
				K3 = T4[          (kappa[t]) & 0xff] ^
				(T5[rot(K3, 24)       ] & 0xff000000) ^
				(T5[rot(K3, 16) & 0xff] & 0x00ff0000) ^
				(T5[rot(K3,  8) & 0xff] & 0x0000ff00) ^
				(T5[   (K3    ) & 0xff] & 0x000000ff);
			}
			
			
			roundKeyEnc[r] = [];
			
			roundKeyEnc[r][0] = K0;
			roundKeyEnc[r][1] = K1;
			roundKeyEnc[r][2] = K2;
			roundKeyEnc[r][3] = K3;
			
			
			//compute kappa ^ (r + ) from kappa ^ r:
			for (i = 0; i < N; i++) {
				inter[i] =
					T0[rot(kappa[i], 24)] ^
					T1[rot(kappa[(N + i - 1) % N], 16) & 0xff] ^
					T2[rot(kappa[(N + i - 2) % N],  8) & 0xff] ^
					T3[   (kappa[(N + i - 3) % N]    ) & 0xff];
			}
			
			kappa[0] =
				(T0[4 * r    ] & 0xff000000) ^
				(T1[4 * r + 1] & 0x00ff0000) ^
				(T2[4 * r + 2] & 0x0000ff00) ^
				(T3[4 * r + 3] & 0x000000ff) ^
				inter[0];
			
			for (i = 1; i < N; i++) {
				kappa[i] = inter[i];
			}
		}
		
		
		//generate inverse key schedule:
		//K'^0 = K^R, K'^R = K^0, K'^r = theta(K^{R-r}):
		roundKeyDec[0] = [];
		roundKeyDec[R] = [];
		
		for (i = 0; i < 4; i++) {
			roundKeyDec[0][i] = roundKeyEnc[R][i];
			roundKeyDec[R][i] = roundKeyEnc[0][i];
		}
		
		
		for (r = 1; r < R; r++) {
			roundKeyDec[r] = [];
			
			for (i = 0; i < 4; i++) {
				v = roundKeyEnc[R - r][i];
				
				roundKeyDec[r][i] =
				T0[T4[rot(v, 24)       ] & 0xff] ^
				T1[T4[rot(v, 16) & 0xff] & 0xff] ^
				T2[T4[rot(v,  8) & 0xff] & 0xff] ^
				T3[T4[   (v    ) & 0xff] & 0xff];
			}
		}
	}
	
	

	/**
	 * Split data into 128 bit blocks. Note that as this cypher is block
	 * cypher then source dataset should be multiple of 16 octets, so source
	 * dataset will be appended with random octets to proper length, last
	 * octet will tell how many octets was added. If source length is
	 * multiple of 16 than one block will be added with chr(16) at the end.
		*
	 * @param string $data The data buffer.
	 * @param bool $append_block If TRUE (default) then last block will be
	 *                           appended as described above. If FALSE then
	 *                           last block will be left untouched. You need
	 *                           to set it FALSE wlile perform decrypt
	 *                           routine.
	 * @return array Array of 128-bit blocks.
	 */
	var dataPrepare = function (data, append_block) {
		if(append_block == undefined) {
			append_block = true;
		}
		
		var blocks = [];
		var blocks_count = Math.ceil(data.length / 16);
		
		for (var i = 0; i < blocks_count; i++) {
			blocks.push(data.substr(i * 16, 16));
		}
		
		//append block to observe 16 octets length
		if (append_block) {
			//length of last block if there is one or 16 to add empty block
			//below
			var block_len = 16;
			
			if (blocks.length > 0) {
				block_len = blocks[blocks_count - 1].length;
			}
			
			//as last block is 16 bytes length we need to add one more block to
			//make last byte of message always point to added bytes length
			if (block_len == 16) {
				blocks.push('');
				block_len = 0;
				blocks_count++;
			}
			
			//append last block with random octets if it is less than 128 bit
			//last octet will tell how many octets added
			if (block_len < 16) {
				for (i = 0; i < 15 - block_len; i++) {
					blocks[blocks_count - 1] += String.fromCharCode(mt_rand(0, 255));
				}
				blocks[blocks_count - 1] += String.fromCharCode(i + 1);
			}
		}
		
		return blocks;
	}	
	
	/**
	 * Generate Initialisation Vector (IV) to use while encrypt data in
	 * Cipher Block Chaining (CBC) mode.
		*
	 * @result string 16 octets string containing IV.
	 */
	var generateIV = function() {
		//use KDF on time and random
		//return kdf(KDF_algo, microtime() +''+ mt_rand(), KDF_salt, 16);
		return kdf(KDF_algo, "6a28abc8be644423521a511c071b2a8e", KDF_salt, 16);
	}
	
	/**
	 * Key derivation function (HMAC).
		*
	 * @param string $algo Hash algorithm.
	 * @param string $P Password.
	 * @param string $S Salt.
	 * @param int $dkLen Derived key length (in octets).
	 * @return string Derived key.
	 */
	var kdf = function (algo, P, S, dkLen) {
		var DK = '';
		
		while (DK.length < dkLen) {
			DK = DK + '' + hash_hmac(algo, DK + '' + P, S);
		}
		DK = DK.substr(0, dkLen);
		return DK;
	}
	
	/**
	 * Either encrypt or decrypt a data block, according to the key
	 * schedule.
		*
	 * @param string $block The data block to be encrypted/decrypted (16
	 *                      octets).
	 * @param array  $roundKey The key schedule to be used.
	 */
	var crypt = function (block, roundKey) {
		var state = [];
		var inter = [];
		var R = roundKey.length - 1; // number of rounds

		var i, r, pos, w;
		
		//map byte array block to cipher state (mu)
		//and add initial round key (sigma[K^0]):
		for (i = 0, pos = 0; i < 4; i++) {
			state[i] =
				((ord(block[pos++])       ) << 24) ^
				((ord(block[pos++]) & 0xff) << 16) ^
				((ord(block[pos++]) & 0xff) <<  8) ^
				((ord(block[pos++]) & 0xff)      ) ^
				roundKey[0][i];
		}

		//R - 1 full rounds:
		for (r = 1; r < R; r++) {
			inter[0] =
				T0[rot(state[0], 24)] ^
				T1[rot(state[1], 24)] ^
				T2[rot(state[2], 24)] ^
				T3[rot(state[3], 24)] ^
				roundKey[r][0];

			inter[1] =
				T0[rot(state[0], 16) & 0xff] ^
				T1[rot(state[1], 16) & 0xff] ^
				T2[rot(state[2], 16) & 0xff] ^
				T3[rot(state[3], 16) & 0xff] ^
				roundKey[r][1];
			
			inter[2] =
				T0[rot(state[0],  8) & 0xff] ^
				T1[rot(state[1],  8) & 0xff] ^
				T2[rot(state[2],  8) & 0xff] ^
				T3[rot(state[3],  8) & 0xff] ^
				roundKey[r][2];
			
			inter[3] =
				T0[(state[0]) & 0xff] ^
				T1[(state[1]) & 0xff] ^
				T2[(state[2]) & 0xff] ^
				T3[(state[3]) & 0xff] ^
				roundKey[r][3];
			
			for (i = 0; i < 4; i++) {
				state[i] = inter[i];
			}
		}
		
		//last round:
		inter[0] =
			(T0[rot(state[0], 24)] & 0xff000000) ^
			(T1[rot(state[1], 24)] & 0x00ff0000) ^
			(T2[rot(state[2], 24)] & 0x0000ff00) ^
			(T3[rot(state[3], 24)] & 0x000000ff) ^
			roundKey[R][0];
		
		inter[1] =
			(T0[rot(state[0], 16) & 0xff] & 0xff000000) ^
			(T1[rot(state[1], 16) & 0xff] & 0x00ff0000) ^
			(T2[rot(state[2], 16) & 0xff] & 0x0000ff00) ^
			(T3[rot(state[3], 16) & 0xff] & 0x000000ff) ^
			roundKey[R][1];
		
		inter[2] =
			(T0[rot(state[0],  8) & 0xff] & 0xff000000) ^
			(T1[rot(state[1],  8) & 0xff] & 0x00ff0000) ^
			(T2[rot(state[2],  8) & 0xff] & 0x0000ff00) ^
			(T3[rot(state[3],  8) & 0xff] & 0x000000ff) ^
			roundKey[R][2];
		
		inter[3] =
			(T0[state[0] & 0xff] & 0xff000000) ^
			(T1[state[1] & 0xff] & 0x00ff0000) ^
			(T2[state[2] & 0xff] & 0x0000ff00) ^
			(T3[state[3] & 0xff] & 0x000000ff) ^
			roundKey[R][3];

		function fixedFromCharCode (codePt) {  
			if (codePt > 0x00FF || codePt < 0x0) {
				codePt = codePt % 0x100;
				if(codePt < 0x0) {
					codePt = codePt - 0xFF00;
				}
				return String.fromCharCode(codePt);
			} else {
				return String.fromCharCode(codePt);  
			}
		}

		block = "";
		
		//map cipher state to byte array block (mu^{-1}):
		for (i = 0, pos = 0; i < 4; i++) {
			w = inter[i];
			block += fixedFromCharCode(w >> 24);
			block += fixedFromCharCode(w >> 16);
			block += fixedFromCharCode(w >>  8);
			block += fixedFromCharCode(w);
		}

		return block;
	}

	function convert(input) {
		var output = '', i;  
		
		for (i=0; i < input.length; i++) {
			output +=input[i].charCodeAt(0).toString(2);
		}
		return output;
	}
		
	
	function microtime (get_as_float) {
		var now = new Date().getTime() / 1000;
		var s = parseInt(now, 10);
		
		return (get_as_float) ? now : (Math.round((now - s) * 1000) / 1000) + ' ' + s;
	}


	function ord(str) {
		var ch = str.charCodeAt(0);
		if (ch>0xFF) ch-=0x350;
		return ch;
	}

	function mt_rand (min, max) {
		var argc = arguments.length;
		if (argc === 0) {
			min = 0;
			max = 2147483647;
		}
		else if (argc === 1) {
			throw new Error('Warning: mt_rand() expects exactly 2 parameters, 1 given');
		}
		else {
			min = parseInt(min, 10);
			max = parseInt(max, 10);
		}
		return Math.floor(Math.random() * (max - min + 1)) + min;
	}
	
	
	function hash_hmac(algo, data, key) {
		var hash = CryptoJS.HmacSHA256(data, key);
			hash = hash.toString(CryptoJS.enc.Hex);

		for(var i = 0, output = ''; i < hash.length; i+=2) {
			output += String.fromCharCode(parseInt(hash.substr(i, 2), 16));
		}

		return output;
	}
	
	function substr (str, start, len) {		
		var i = 0,
		allBMP = true,
		es = 0,
		el = 0,
		se = 0,
		ret = '';
		str += '';
		var end = str.length;
		
		if (start < 0) {
			start += end;
		}
		
		end = typeof len === 'undefined' ? end : (len < 0 ? len + end : len + start);
		return start >= str.length || start < 0 || start > end ? !1 : str.slice(start, end);
	}

	function encodeToHex(str){
		var i, l, o = '', n;
		str += '';

		for (i = 0, l = str.length; i < l; i++) {
			n = str.charCodeAt(i)
				 .toString(16);
			o += n.length < 2 ? '0' + n : n;
		}

		return o;
	}
	
	
	function decodeFromHex(str){
		var bytes = [];
		for(var i=0; i< str.length-1; i+=2) bytes.push(parseInt(str.substr(i, 2), 16));
		return String.fromCharCode.apply(String, bytes);
	}
	
	return {
		 /**
		  * Assign key. You can use binary key of length 128, 160, 192, 224, 256,
		  * 288, or 320 bit or simple string of text of arbitrary length. If you
		  * use simple text key then it will be converted to acceptable length
		  * random-like byte-string using key derivation function.
		  * If you use binary keys, you must use byte string of correct length.
			 *
		  * @param string Key Key to encode data.
		  * @param bool $raw_key If set to TRUE then Key is byte string with
		  *                      correct key.
		  */
		setKey: function(key, raw_key) {
			if(raw_key == undefined || raw_key == false) {
				key = keyPrepare(key);
			}
			
			return keySetup(key);
		},
		
		/**
		 * Encrypt data. Note that result is always bigger than source. First 16
		 * octets in the result set is Initialisation vector (IV) we need to
		 * implement Cipher Block Chaining (CBC) encryption method.
			*
		 * @param string $data The data string to be encrypted.
		 * @return string Encrypted data as raw byte string.
		 */
		encrypt: function(data, hex, b64) {
			if(b64 != undefined && b64)  var blocks = dataPrepare(Base64.encode(data));
			else var blocks = dataPrepare(data);
			
 			//Initialisation Vector (IV)
			var register = generateIV();
			var cypher = register;
			
			for(var i=0; i < blocks.length; i++) {
				for(var w=0, xor = ''; w < register.length && w < blocks[i].length; w++) {
					xor += String.fromCharCode(register.charCodeAt(w) ^ blocks[i].charCodeAt(w));
				}
				register = crypt(xor, roundKeyEnc);
				cypher += register;
			}

			if(hex != undefined && hex) return encodeToHex(cypher);
			
			return cypher;
		},
		
		 /**
		  * Decrypt data.
			 *
		  * @param string $data The data string to be decrypted.
		  * @return string Decrypted data.
		  */
		decrypt : function (data, hex, b64) {
			if(hex != undefined && hex) data = decodeFromHex(data);
			
			var blocks = dataPrepare(data, false);
			
			//first block is Initialization Vector (IV)
			var register = blocks.shift();

			var decrypted = '';
			
		
			for(var i=0; i < blocks.length; i++) {

				var crypted = crypt(blocks[i], roundKeyDec);
				
				for(var w=0, xor = ''; w < register.length && w < crypted.length; w++) {
					xor += String.fromCharCode(register.charCodeAt(w) ^ crypted.charCodeAt(w));
				}
				
				decrypted += xor;
				register = blocks[i];
			}

			//as last octet represents count of added octets to match required
			//message length, take it and cut message to initial length
			decrypted = substr(decrypted, 0, -ord(substr(decrypted, -1, 1)));

			if(b64 != undefined && b64) return Base64.decode(decrypted);
			
			return decrypted;
		}
	}
};
