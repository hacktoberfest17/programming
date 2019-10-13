func fib(_ num: Int) -> Int {
    if num == 0 {
        print("Enter a digit greater than 0")
        return 1
    }
    else if num == 1{
        print("Fibonacci: 0")
        return 1
    }

    else {
        var f = 0
        var f2 = 1
        var ftemp = 0
        print("Fibonacci: \(f), \(f2)", terminator:"")
        for _ in 1...num-2 {
            print(", \(f + f2)", terminator:"")
            ftemp = f + f2
            f = f2
            f2 = ftemp
        }
        print()
        return f2
    }

}

print("Enter number of Fibonacci terms: ")
let input = Int(readLine()!)
print("Nth Fibonacci number is \(fib(input!))")