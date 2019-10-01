sbox = {0x0: 0x5, 0x1: 0x4, 0x2: 0xd, 0x3: 0x1, 0x4: 0x2, 
        0x5: 0xf, 0x6: 0x6, 0x7: 0x0, 0x8: 0x8, 0x9: 0xc, 
        0xa: 0xb, 0xb: 0x9, 0xc: 0x7, 0xd: 0xe, 0xe: 0xa, 
        0xf: 0x3} # S-Box produced earlier

def ddt(sbox):
    lst1 = [format(i,'x') for i,j in sbox.items()]
    print("in\\out|", ("{:>3}"*len(lst1)).format(*lst1)) 
    print('-'*56)
    for diff in sbox:
        u1 = [hex(i^diff) for i in sbox]
        S_u0 = [hex(j) for i,j in sbox.items()] # S[u0]
        S_u1 = [hex(sbox[(int(i,0))]) for i in u1] # S[u1]
        S_u0_x_S_u1 = [hex(int(i,0)^int(j,0)) for i,j 
        in zip(S_u0,S_u1)] # S[u0] xor S[u1]
        # counting occurences and replacing 0 with '-'
        count = {hex(i):'-' if S_u0_x_S_u1.count(hex(i)) 
        == 0 else S_u0_x_S_u1.count(hex(i)) for i in sbox}        
        # format output as a table
        lst = [str(i) for j,i in count.items()]
        frmt = "{:>3}"*len(lst)
        print(str(format(diff,'x')+'  |').rjust(7),frmt.
              format(*lst))
ddt(sbox)