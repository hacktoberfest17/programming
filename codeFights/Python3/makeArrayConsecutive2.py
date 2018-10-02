#Alternate Solution
# max(statues) - min(statues) - len(statues) + 1

def makeArrayConsecutive2(statues):
    finalSize = 0
    
    minNum = min(statues)
    maxNum = max(statues)
    
    finalList = [i for i in range(minNum, maxNum+1)]
    print(finalList)

    l = list(set(finalList) - set(statues))
    print(l)

    return len(l)

def practice(statues):
	return len(list(set([i for i in range(min(statues), max(statues)+1)])-set(statues)))

# print(makeArrayConsecutive2([1,2,3,4,7]))

# print(makeArrayConsecutive2([6,2,3,8]))

print(practice([6,2,3,8]))