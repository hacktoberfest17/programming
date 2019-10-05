function ccipher(str) { 
   
  var ans = "";
  var charCode = 0;
  
  for (var i = 0; i < str.length; i++) {
    charCode = str.charCodeAt(i);
    if (charCode >= 65 && charCode < 78) {
      ans += (String.fromCharCode(charCode + 13));
    } else if (charCode >= 78 && charCode <= 90) {
      ans += (String.fromCharCode(charCode - 13));
    } else {
      ans += (str[i]);
    } 
  } return ans;
}


// In response to issue # 1211
