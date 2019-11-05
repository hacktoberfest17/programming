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
