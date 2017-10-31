const calcPrimes = (limit) => {
  const primes = [];

  for (let i = 2; i < limit; i++) {
    for (let j = 2; j <= i; j++) {
      if (i % j === 0 && i != j) {
        break;
      }

      if (i === j) {
        primes.push(i);
      }
    }
  }

  console.log(primes);
}

calcPrimes(100);
