def isPalindrome(word): 

    reverseWord = word[::-1]
    if (word == reverseWord): 
        return True
    return False

word = input()

if(isPalindrome(word)):
    print("the word '%s' is a palindrome!" % word)
else:
    print("the word '%s' isn't a palindrome!" % word)