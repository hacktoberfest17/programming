//: Playground - noun: a place where people can play

var A = [5,4,3,2,1]
var B: [Int] = []
var C: [Int] = []
var target: [Int]

func TowerOfHanoi(n: Int, source: inout [Int], target: inout [Int], auxiliary: inout [Int]) {
    if n > 0 {
        // Move n - 1 disks from source to auxiliary, so they are out of the way
        TowerOfHanoi(n: n-1, source: &source, target: &auxiliary, auxiliary: &target)
        // Move the nth disk from source to target
        target.append(source.popLast()!)
        // Display progress
        PrintTables()
        // Move the n - 1 disks that we left on auxiliary onto target
        TowerOfHanoi(n: n-1, source: &auxiliary, target: &target, auxiliary: &source)
    }
}

func PrintTables() {
    print(A,B,C)
}

PrintTables()
TowerOfHanoi(n: 5, source: &A, target: &B, auxiliary: &C)
