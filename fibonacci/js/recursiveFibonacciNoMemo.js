function recursiveFibonacciNoMemo(n) {
	// find nth fibonacci number recursively

	if(n == 0) {
		return 0;
	} else if(n <= 2) {
		return 1;
	}
	 return(recursiveFibonacciNoMemo(n-2) + recursiveFibonacciNoMemo(n-1));

}

console.log(recursiveFibonacciNoMemo(0));
console.log(recursiveFibonacciNoMemo(1));
console.log(recursiveFibonacciNoMemo(2));
console.log(recursiveFibonacciNoMemo(3));
console.log(recursiveFibonacciNoMemo(4));
console.log(recursiveFibonacciNoMemo(5));
console.log(recursiveFibonacciNoMemo(6));
console.log(recursiveFibonacciNoMemo(7));