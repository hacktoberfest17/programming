# Given two strings, find the number of common characters between them.

# Example

# For s1 = "aabcc" and s2 = "adcaa", the output should be
# commonCharacterCount(s1, s2) = 3.

# Strings have 3 common characters - 2 "a"s and 1 "c".

from collections import Counter

def commonCharacterCount(s1, s2):
    c1 = Counter(s1)
    c2 = Counter(s2)
    print(c1)
    sum = 0
    for key in c1:
        c1Value = c1[key]
        if key in c2:
            tempVal = c2[key]
            if tempVal > c1Value:
                sum+= c1Value
            else:
                sum+= tempVal
    
    return sum
    
    
#Alternate solution
def commonCharactersCount(s1, s2):
    #Converted into set just to get the term to check in s2
    #Then compare both counts in s1/s2 and choose the min one.
    newList = [min(s1.count(i), s2.count(i)) for i in set(s1)]
    return sum(newList)
    #Return the sum of all the findings