def binary_search(array, value)
    top = array.size - 1
    bottom = 0

    while (bottom < top)
        middle = (top + bottom) / 2
        if array[middle] == value
            return middle
        elsif array[middle] > value
            top = middle - 1
        else
            bottom = middle + 1
        end
    end

    return -1 
end

array = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
puts binary_search(array, 9) # Prints 9