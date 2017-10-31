def iptoint(ip):
    total = 0
    octets = ip.split('.')
    for ind, o in enumerate(reversed(octets)):
        total += int(o) * 256**ind
    return total