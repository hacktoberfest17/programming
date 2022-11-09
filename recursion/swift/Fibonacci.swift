var enterANumberToFindItsFibonacciNumber = 8

func fibonacci(n: Int) -> Int {
    
    if n == 0 {
        return 0
    } else if n == 1{
        return 1
    }
    
    return fibonacci(n: n - 1) + fibonacci(n: n - 2)
}

print("Fibonacci number of \(enterANumberToFindItsFibonacciNumber) is \(fibonacci(n: enterANumberToFindItsFibonacciNumber))")
