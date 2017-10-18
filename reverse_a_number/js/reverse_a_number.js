/**
 * Reverse a string/number in javascript
 * @param {any} string
 * @returns {string}
 */
exports.reverse = (string) => {
  if (!string || !string.length) {
    return "";
  }
  return reverse(str.substr(1)) + str.charAt(0);
};
