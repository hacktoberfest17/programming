import Foundation

func bubbleSort(_ array: [Int]) -> [Int] {
    var sortedArray = NSMutableArray(array: array)
    var sortedAboveIndex = array.count
    var swaps = 0
    
    repeat {
        var lastSwapIndex = 0
        
        for i in 1..<sortedAboveIndex {
            if (sortedArray[i - 1] as! Int) > (sortedArray[i] as! Int) {
                sortedArray.exchangeObject(at: i, withObjectAt: i-1)
                lastSwapIndex = i
                swaps += 1
            }
        }
        
        sortedAboveIndex = lastSwapIndex
        
    } while (sortedAboveIndex != 0)
    
    return sortedArray
}
