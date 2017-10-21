function factorial (n) {
  if (n === 1 || n === 0) return 1
  else return n * factorial(n - 1)
}

console.log(factorial(10)) // 3,628,800


function fibonacci (n) {
	if (n === 0) { return 0 }
	if (n === 1) { return 1 }
	return fibonacci(n - 1) + fibonacci(n - 2)
}
