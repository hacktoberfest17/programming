# Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.

# Given a ticket number n, determine if it's lucky or not.

def isLucky(n):
    newList = [int(i) for i in str(n)]
    length = len(newList)
    firstHalf = newList[:int(length/2)]
    secondHalf = newList[int(length/2):]
    return sum(firstHalf) == sum(secondHalf)

def isLucky(n):
    newList = [int(i) for i in str(n)]
    length = int(len(newList))//2
    firstHalf = newList[:length]
    secondHalf = newList[length:]
    return sum(firstHalf) == sum(secondHalf)