#Binary Search in python3
#Define an array with elements

def binary_search(array, target):
    startingIndex = 0
    lastIndex = len(array) - 1
    middleIndex = (startingIndex + lastIndex) // 2
    flag = 0
    while flag == 0:
        if lastIndex > startingIndex:
            middleIndex = (startingIndex + lastIndex)//2
            if array[middleIndex] == target :
                print ("The index of the element " + str(target) + " is " + str(middleIndex))
                flag=1
            elif array[middleIndex + 1] == target :
                print ("The index of the element " + str(target) + " is " + str(middleIndex+1))
                flag = 1
            elif array[middleIndex] < target:
                startingIndex = middleIndex + 1
            elif array[middleIndex] > target:
                lastIndex = middleIndex - 1
        else:
            print ("This value is not in the array as a element")
            flag = 1

def main():
    array = [2,3,5,7,11,13,17,19,23,27,29]
    print ("Defined array's elements are - " +str(array))
    target = int(input("Enter a value of a element in defined array :"))
    binary_search(array, target)

if __name__ == '__main__':
    main()
