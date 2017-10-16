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
	fmt.Println(factorial(5))
}
