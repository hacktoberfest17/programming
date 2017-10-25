def mergeSort(lst):

    rLst = []
    
    if len(lst) < 2:
        return lst

    mid = len(lst) // 2

    left = mergeSort(lst[mid:])
    right = mergeSort(lst[:mid])

    i,j = 0,0

    while i < len(left) and j < len(right):
        if (left[i] < right[j]):
            rLst.append(left[i])
            i += 1
        else:
            rLst.append(right[j])
            j += 1

    rLst += left[i:] + right[j:]

    return rLst

if __name__ == "__main__":
    import random

    lst1 = [random.randint(-9,99) for i in range(10)]
    print(lst1)
    ms = mergeSort(lst1)
    print(ms)
