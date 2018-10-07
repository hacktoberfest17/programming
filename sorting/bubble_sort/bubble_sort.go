package main

import (
	"fmt"
)

func main() {
	arr := []int{10, 9, 9, 8, 7, 5, 23, 123, 1, 23, 1, 7, 99, 0}
	bubbleSort(arr)

	fmt.Println(arr)
}

func bubbleSort(lst []int) {
	for i := range lst {
		max := i
		for j := range lst {
			if j > i && lst[j] >= lst[max] {
				max = j
			}

		}

		if max >= i {
			lst[i], lst[max] = lst[max], lst[i]
		}
	}
}
