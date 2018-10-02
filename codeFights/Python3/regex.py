#LINK FROM DOCUMENTATION
# https://docs.python.org/3.4/library/re.html

import re
s = "abcdefg."

#TERMS AND THEIR USAGE

# r - Raw string
# . - All characters in the string
match = re.findall(r'.', s)

# ^ - Start of line
match = re.findall(r'^e', s) #Returns empty
match = re.findall(r'^abcd', s) #Returns abcd

# $ - End of line
match = re.findall(r'foo$', "foobar")
# match = re.findall(r'$a', s)

#FUNCTIONS
# findall - Returns all matches as a li

print(match)

#HARD!
    mails = re.findall(r'(?<=\().*?(?=\)*)', s)
    for i in mails:
        print(i)
    
    str = ['(', ')']
    newList = [i for i, x in enumerate(s) if x in str]
    print(newList)
