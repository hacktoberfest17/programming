package main

import "fmt"

func fact(i int) int {

    if(i == 1) {
        return 1
    } else {
        return i * fact(i-1)
    }
}

func main() {

    var input int;
    fmt.Scan(&input)
    var output int = fact(input)
    fmt.Print(output,"\n")
}
