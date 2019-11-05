function reverse(num){
	return Number(num.toString().split("").reverse().join(""));
}


function isAdam(num) {
    var reverseNum = reverse(num),
		numSq = num*num,
		reverseNumSq = reverse(numSq),
		sqrtReverseNumsq = Math.sqrt(reverseNumSq);
	return reverseNum == sqrtReverseNumsq ? true : false; 
	
}

isAdam(12);
isAdam(11);
isAdam(10);
isAdam(9);