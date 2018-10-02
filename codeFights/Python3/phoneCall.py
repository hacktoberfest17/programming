def phoneCall(min1, min2_10, min11, s):
    if s < min1:
        return 0
    s = s-min1
    nl = []
    if s==0 or s<0:
        return 1
    else:
        nl.append(1)
    s = s-min2_10*9
    if s<0:
        return sum(nl)+min2_10
    else:
        nl.append(9)
        
    s = int(s/min11)
    nl.append(s)
    
    return sum(nl)