import re
import random

def valid(password):
    """
    contains the given password at least 8 characters,  1 uppercase, 1 lowercase, 1 special character and 1 number
    :param password: the password that should be checked for validity
    :return: bool if the given password is a valid one
    """
    return ((len(password) > 7) and
            any(char.isupper() for char in password) and
            any(char.islower() for char in password) and
            any(char.isdigit() for char in password) and
            not (re.search(r"[ ?!#$%&'()*+,-./[\\\]^_`{|}~" + r'"]', password) is None))

def check(password):
    """
    :param password: the password that should be checked
    :return: bool if the given password is a valid one
    """
    return valid(password)

def createPassword(username):
    """
    :param username: the username which a password should be created for
    :return: the created password as string
    """
    password = username[::-1]
    while(not check(password)):
        password = password + chr(random.randrange(33, 127))
    return password
