// generates and returns the first 100 multiples of n in an array of length 101

function generateMultiples(n) {
	var multiples = [];
  
	var lengthOfArray = 101;
	for(var i = 0; i < lengthOfArray; i++) {
		multiples.push(n*i);
	}

	return multiples;
}