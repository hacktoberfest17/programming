function getPrimes (n){
  var arr = [] ;

  if(typeof n !== 'number'){
    return "Invalid type.";
  }else if( n < 2){
    return "Invalid input, number must be 2 or above.";
  }else if(Number(n) === n && n % 1 !== 0){
    return "Invalid type of float.";
  }else{
    for (var counter = 2; counter <= n; counter++){

      var not_prime = false;

      for (var div = 2; div <= (counter - 1); div++) {
        if (counter % div === 0) {
          not_prime = true;
        }
      }
      if (not_prime === false) {
        arr.push(counter);
      }
    }
    return arr;
  }	
}