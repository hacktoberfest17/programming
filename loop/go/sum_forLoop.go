package main

import "fmt"


func main() {

    var input int
    fmt.Scan(&input)
    
    var sum int

    for j := 1; j <= input; j++ {
            sum = sum + j
    }

    fmt.Println(sum)

}
