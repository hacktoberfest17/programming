/*
 - Author:
 Sudesh Gutta
*/

// While
var i = 1
while i <= 10 {
    print(i)
    i = i + 1
}

// Repeat
i = 1
repeat {
    print(i)
    i = i + 1
} while i < 10

// For
for _ in 1...10 {
    print("Hello World")
}
// prints 1-10
for i in 1...10 {
    print(i)
}

// prints 0-9
for i in 0..<10 {
    print(i)
}

// Use .reversed function to range in reverse order else it'll crash
for i in (1...10).reversed() {
    print(i)
}

// Stride returns a sequence of values
stride(from: 1, to: 10, by: 2)

