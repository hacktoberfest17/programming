use std::io;

fn gcd(mut m : i32, mut n : i32) -> i32 {

  let mut r;

  while n != 0 {
    r = m % n;
    m = n;
    n = r;
  }

  return m;
}

fn main() {

  println!("Please enter a number.");
  let mut m = String::new();
  io::stdin().read_line(&mut m).expect("Failed to read input.");
  let m: i32 = m.trim().parse().expect("Failed to parse m.");

  println!("Please enter second number.");
  let mut n = String::new();
  io::stdin().read_line(&mut n).expect("Failed to read input.");
  let n: i32 = n.trim().parse().expect("Failed to parse n.");

  println!("The GCD of {} and {} is {}.", m, n, gcd(m,n));

}
