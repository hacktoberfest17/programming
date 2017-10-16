import re
import random

def valid(password):
    return ((len(password) > 7) and
            any(char.isupper() for char in password) and
            any(char.islower() for char in password) and
            any(char.isdigit() for char in password) and
            not (re.search(r"[ ?!#$%&'()*+,-./[\\\]^_`{|}~" + r'"]', password) is None))



def check(password):
    return valid(password)


def createPassword(username):
    password = username[::-1]
    while(not check(password)):
        password = password + chr(random.randrange(0, 127))
    return password



print check("123456789aA*")
print createPassword("MyUsername")
