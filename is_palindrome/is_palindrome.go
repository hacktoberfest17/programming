package main

import (
 "fmt"
)

func main() {
	//check function
	if(isPalindrome("mam")){
		fmt.Println("Palindrome checker worked!")
	}else{
		fmt.Println("Oops! there is a problem")
	}
 }

func isPalindrome(s string) bool {
	mid := len(s) / 2
	last := len(s) - 1
	for i := 0; i < mid; i++ {
		if s[i] != s[last-i] {
			return false
		}
	}
	return true
}
