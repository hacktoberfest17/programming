# Methods return True if the strings passed are anagram of each other.
# Note: Args expected are str ONLY

def anagram(s1,s2):    

    if len(s1) != len(s2):
        return False
    
    s1 = s1.lower()
    s2 = s2.lower()
    
    for i in s1:
        for j in s2:
            if i not in s2 or j not in s1:
                return False
        
    return True


def anagram_1(s1,s2):

    a = [ord(i) for i in s1]
    b = [ord(i) for i in s2]

    if sum(a) != sum(b):
        return False
    return True
    

def anagram_2(s1,s2):
    
    s1 = list(s1)
    s2 = list(s2)
    s1.sort()
    s2.sort()    
    if s1 == s2:
        return True
    return  False
