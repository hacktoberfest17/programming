package main

import "fmt"

func fibo(n int) int {
  curr, prev := 0, 1
  if n == 0 || n == 1 {
    return n
  }
  for i := 0; i < n; i++{
    curr, prev = curr + prev, curr
  }
  return curr
}

func main()  {
  n := 10
  var p, p2 = "Enter the number of term to be printed: 10", "Output:"
  fmt.Println(p)
  fmt.Println(p2,fibo(n))
}
