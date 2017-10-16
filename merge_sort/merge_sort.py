from __future__ import print_function

def mergeSort(array, start, end):
    if(start < end):
        n = (end - start) + 1
        middle = int((end + start)/2)
        mergeSort(array, start, middle)
        mergeSort(array, middle + 1, end)
        merge(array, start, end, middle, n)

def merge(array, start, end, middle, n):
    array2 = [ None ] * n
    i = start
    j = middle + 1
    for k in range(start, n):
        if(i > middle):
            array2[k] = array[j]
            j += 1
        elif(j > end):
            array2[k] = array[i]
            i += 1
        elif(array[i] < array[j]):
            array2[k] = array[i]
            i += 1
        else:
            array2[k] = array[j]
            j += 1

    for k in range(start, n):
        array[k] = array2[k]

def main():
    array = [4, 8, 9, 15, 1, 2, 6]
    mergeSort(array, 0, len(array) - 1)
    for i in array:
        print(i, end=' ')
    print()

main()
