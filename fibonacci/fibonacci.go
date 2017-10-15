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
    fmt.Print("Enter value: ")
    fmt.Scanf("%d", &n)

    f := fibonacci()
    var fib int
    for i := 0; i < n; i++ {
        fib = f()
        fmt.Printf("%d, ", fib)
    }
    fmt.Printf("\nfib(%d) = %d\n", n, fib)
}
