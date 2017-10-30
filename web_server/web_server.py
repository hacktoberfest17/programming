import socket

HOST, PORT = ("", 8080)

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST, PORT))
server.listen()
print("Serving on PORT {}".format(PORT))

while True:
    connection, address = server.accept()  # accept the connection
    req = connection.recv(1024)  # recieve the request, max 1024 bytes
    # set a response
    response = """HTTP/1.1 200 OK            

Hello World!
    """
    response = response.encode()  # encode the response(required in python3)
    connection.send(response)  # finall, send the response
    connection.close()  # close the connection
