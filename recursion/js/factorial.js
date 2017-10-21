function factorial (n) {
  if (n === 1 || n === 0) return 1
  else return n * factorial(n - 1)
}

console.log(factorial(10)) // 3,628,800