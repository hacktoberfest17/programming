#include <stdio.h>
#include <winsock2.h>

#pragma comment(lib,"ws2_32.lib")

int main()
{
    int port = 8080;
    WSADATA wsa;
    SOCKET s, clientsocket;
    struct sockaddr_in server, client;
    char *response = "HTTP/1.1 200 OK\r\nContent-Length: 18\r\n\r\nHELLO WORLD FROM C";
    int c, response_len = strlen(response);

    // Setup Winsock
    if (WSAStartup(MAKEWORD(2,2),&wsa) != 0)
    {
        printf("Winsock Startup Failed: %d",WSAGetLastError());
        return 1;
    }
    // Try to make server socket
    if((s = socket(AF_INET , SOCK_STREAM , 0 )) == INVALID_SOCKET)
    {
        printf("Socket creation failed: %d" , WSAGetLastError());
    }
    printf("Socket created.\n");

    // Setup server settings
    server.sin_family = AF_INET;
    server.sin_addr.s_addr = inet_addr("127.0.0.1");
    server.sin_port = htons (port);

    // Bind server settings to socket
    if (bind (s, (struct sockaddr *)&server, sizeof(server)) == SOCKET_ERROR)
    {
        printf("Failed to bind socket: %d", WSAGetLastError());
    }

    // Listen for clients
    listen(s, SOMAXCONN);
    while (1)
    {
        c = sizeof(client);
        clientsocket = accept(s, (struct sockaddr*)&client, &c);
        send(clientsocket, response, response_len, 0);
        closesocket(clientsocket);
    }

    printf("END");
    closesocket(s);
    WSACleanup();
    return 0;
}
