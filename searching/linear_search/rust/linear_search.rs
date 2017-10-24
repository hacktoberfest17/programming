fn search(arr:[i32;5],key:i32) -> bool {
   for a in arr.iter() {
        if *a == key {
            return true;
        }
    }
    return false;
}

fn main() {

    // input_array
    let a: [i32; 5] = [1, 2, 3, 4, 5];
    
    println!("Found 5 in a: {}", search(a,5));
    println!("Found -5 in a: {}", search(a,-5));
    
}
