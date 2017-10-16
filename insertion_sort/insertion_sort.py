arr = [12, 11, 13, 5, 6, 45, 99, 1, 654] # Array to sort

for i in range(1, len(arr)):
    j = i - 1
    key = arr[i]

    while j >= 0 and key < arr[j]:
        arr[j+1] = arr[j]
        j -= 1
    
    arr[j+1] = key

    i += 1

# print the sorted array
print arr