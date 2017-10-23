# server.py 
import socket                                         
import time
import select
import sys
serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
port = int(sys.argv[1])                                          
serversocket.bind(('', port)) 
serversocket.listen(2)
clientlist=[]
clientnames=[]
clientnames.append(0)
clientlist.append(sys.stdin) 
clientlist.append(serversocket) 
def senddata(clientsock,message):
    rec=message.partition(":")[0]
    i=0
    key=0
    for names in clientnames:
      if names==rec:
        key=i
        break
      i=i+1
    socket = clientlist[i]          
    socket.send(message)
nickname=raw_input("enter the nickname for this user:")
clientnames.append(nickname)                                            
while True:
    
    
    readers, _, _=select.select(clientlist,[],[])
    for reader in readers:
        if reader != serversocket and reader != sys.stdin:
           sys.stdout.write(reader.recv(1024))
                        
        if reader is serversocket:
           clientsocket,addr=serversocket.accept()
           print("Got a connection from %s" % str(addr))
           clientlist.append(clientsocket)
           clientnames.append(clientsocket.recv(1024))
        if reader==sys.stdin:
           message=sys.stdin.readline() 
           senddata(reader,message)
    
        
clientsocket.close()
