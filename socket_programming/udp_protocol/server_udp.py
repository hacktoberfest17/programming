import socket
import sys

sock = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
host = "10.100.53.225"
port = 5677

filename = raw_input("Enter the filename: ")

sock.sendto(filename,(host,port))

file = open(filename,"rb")

data = file.read(1024)

while data:
	sock.sendto(data,(host,port))
	data = file.read(1024)
	print "Sending data"

sock.sendto("sent",(host,port))
	
print "Data Sent"

file.close()
sock.close()	
