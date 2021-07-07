from collections import Counter
def palindromeRearranging(inputString):
    dic =  Counter(inputString)
    l = []
    for k,v in dic.items():
        l.append(v)
    errorC = 0 
    for i in l:
        if i%2==0:
            continue
        else:
            errorC+=1
            if errorC == 2:
                return False
    
    return True

#ALTERNATE SOLUTION
def palindromeRearranging(inputString):
    i = set(inputString)
    l = []
    for j in i:
        if inputString.count(j)%2==0:
            l.append(0)
        else:
            l.append(1)
            
    return sum(l)<=1

#BEST SOLUTION
def palindromeRearranging(inputString):

    return sum([inputString.count(i)%2 for i in set(inputString)]) <= 1