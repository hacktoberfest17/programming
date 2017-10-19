package main

import (
	"fmt"
)

func factorial(number int) int {
	if number > 1 {
		return number * factorial(number-1)
	}
	return 1
}

func main() {
	var n int
	fmt.Print("Enter a number: ")
	fmt.Scanf("%d", &n)
	fmt.Printf("(%d)! = %d\n", n, factorial(n))
}
