function recursiveFibonacciNoMemo(n) {
	// find nth fibonacci number recursively

	if(n == 0) {
		return 0;
	} else if(n <= 2) {
		return 1;
	}
	 return(recursiveFibonacciNoMemo(n-2) + recursiveFibonacciNoMemo(n-1));

}
