import random

replacer = {
    'A': '4',
    'B': '8',
    'E': '3',
    'G': '6',
    'I': '1',
    'O': '0',
    'S': '5',
    'T': '7',
    'Z': '2',
    'a': '4',
    'b': '8',
    'e': '3',
    'g': '6',
    'i': '1',
    'o': '0',
    's': '5',
    't': '7',
    'z': '2',
    }

def test_is_valid_password ():
    assert (is_valid_password ("aA1#") == False)
    assert (is_valid_password ("asdf1234ASDF") == False)
    assert (is_valid_password ("!\"#1234ASDF") == False)
    assert (is_valid_password ("!\"#1234asdf") == False)
    assert (is_valid_password ("!\"#ASDFasdf") == False)
    assert (is_valid_password ("aA1#bB2#") == True)
    assert (is_valid_password ("aA1'bB2'") == True)
    assert (is_valid_password ("aA1\"bB2\"") == True)

def __test__ ():
    test_is_valid_password ()

def is_valid_password (password):
    password = str (password)
    has_uppercase = False
    has_lowercase = False
    has_number = False
    has_special_caracter = False
    
    if (len (password) < 8):
        return False;
    
    for c in password:
        if (c >= 'A' and c <= 'Z'):
            has_uppercase = True
        elif (c >= 'a' and c <= 'z'):
            has_lowercase = True
        elif (c >= '0' and c <= '9'):
            has_number = True
        else:
            has_special_caracter = True
    
    
    return has_uppercase and has_lowercase and has_number and has_special_caracter

def get_random_special_string (size = 1):
    
    s = ""
    for _ in range (size):
        s += chr (random.randint(33, 127))
    
    return s

def generate_password (username):
    
    shift = ord('a') - ord('A')
    
    username = str (username)
    password = ""
    
    for c in username:
        if (c in replacer):
            password += replacer[c]
        else:
            nc = c
            if (c >= 'a' and c <= 'z' and random.randint(0, 2) == 1):
                nc = chr(ord (c) - shift)
            elif (c >= 'A' and c <= 'Z' and random.randint(0, 2) == 1):
                nc = chr(ord (c) + shift)
            password += nc
    
    while (not is_valid_password (password)):
        password += get_random_special_string (1)
    return password

__test__()
print (generate_password ("hernan"))
