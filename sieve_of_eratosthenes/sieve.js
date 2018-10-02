const rl = require('readline');

function sieve(n) {
  const keys = new Array(n).fill(true)

  for (let i = 2; i < Math.sqrt(n); i++) {
    if (keys[i]) {
      for (let j = Math.pow(i, 2); j < n; j += i) {
        keys[j] = false
      }
    }
  }

  return keys.reduce((acc, val, i) => [
    ...acc,
    ...(val ? [i] : [])
  ], []).slice(2);
}

// Quick n' dirty input
const input = rl.createInterface(process.stdin, process.stdout, null);
input.question("Get the primes up to: ", function(answer) {
  const primes = sieve(parseInt(answer));
  console.log(primes);
  input.close();
  process.stdin.destroy();
});