const fibs = new Map();
fibs.set(0, 1);
fibs.set(1,1);

/**
 * Get fibonacci number at a particular place.
 *
 * @param {number} place
 * @return {number}
 */
function fib(place) {
  if (fibs.has(place)) {
    return fibs.get(place);
  }
  const f = fib(place  - 2) + fib(place - 1);
  fibs.set(place, f);
  return f;
}

function main() {
  for(let i = 1; i < Math.random() * 1000; i++) {
    console.log(fib(i));
  }
}

main();
