import socket
import sys

sock = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
host = "10.100.53.171"
port = 5677

sock.bind((host,port))

data = sock.recvfrom(1024)

file = open(data[0],"wb")

data = sock.recvfrom(1024)

while data[0]!="sent":
    file.write(data[0])
    data = sock.recvfrom(1024)
    print "Receving Data"
    
print "Data Received"
    
file.close()
sock.close()    

