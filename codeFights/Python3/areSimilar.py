def areSimilar(a, b):
    if a==b:
        return True
    errorC = 0
    for i in range(0, len(a)):
        if a[i]==b[i]:
            continue
        else:
            if a[i]!=b[i]:
                if a[i] in b:
                    errorC+=1
                    index = b.index(a[i])
                    b[index]="#"
                    print(b)
                    if errorC==3:
                        return False
                    continue
                else:
                    return False
    
    return True


    # def areSimilar(a, b):
    # count = 0
    # for i in range(0, len(a)):
    #     if a[i]!=b[i]:
    #         count+=1
        
    # if count > 2:
    #     return False
    
    # a = sorted(a)
    # b = sorted(b)
    
    # for i in range(0, len(a)):
    #     if a[i]==b[i]:
    #         continue
    #     else:
    #         return False
        
    # return True