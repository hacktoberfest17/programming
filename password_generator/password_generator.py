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

__test__()
