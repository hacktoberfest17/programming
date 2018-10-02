# def reverseParentheses(s):
#     l = [i for i in s]
#     newL = []
#     leftBCount = (s.count('('))
#     hashCount = 0
#     while hashCount is not leftBCount:
#         leftBrc = s.rfind('(')
#         rightBrc = s.find(')')
#         str = s[leftBrc:rightBrc+1]
#         s = s.replace(str, '#')
#         hashCount+=1
#         newL.append(str)
#         # print(s, str)
    
#     print(s, newL)
#     newL = [i.replace('#', '') for i in newL]
#     print(newL)

# #Search for inner brace and then its closing one.
# #Reverse the string. append to list and # it.
# #Again do it until no ( remain
# #Keep removing off the list and changing hashes with the words from list


# def findOtherParan(s, indexOfLeftBrace):
#     for i in range(indexOfLeftBrace, len(s)):
#         if s[i] is ')':
#             return i
    
#     return -1

# def reverseParentheses(s):
#     newL = []
#     leftBCount = (s.count('('))
#     hashCount = 0
#     while hashCount is not leftBCount:
#         leftBrc = s.rfind('(')
#         rightBrc = findOtherParan(s, leftBrc)
#         str = s[leftBrc:rightBrc+1]
#         s = s.replace(str, '#')
#         hashCount+=1
#         newL.append(str)
#         newL = [i[::-1] for i in newL]


#     firstHash = s.find('#')
#     afterHash = s.rfind('#')
#     finalStr = s[0:firstHash+1]
    
#     while newL:
#         if '#' in finalStr:
#             st = ''
#             st = newL.pop(-1)
#             st = st[1:len(st)-1]
#             finalStr = finalStr.replace('#', st)
    
#     finalStr += s[afterHash+1:]
#     return finalStr.replace('#', '')
    

# def findOtherParan(s, indexOfLeftBrace):
#     for i in range(indexOfLeftBrace, len(s)):
#         if s[i] is ')':
#             return i
    
#     return -1

# def reverseParentheses(s):
#     a = True
#     while a:
#         leftBrc = s.rfind('(')
#         print(leftBrc)
#         if leftBrc is -1:
#             a = False
#             break
#         rightBrc = findOtherParan(s, leftBrc)
#         if rightBrc is -1:
#             a = False
#             break
#         print(rightBrc)
#         st = s[leftBrc:rightBrc+1]
#         print(st)
#         revSt = st[::-1]
#         s = s.replace(st, revSt)
    
#     return s


# print(reverseParentheses("ab(cde(fg)h)j"))

def findOtherParan(s, indexOfLeftBrace):
    for i in range(indexOfLeftBrace, len(s)):
        if s[i] is ')':
            return i
    
    return -1

def reverseParentheses(s):
    a = True
    while a:
        leftBrc = s.rfind('(')
        if leftBrc is -1:
            a = False
            break
        rightBrc = findOtherParan(s, leftBrc)
        if rightBrc is -1:
            a = False
            break
        st = s[leftBrc:rightBrc+1]
        print(st)
        revSt = st[::-1]
        revSt = revSt[1:len(st)-1]
        s = s.replace(st, revSt)
        print(s)
    
    s = s.replace(')', '')
    s = s.replace('(', '')
    return s