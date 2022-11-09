import unittest


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



class TestIsPalindrome(unittest.TestCase):
    def test_is_palindrome_odd(self):
        self.assertTrue(is_palindrome_recursion("abcba"))

    def test_is_palindrome_empty(self):
        self.assertTrue(is_palindrome_recursion(""))

    def test_is_palindrome_single_char(self):
        self.assertTrue(is_palindrome_recursion("#"))

    def test_is_palindrome_even(self):
        self.assertTrue(is_palindrome_recursion("abccba"))

    def test_is_not_palindrome_even(self):
        self.assertFalse(is_palindrome_recursion("abc3ba"))

    def test_is_palindrome_odd(self):
        self.assertFalse(is_palindrome_recursion("1234567890"))
