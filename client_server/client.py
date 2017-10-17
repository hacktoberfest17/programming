#!/bin/python3

import socket, sys

class tcp_client:
    '''
    A simple tcp_client class using sockets
    '''

    def __init__(self, host, port):
        self.host = host
        self.port = port
        self.socket_client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    def ping(self):
        try:
            self.socket_client.connect((self.host, self.port))
            self.socket_client.sendall(bytes("Ping!\n", "utf-8"))

            self.response = str(self.socket_client.recv(10), "utf-8")
            print(f"[Response From Server]: {self.response}")
        except Exception as e:
            print(f"[Error!]: {e}")
        finally:
            self.socket_client.close()

if __name__ == "__main__":
    # A simple example of using the client
    client = tcp_client("localhost", 9998)
client.ping()
