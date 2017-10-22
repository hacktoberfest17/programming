
#include<stdio.h>
#include<netinet/in.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netdb.h>
#include<string.h>
#include<stdlib.h>
#define MAX 80
#define PORT 43454
#define SA struct sockaddr
void func(int sockfd)
{
	char buff[MAX];
	int n;
	for(;;)
	{
		bzero(buff,sizeof(buff));
		printf("Enter the string : ");
		n=0;
		while((buff[n++]=getchar())!='\n');
		write(sockfd,buff,sizeof(buff));
		bzero(buff,sizeof(buff));
		read(sockfd,buff,sizeof(buff));
		printf("From Server : %s",buff);
		if((strncmp(buff,"exit",4))==0)
		{
			printf("Client Exit...\n");
			break;
		}
	}
}

int main()
{
	int sockfd,connfd;
	struct sockaddr_in servaddr,cli;
	sockfd=socket(AF_INET,SOCK_STREAM,0);
	if(sockfd==-1)
	{
		printf("socket creation failed...\n");
		exit(0);
	}
	else
		printf("Socket successfully created..\n");
	bzero(&servaddr,sizeof(servaddr));
	servaddr.sin_family=AF_INET;
	servaddr.sin_addr.s_addr=inet_addr("127.0.0.1");
	servaddr.sin_port=htons(PORT);
	if(connect(sockfd,(SA *)&servaddr,sizeof(servaddr))!=0)
	{
		printf("connection with the server failed...\n");
		exit(0);
	}
	else
		printf("connected to the server..\n");
	func(sockfd);
	close(sockfd);
}