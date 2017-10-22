//example usage go run pwgen.go 6
//prints a password with a length of 6
package main

import (
	"fmt"
	"math/rand"
	"os"
	"strconv"
)

const charset = "abcdefghijklmnopqrstuvwxyz" +
	"ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

func main() {
	if len(os.Args) != 2 {
		panic("needs just 1 argument")
	}
	arg, err := strconv.Atoi(os.Args[1])
	if err != nil {
		panic("needs to be an positive integer")
	}
	fmt.Println(generatePW(arg))
}

func generatePW(length int) string {
	b := make([]byte, length)
	for i := range b {
		var randSeed = rand.Intn(len(charset))
		b[i] = charset[randSeed]
	}
	return string(b)
}
