def bubble_sort(arr)
	len = arr.length
	for i in 0...len-1
		for j in 0...len-i-1
			if arr[j] > arr[j+1]
				temp = arr[j]
				arr[j] = arr[j+1]
				arr[j+1] = temp
			end
		end
	end
	return arr
end