'''
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
'''

import time


class Solution:
    def valid_parenthesis(self, string):
        open = ['{', '[', '(']
        close = ['}', ']', ')']
        paren = []
        bool = ''
        for i in string:
            if i in open:
                paren.append(i)
            elif i in close:
                pos = close.index(i)
                if (len(paren) > 0) and (open[pos] == paren[len(paren)-1]):
                    paren.pop()
                else:
                    bool = 'False'
            else:
                bool = 'Invalid String'
        if len(paren) == 0:
            bool = 'True'
        return bool


if __name__ == "__main__":
    s = Solution()
    start = time.time()
    print("enter a parenthesis string")
    string = input()
    print(s.valid_parenthesis(string))
    print("time taken: {} seconds".format((time.time() - start) % 60))