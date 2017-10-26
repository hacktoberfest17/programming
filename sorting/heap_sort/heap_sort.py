"""
HeapSort Algorithm in using Python 3
"""
import random  # imports random module for random list generation


def heapsort(ele_list):
    """Heapsort function
    Args:
        ele_list list: list of unordered numbers
    """
    l = len(ele_list) - 1  # size of the list
    parent = l / 2  # middle parent
    for i in range(parent, -1, -1):
        move_down(ele_list, i, l)

    # converts the heap back into a sorted list
    for i in range(l, 0, -1):
        if ele_list[0] > ele_list[i]:
            swap(ele_list, 0, i)
            move_down(ele_list, 0, i - 1)


def move_down(ele_list, first_ele, last_ele):
    """Check and verifies the structure of the heap

    1) Checks if the element is greater than its children, if not, swap values
    2) Do it recursively until the element is in a position where it is greater
    than its children
    Args:
        ele_list list: the unordered list
        first_ele int: first element
        last_ele int: last element
    Returns:
        None: Force exit
    """
    largest_ele = 2 * first_ele + 1
    while largest_ele <= last_ele:
        # right child exists and is larger than left child
        if (largest_ele < last_ele) and (ele_list[largest_ele] < ele_list[largest_ele + 1]):
            largest_ele += 1
        # right child is larger than parent
        if ele_list[largest_ele] > ele_list[first_ele]:
            swap(ele_list, largest_ele, first_ele)
            # move dow to the largest child
            first_ele = largest_ele
            largest_ele = 2 * first_ele + 1
        else:
            return  # force exit


def swap(ele_list, i, j):
    """swap elements
    Args:
        ele_list list: number list
        i int: i position
        j int: j position
    """
    ele_list[i], ele_list[j] = ele_list[j], ele_list[i]


def test_heapsort(n):
    """Utility function to test the algorithm
    Args:
        n int: size of the unordered list to be generated
    """
    # list comprehension for random array. the random numbers can be picked
    # in the [0, n] interval
    a = [random.randint(0, n) for i in range(n)]
    # shows the array before HeapSort
    print("Array before sorting: {}".format(a))
    heapsort(a)  # calls function
    # shows the array after HeapSort
    print("Array after HeapSort: {}".format(a))

test_heapsort(10)
