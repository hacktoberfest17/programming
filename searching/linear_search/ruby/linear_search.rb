def linear_search(array, key)
  i = 0
  while i < array.length
      if array[i] == key
        return "#{key} at index #{array.index(key)}"
      end
      i+=1
    end
    return -1
end

array = [1,6,7,3,4]
key = 3
puts linear_search(array, key)
