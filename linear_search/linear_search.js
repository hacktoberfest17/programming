/**
  * Linear search implementation in JavaScript.
  * @param {array} arr - input array
  * @param {any} ele - element to search for
  * @return {number} - index of the first occurrence of @ele if it exists, -1 otherwise
  */
function linearSearch(arr, ele) {
  if (arr === null || arr.length === 0) return -1;

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === ele) return i;
  }
  return -1;
}
