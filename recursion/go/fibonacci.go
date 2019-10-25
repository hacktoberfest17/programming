package main

import (
	"fmt"
)

func fibonnaci(Number int) int {
	if Number == 0 {
		return Number
	}

	if Number == 1 {
		return Number
	}

	return fibonnaci(Number-1) + fibonnaci(Number-2)
}

func main() {
	fmt.Println("Enter a number:")
	var Number int
	_, err := fmt.Scanf("%d", &Number)

	if err == nil {
		fmt.Println(fibonnaci(Number))
	}
}
