fn fib(n:u32) -> u32 {
    if n < 2 {
        return n;
    }
    return fib(n - 1) + fib(n - 2);
}

fn main() {
    use std::io::{stdin,stdout,Write};
    let n:u32;
    let mut input_text = String::new();
    print!("Enter the number of terms: ");
    let _=stdout().flush();
    stdin()
        .read_line(&mut input_text)
        .expect("failed to read from stdin");

    let trimmed = input_text.trim();
    match trimmed.parse::<u32>() {
        Ok(i) => n = i,
        Err(..) => {println!("this was not an integer: {}", trimmed);std::process::exit(1)}
    };
    
    print!("Fibonacci Series: ");
    for i in 0..n {
      print!("{}, ", fib(i));
    }
    println!();
}
