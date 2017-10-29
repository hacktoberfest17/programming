// Map applies the passed function to all the elements in an array
// Returns a new array with the results
function map (arr, fn) {
  let result = new Array(arr.length)

  // We can also use the forEach method
  for (let i = arr.length - 1; i >= 0; i--) {
    result[i] = fn(arr[i])
  }

  return result
}

// Simple array to work on
let arr = [1, 2, 3, 4]

function square (x) {
  return x * x
}

console.log(`The squares of ${arr} are ${map(arr, square)}`)
