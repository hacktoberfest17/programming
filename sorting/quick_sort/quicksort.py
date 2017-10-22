from random import randrange


def partition(lst, start, end, pivot):
    lst[pivot], lst[end] = lst[end], lst[pivot]
    store_index = start
    for i in xrange(start, end):
        if lst[i] < lst[end]:
            lst[i], lst[store_index] = lst[store_index], lst[i]
            store_index += 1
    lst[store_index], lst[end] = lst[end], lst[store_index]
    return store_index


def quick_sort(lst, start, end):
    if start >= end:
        return lst
    pivot = randrange(start, end + 1)
    new_pivot = partition(lst, start, end, pivot)
    quick_sort(lst, start, new_pivot - 1)
    quick_sort(lst, new_pivot + 1, end)


def sort(lst):
    quick_sort(lst, 0, len(lst) - 1)
    return lst

print sort([])
print sort([1, 2, 3, 4])
print sort([-5, 3, -2, 3, 19, 5])
