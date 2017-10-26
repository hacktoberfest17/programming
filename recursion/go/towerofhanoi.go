package main

import "fmt"

func tower_of_hanoi(n int, from, to, aux string) {
	/*if only 1 disk, make the move and return*/
	if n == 1 {
		fmt.Printf("\nMove disk 1 from peg %v to peg %v", from, to)
		return
	}
	/*Move top n-1 disk from A to B, Using C as Auxilary*/
	tower_of_hanoi(n-1, from, aux, to)

	/*Move remaining disks from A to C*/
	fmt.Printf("\nMove disk %v from peg %v to peg %v", n, from, to)

	/*Move n-1 disks from B to C using A as auxiliary */
	tower_of_hanoi(n-1, aux, to, from)
}

func main() {
	/*calling the funcion with whatever value you want*/
	tower_of_hanoi(3, "A", "B", "C")
}
