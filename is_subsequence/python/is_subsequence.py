def is_subsequence(s, sub):
	itr = iter(s)
	return all(c in itr for c in sub)

if __name__ == '__main__':
	# string example
	main = 'hihello'
	sub = 'iel'
	print(is_subsequence(main, sub))

	# works for lists as well. (any iterable for that matter)
	arr = [1,3,4]
	sub_arr = [1,3]
	print(is_subsequence(arr, sub_arr))