const fact = n => {
  let factArray = [1];
  for ( let i = 1; i <= n; i++ ) {
    factArray[i] = i * factArray[i-1];
  }
  return factArray[n];
}
