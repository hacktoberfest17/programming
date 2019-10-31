def is_palindrome_recursion(string):
    if len(string) == 1 or len(string) == 0:
        return True
    elif string[0] == string[-1]:
        return is_palindrome_recursion(string[1:-1])
    else:
        return False

def is_palindrome_looping(string):
    while len(string) > 1:
        if (string[0] == string[-1]):
            string = string[1:-1]
        else:
            return False
    return True


def is_palindrome(input_chars):
    
    # convert the input to string
    # so that integers can also be tested for palindrome.
    
    input_chars = str(input_chars)
    
    # reversing the input
    reversed_chars = input_chars[::-1]
    
    return input_chars == reversed_chars
    
   
