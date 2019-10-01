use std::io::{stdin, stdout, Write};

/// Recursively prints out the rod placement of discs.
///
/// * `height` - Number of discs to use.
/// * `from` - Starting rod.
/// * `spare` - Temporary rod.
/// * `to` - End rod.
fn tower_of_hanoi(height: i32, from: &str, spare: &str, to: &str) {
    if height <= 1 {
        return println!("Move disc {} from rod {} to rod {}", height, from, to);
    }

    // Always keep `from` and `to` together when internally passing into `tower_of_hanoi`.
    tower_of_hanoi(height-1, from, to, spare);
    println!("Move disc {} from rod {} to rod {}", height, from, to);
    tower_of_hanoi(height-1, spare, from, to);
}

fn main() {
    let mut input_text = String::new();

    // Prompt for disc height.
    print!("Enter the number of discs:");
    stdout().flush();
    stdin()
        .read_line(&mut input_text)
        .expect("failed to read from stdin");

    match input_text.trim().parse::<i32>() {
        // Recursive Tower of Hanoi entry point.
        Ok(n) => tower_of_hanoi(n, "A", "B", "C"),
        Err(e) => println!("Error reading: {}", e),
    };
}
