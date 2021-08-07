//: Playground - noun: a place where people can play
//  Created by Jose, Ann Catherine on 10/28/17.

import UIKit
import Foundation

/*
 Array Pair Sum problem
 Given an array of numbers and a Sum, findPairs function determines whether or not any two pairs in the array add up to the Sum
 Inspired by Google mock interview problem http://www.ardendertat.com/2011/09/17/programming-interview-questions-1-array-pair-sum/
 // and https://www.youtube.com/watch?v=XKu_SEDAykw
 */


class ArrayPairSum {
    enum algorithmType {
        case bruteForce
        case complements
        case twoIndices
    }

    enum Result {
        case NoPairs
        case PairFound(pairs: [Int])
    }

    static func findPairs(inArray array: [Int], withSum sum: Int, usingAlgoType algoType: algorithmType) -> Result {
        
        print("array = \(array). sum = \(sum)")
        switch algoType {
            
        // Brute force approach; loop through the array twice. Innefficient alogirthm since it loops twice
        // O (N * N)
        case .bruteForce:
            for i in 0 ..< array.count {
                for j in i+1 ..< array.count {
                    if array[i] + array[j] == sum {
                        return Result.PairFound(pairs: [array[i], array[j]])
                    }
                }
            }
            return Result.NoPairs
            
        case .complements:
            
            // As we go through the array,
            // O(N * log N)    n for the for loop; logn in for contains which could be a binary search
            var complements = [Int]()
            
            for num in array {
                // if this number is a complement of a previously seen number, then it will be in the complements array
                if complements.contains(num) {
                    return Result.PairFound(pairs: [sum - num, num])
                } else {
                    complements.append(sum - num)
                }
            }
            return Result.NoPairs
            
        case .twoIndices:
            
            // This approach uses two indices - low and high. Array should be sorted.
            //  Start with lowest index and highest index of the array;
            //    if the sum of elements at those indices == expected sum, Found the Pair
            //    if the sum is smaller than expected sum, increase the lower index.
            //    if the sum is bigger than expected sum, decrease the higher index.
            //  O(N) if the array is sroted.  Otherwise, O(N log N)
            var low = 0
            var high = array.count - 1
            
            while low < high {
                let currentSum = array[low] + array[high]
                // print("\tENTRY low = \(low). high = \(high). currentSum = \(currentSum)")
                if currentSum == sum {
                    return Result.PairFound(pairs: [array[low], array[high]])
                }
                if currentSum < sum {
                    low = low + 1
                } else {
                    high = high - 1
                }
                //print("\t EXIT low = \(low). high = \(high). currentSum = \(currentSum)")
            }
            return Result.NoPairs
        }
        
    }
}

let array1 = [1, 2, 3, 9]
let array2 = [1, 2, 4, 4]

// Brute force approach
ArrayPairSum.findPairs(inArray: array1, withSum: 8, usingAlgoType: .bruteForce)  // Result.NoPairs
ArrayPairSum.findPairs(inArray: array1, withSum: 5, usingAlgoType: .bruteForce)  // Result.PairsFound[2, 3]
ArrayPairSum.findPairs(inArray: array2, withSum: 8, usingAlgoType: .bruteForce)  // Result.PairsFound[4, 4]
ArrayPairSum.findPairs(inArray: array2, withSum: 5, usingAlgoType: .bruteForce)  // Result.PairsFound[1, 4]
ArrayPairSum.findPairs(inArray: array2, withSum: 10, usingAlgoType: .bruteForce) // Result.NoPairs

// Complements approach
ArrayPairSum.findPairs(inArray: array1, withSum: 8, usingAlgoType: .complements)  // Result.NoPairs
ArrayPairSum.findPairs(inArray: array1, withSum: 5, usingAlgoType: .complements)  // Result.PairsFound[2, 3]
ArrayPairSum.findPairs(inArray: array2, withSum: 8, usingAlgoType: .complements)  // Result.PairsFound[4, 4]
ArrayPairSum.findPairs(inArray: array2, withSum: 5, usingAlgoType: .complements)  // Result.PairsFound[1, 4]
ArrayPairSum.findPairs(inArray: array2, withSum: 10, usingAlgoType: .complements) // Result.NoPairs


// Two Indices approach
ArrayPairSum.findPairs(inArray: array1, withSum: 8, usingAlgoType: .twoIndices)  // Result.NoPairs
ArrayPairSum.findPairs(inArray: array1, withSum: 5, usingAlgoType: .twoIndices)  // Result.PairsFound[2, 3]
ArrayPairSum.findPairs(inArray: array2, withSum: 8, usingAlgoType: .twoIndices)  // Result.PairsFound[4, 4]
ArrayPairSum.findPairs(inArray: array2, withSum: 5, usingAlgoType: .twoIndices)  // Result.PairsFound[1, 4]
ArrayPairSum.findPairs(inArray: array2, withSum: 10, usingAlgoType: .twoIndices) // Result.NoPairs

