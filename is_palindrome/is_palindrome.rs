/*	Created by Duncan Bristow
	To Compile: 'rustc is_palindrome.rs' and run is_palindrome.exe
*/

use std::io;
use std::io::Write;
use std::string;

fn main() {
	let mut input = String::new();

	println!("Note: unicode combining characters will erroneously return a false value.");
	print!("Please input a word to test if it is a palindrome\n> ");
	io::stdout().flush().ok().expect("Could not flush stdout");

	io::stdin().read_line(&mut input)
		.expect("Failed to read line");

	// Remove the newline character
	input = String::from(input.trim());

	print!("{} is ", input);
	if !is_palindrome(input.clone()) {
		print!("not ");
	}
	println!("a palindrome");
}

fn is_palindrome(word: string::String) -> bool {
	// Reversing the string destroys the original, so we need to create a clone.
	let step = word.clone();
	word == step.chars().rev().collect::<String>()
}
