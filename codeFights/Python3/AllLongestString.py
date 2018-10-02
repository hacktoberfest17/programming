# Given an array of strings, return another array containing all of its longest strings.

# Example

# For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
# allLongestStrings(inputArray) = ["aba", "vcd", "aba"].

def allLongestStrings(inputArray):
    maxElement = len(max(inputArray))
    print(max(inputArray))
    newList = []
    j=0
    newList.append(inputArray[j])
    for i in range(1, len(inputArray)):
        c = len(inputArray[i])
        if c == len(newList[j]):
            newList.append(inputArray[i])
            j+=1
        elif c > len(newList[j]):
            newList = []
            j=0
            newList.append(inputArray[i])
            
    return newList

def allLongestStrings(inputArray):
    m = max(len(s) for s in inputArray)
    r = [s for s in inputArray if len(s) == m]
    return r
