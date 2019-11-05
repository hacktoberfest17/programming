puts "Enter array elements seperated by space"
arr = gets.split(" ")

puts "Enter the element to be searched"
element_to_search = gets.chomp()

idx = -1;
arr.each_with_index do|arr_element, index|
  if(arr_element == element_to_search)
    idx = index
    break
  end
end

puts "Element found at index #{idx}"
