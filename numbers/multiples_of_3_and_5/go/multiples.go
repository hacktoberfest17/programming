/* 
	Multiples of 3 and 5
	This program sums up all the multiples of 3 and 5 under 1000.
*/ 

package main

import "fmt"

func main() {
	sum := 0

	for i := 0; i < 1000; i++ {
		if i % 3 == 0 || i % 5 == 0 {
			sum += i
		}
	}

	fmt.Println(sum)
}


