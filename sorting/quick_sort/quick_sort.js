/**
 * Sort an array using Quicksort
 *
 * @param {Array<any> arr}
 * @return {Array<any>}
 */
function quicksort(arr) {
  if (arr.length < 2) {
    return arr;
  }
  if (arr.length == 2) {
    if (arr[0] > arr[1]) {
     return [arr[0], arr[1]];
    }
  }
  const pivot = Math.ceil(Math.random() % arr.length);
  const l = [];
  const r = [];
  for (let i = 0; i < arr.length; i++) {
    if (i === pivot) continue;
    const p = arr[pivot];
    if (arr[i] < p) {
      l.push(arr[i]);
    } else {
      r.push(arr[i]);
    }
  }
  return [...quicksort(l), arr[pivot], ...quicksort(r)];
}

function main() {
  const foo = [1,31,9,45,120,6,1,2];
  console.log(quicksort(foo));
};

main();
