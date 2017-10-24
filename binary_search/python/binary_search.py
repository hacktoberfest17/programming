def binary_search(sorted_list,item):
    n = max((len(sorted_list) + 1)//2 - 1,0)
    if n == 0:
        return (len(sorted_list) > 0 and sorted_list[0] == item )
    if item == sorted_list[n]:
        return True
    elif item > sorted_list[n]:
        return binary_search(sorted_list[n:],item)
    elif item < sorted_list[n]:
        return binary_search(sorted_list[:n],item)

def main():
    txt = raw_input("Enter the elements of the array (eg:- 1,2,3): ")
    array = [int(x.strip()) for x in txt.split(",")]
    item = int(raw_input("Element to be searched: "))
    found = binary_search(array,item)
    if found:
        print("Element is present in the array")
    else:
        print("Element is not present in the array")


if __name__ == '__main__':
    main()
