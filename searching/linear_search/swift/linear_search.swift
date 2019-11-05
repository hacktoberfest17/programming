
func linearSearch(arr: [Int], key: Int) -> Int {
    for(idx, element) in arr.enumerated() {
        if (element == key) {
            return idx
        }
    }
    return -1
}

// Could you use this way for readability
//func linearSearch(arr: [Int], key: Int) -> Int {
//    return arr.enumerated().filter { $1 == key }.first?.offset ?? -1
//}

let arr1 = [23,45,21,55,234,1,34,90]
let searchKey = 21
print("Key \(searchKey) found at index: \(linearSearch(arr: arr1, key: searchKey))")