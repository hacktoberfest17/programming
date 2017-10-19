package main

import "fmt"

func fibonacci() func() int {
	a, b := 0, 1
	return func() int {
		a = a + b
		a, b = b, a
		return a
	}
}

func main() {
	var n int
	fmt.Print("Enter the number of terms: ")
	fmt.Scanf("%d", &n)

	f := fibonacci()
	var fib int
	fmt.Print("Fibonacci Series: ")
	for i := 0; i < n; i++ {
		fmt.Printf("%d, ", fib)
		fib = f()
	}
}
