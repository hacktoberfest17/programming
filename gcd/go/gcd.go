package main

import "fmt"

func gcd(a, b int) int {
	if b == 0 {
		return a
	} else {
		return gcd(b, a%b)
	}
}

func main() {
	fmt.Println("Please provide 2 numbers")
	fmt.Print("First number: ")
	var a int
	fmt.Scan(&a)
	fmt.Print("Second number: ")
	var b int
	fmt.Scan(&b)
	fmt.Printf("gcd(%d,%d)=%d\n", a, b, gcd(a, b))
}
