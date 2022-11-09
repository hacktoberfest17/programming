def isvalidip(ip):
    octets = ip.split('.')
    if len(octets) != 4:
        return False
    for o in octets:
        if o[0] == '0' and len(o) > 1:
            return False
        try:
            i = int(o)
            if 0 > i or i > 255:
                return False
        except ValueError:
            return False
    return True