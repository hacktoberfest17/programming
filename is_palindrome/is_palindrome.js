function isPalindrome(str) {
  let strArr = str.split('').reverse();
  return str === strArr.join('');
}
