# Given a rectangular matrix of characters, add a border of asterisks(*) to it.

# Example

# For

# picture = ["abc",
#            "ded"]
# the output should be

# addBorder(picture) = ["*****",
#                       "*abc*",
#                       "*ded*",
#                       "*****"]

def addBorder(picture):
    count  = len(picture[0])+2
    columns = len(picture[0])
    rows = len(picture)

    a = count* "*"
    j=1
    for i in range(0, rows):
        str = picture[i]
        str = "*" + str + "*"
        picture[i] = str
                
    picture = [a] + picture + [a]
    return picture

def addBorder(picture):
    count  = len(picture[0])+2
    
    return [count*"*"]+[i.center(count, '*') for i in picture]+[count*"*"]
  