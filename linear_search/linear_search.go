/* An implementation of Linear Search in Golang */

package main

import "fmt"

func linearSearch(array []int, num int) int {
	for i, item := range array {
		if item == num {
			return i
		}
	}
	return -1
}

func main() {

	fmt.Println("Linear search:")
	array := []int{0, 2, 4, 6, 8, 10, 12, 14, 16, 18}
	index := linearSearch(array, 10)
	if index == -1 {
		fmt.Println("Number not found")
	} else {
		fmt.Println("Index: ", index)
		fmt.Println("array[", index, "] = ", array[index])
	}
}
