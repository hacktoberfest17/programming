def checkPalindrome(inputString):

	#An alternate solution:
	#return inputString == inputString[::-1]

    words = list(inputString)

    st = ""

    while words:
    	st+= words.pop(-1)

    if st == inputString:
    	return True
    else:
    	return False

print(checkPalindrome('aba'))











