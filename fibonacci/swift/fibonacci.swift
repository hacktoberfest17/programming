class Fibonacci {

    func printFirst(n num: Int) {
        if num == 0 {
            print("Enter a digit greater than 0")
        }
        else if num == 1{
            print("Fibonacci: 0")
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
        }
    }

    func iterative(_ num: Int) -> Int {
        if num == 0 || num == 1 {
            return 1
        } else {
            var fibo = 1
            var helper = 0 
            for _ in 0..<num {
                swap(&fibo, &helper)
                fibo += helper
            }
            return fibo
        }
    }

    func recursive(_ num : Int) -> Int {
        if num == 0 || num == 1 {
            return 1
        } else {
            return self.recursive(num - 2) + self.recursive(num - 1)
        }
    }
}

print("Enter number of Fibonacci terms: ")
let input = Int(readLine()!)
if let input = input {
    Fibonacci().printFirst(n: input)
    print("Nth Fibonacci number is \(Fibonacci().iterative(input) )")
    print("Nth Fibonacci number (recursively) is \(Fibonacci().recursive(input) )")
} else {
    print("Not a valid number")
}
