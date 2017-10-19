function isPrime(number){
	let x = number -1;
	while(x > 1){
		if((number % x)== 0) return false;
		x--;
	}
	return true;
}