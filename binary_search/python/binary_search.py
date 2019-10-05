from random import random
N = 20
array = []
for i in range(N):
    array.append(int(random()*100))
array.sort()
print(array)

number = int(input())

low = 0
high = N-1
while low <= high:
    mid = (low + high) // 2
    if number < array[mid]:
        high = mid - 1
    elif number > array[mid]:
        low = mid + 1
    else:
        print("ID =", mid)
        break
else:
    print("No the number")