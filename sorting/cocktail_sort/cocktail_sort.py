def cocktail_sort(lst):
    """
    Performs in-place Cocktail Sort.

    :param lst: lst of integers.
    :return: None

    >>> lst = [6, 0, 9, 3, 7, 5, 4, 1, 8, 2]
    >>> cocktail_sort(lst)
    >>> assert(lst == [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    """
    if lst is None or len(lst) < 2:
        return

    length = len(lst)
    j = 0

    swap_occurred = True

    while swap_occurred:
        swap_occurred = False

        # Move Left-to-Right
        for i in range(length - 1 - j):
            if lst[i] > lst[i+1]:
                lst[i], lst[i+1] = lst[i+1], lst[i]
                swap_occurred = True

        if not swap_occurred:
            return

        swap_occurred = False

        # Move Right-to-Left
        for i in range(length - 1 - j, 0, -1):
            if lst[i] < lst[i-1]:
                lst[i], lst[i-1] = lst[i-1], lst[i]
                swap_occurred = True

        j += 1
