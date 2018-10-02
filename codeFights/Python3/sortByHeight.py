# Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees.

# Example

# For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
# sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].


def sortByHeight(a):

    newList = sorted([i for i in a if i is not -1], reverse=True)

    for i in range(len(a)):
        if a[i]== -1:
            continue
        else:
            a[i] = newList.pop()
            
    return a

#YOU MADE THE PERFECT ONE!