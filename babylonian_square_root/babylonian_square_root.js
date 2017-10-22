function squareRoot(num) {
  const e = 0.00000001;
  let x = num;
  let y = 1;

  while(x - y > e) {
    x = (x + y) / 2;
    y = num / x;
  }

  return x;
}

console.log(squareRoot(5));
