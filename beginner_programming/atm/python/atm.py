#!/usr/bin/env python

try:
    input = raw_input
except:
    pass

def dispense(x):
    if x <= 0 or x % 10 or x in (10, 30):
        raise KeyError
    q = x // 50
    if (x - 50 * q) % 20:
        q -= 1
    return tuple([q, (x - q * 50) // 20])

while True:
    try:
        amt = dispense(int(input('Enter amount to turn into $20 and $50 notes: ')))
        msg = ''
        if amt[0]:
            msg += '%s x $50' % amt[0]
        if amt[0] and amt[1]:
            msg += ', '
        if amt[1]:
            msg += '%s x $20' % amt[1]
        print(msg)
    except (KeyError, ValueError):
        print('Invalid amount. Must be able to make up the total using $20 and $50 notes.')
    except (KeyboardInterrupt, EOFError):
        break
