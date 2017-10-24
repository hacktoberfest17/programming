def bubbleSort(numbers):
    for passnum in range(len(numbers)-1,0,-1):
        for i in range(passnum):
            if numbers[i]>numbers[i+1]:
                temp = numbers[i]
                numbers[i] = numbers[i+1]
                numbers[i+1] = temp

s = raw_input()
numbers = map(int, s.split())

bubbleSort(numbers)
print(numbers)
