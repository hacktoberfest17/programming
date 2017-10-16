func fib(_ num: Int) {
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
		for _ in 0...num-3 {
			print(", \(f + f2)", terminator:"")
			ftemp = f + f2
			f = f2
			f2 = ftemp
		}
	}
}

print("Enter number of Fibonacci terms: ")
let input = Int(readLine()!)
fib(input!)
