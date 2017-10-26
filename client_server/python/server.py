#!/bin/python3

import socketserver

class tcp_handler(socketserver.BaseRequestHandler):
    '''
    A simple Handler Class for tcp socket servers
    '''

    def handle(self):
        # Note: Raw strings can't be sent
        self.client_data = self.request.recv(10).strip().decode("utf-8")
        print(f"[{self.client_address[0]}]: {self.client_data}")
        self.request.sendall("Pong!".encode("utf-8"))

class tcp_server:
    '''
    A simple TCP server using the socketserver.TCPServer class
    '''

    def __init__(self, host, port):
        self.host = host
        self.port = port

    def start(self):
        try:
            # Allows us to re-use ports so we don't have to open a new port every time we run the server program
            socketserver.TCPServer.allow_reuse_address = True
            self.server = socketserver.TCPServer((self.host, self.port), tcp_handler)
            self.server.serve_forever()
        except Exception as e:
            print(f"[Error!]: {e}")
        finally:
            self.server.server_close()

if __name__ == "__main__":
    # Basic Example
    server = tcp_server("localhost", 9998)
server.start()
