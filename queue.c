#include <stdio.h>
#include <stdlib.h>
#define n 5
void enqueue(int arr[],int num,int* front,int* rear)
{
    if((*rear)==(n-1)){
        printf("Overflow condition\n");
        return;
    }
    (*rear)++;
    arr[(*rear)]=num;

    if((*front)==-1)
        (*front)=0;

    return;
}

void dequeue(int arr[],int* front,int* rear)
{
    if(((*front)>(*rear))||((* front)==-1)){
        printf("Underflow condition\n");
        return;
    }
    printf("Deleted element is %d\n",arr[(*front)]);

    if((* front)==(* rear)){
    (* front)=-1;
    (* rear)=-1;
    }
    else
        (* front)=(* front)+1;
    return;
}
int main()
{
    char choice;
    printf("a. push in the queue\n b. pop from queue\n c. exit the loop\n");


    int front=-1;
    int rear=-1;
    int i=0;

    int queue[n];

    do{
        printf("Your choice\n");
        scanf("%c",&choice);

        switch(choice)
        {
        case 'a':
            {
                printf("Enter data\n");
                scanf("%d",&data);
                enqueue(queue,queue[i],&front,&rear);
                break;
            }
        case 'b':
            {
               dequeue(queue,&front,&rear);
                break;
            }
        case 'c':
            {
               exit(0);
            }
        }
        i++;
    }
    while(1);
    return 0;
}
