# def almostIncreasingSequence(sequence):
# 	n = 0
# 	m = sequence[0]
# 	length = len(sequence)

# 	for i in range(1 , length):
# 		if sequence[i] > m:
# 			m = sequence[i]
# 		else:
# 			n+=1
# 			m = sequence[i]

# 		if n is 2:
# 			return False

# 	return True

def almostIncreasingSequence(sequence):
    n = 0
    max = sequence[0]
    other = []
    length = len(sequence)
    
    for i in range(1, length):
        if sequence[i]>max:
            max = sequence[i]
        else:
            sequence.pop(i-1)
            break
    print(sequence)
    print(other)
    for i in range(0, length):
    	try:
    		if sequence[i+1] > sequence[i]:
    			continue
    		else:
    			return False
    	except IndexError:
    		pass
    	
    
    return True



print(almostIncreasingSequence([1,3,2,1]))
# print(almostIncreasingSequence([1,3,2,4]))
# print(almostIncreasingSequence([1,2]))
# print(almostIncreasingSequence([1,2,2,2,5,6,2]))
# print(almostIncreasingSequence([10,1,2,3]))
# print(almostIncreasingSequence([40,50,60,10,20,30]))
