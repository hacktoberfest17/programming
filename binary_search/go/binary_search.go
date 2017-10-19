package main

import "fmt"

func binarySearch(array []int, num int) int {

	var low, high int
	low = array[0]
	high = array[len(array)-1]

	if num > high || num < low {
		return -1
	}

	for low <= high {
		mid := low + (high-low)/2
		switch {
		case num < array[mid]:
			high = mid - 1

		case num > array[mid]:
			low = mid + 1

		case num == array[mid]:
			return mid
		}
	}
	return -1
}

func main() {

	fmt.Println("Binary search:")
	array := []int{0, 2, 4, 6, 8, 10, 12, 14, 16, 18}
	index := binarySearch(array, 10)
	if index == -1 {
		fmt.Println("Number not found")
	} else {
		fmt.Println("Index: ", index)
		fmt.Println("array[", index, "] = ", array[index])
	}
}
