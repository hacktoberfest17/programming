# client.py  
import socket
import sys
import select

# create a socket object
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
ip=str(sys.argv[1])
port =int(sys.argv[2])
 
nickname=raw_input("Enter the nickname which u want to set for the user:")
#sendc=sys.stdin.readline()  
#s.send(sendc)
s.connect((ip, port))
s.send(nickname)                            
while True:
    readers, _, _=select.select([sys.stdin,s],[],[])
    for reader in readers:		
        if reader is s:
              sys.stdout.write(s.recv(1024))
        else:
              sendc=sys.stdin.readline()  
              s.send(nickname+":"+sendc)
    
    
    


    
s.close()

