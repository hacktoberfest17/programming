/*	Created by Duncan Bristow, based on factorial.js
	To compile: 'rustc factorial.rs' and run factorial.exe	
*/

use std::io;
use std::io::Write;
use std::process::exit;

fn main() {
	let mut input = String::new();

	println!("Please note: Numbers larger than 20 will cause a panic.");
	print!("Input a number to compute the factorial of\n> ");
	io::stdout().flush().ok().expect("Could not flush stdout");
	io::stdin().read_line(&mut input)
		.expect("Failed to read line");

	// Remove the newline character
	input.pop();

	let input_num: usize = match input.trim().parse() {
		Ok(num) => num,
		Err(_) => { println!("Invalid number: {}",input); exit(1); },
	};

	println!("{}",factorial(input_num));
}

fn factorial(n: usize) -> usize {
	if n == 0 {
		return 1 as usize;
	} else {
		return n * factorial(n-1);
	}
}
