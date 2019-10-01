
const BLOCK_SIZE: usize = 128;

// Binary search over an array of 128 els.
// 
// Returns the first i such that
// block[i] >= target.
//
// # Assumes
// 
// That block is sorted, and that the last `doc` in 
// block is `>= target`.
// If none of the elements is greater than the last doc, 
// this function returns 127, which does not make much sense.
#[inline(never)]
fn binary_search(block: &[u32; BLOCK_SIZE], target: u32) -> usize {
    // Full block of 128 els.
    // 
    // We do a branchless, unrolled binary search.
    let mut start = 0;
    let mut half: usize = BLOCK_SIZE / 2;
    for _ in 0..7 {
        let middle = start + half;
        unsafe {
            let pivot: u32 = *block.get_unchecked(middle);
            asm!("cmpl $2, $1\ncmovge $3, $0"
                 : "+r"(start)
                 :  "r"(target),  "r"(pivot), "r"(middle))
                 ;
        }
        half /= 2;
    }
    start
}

fn main() {
    let mut arr = [0u32; 128];
    for i in 0..128 {
        arr[i] = i as u32;
    }
    for i in 0..129 {
        println!("{}", binary_search(&arr, i));    
    }
}
