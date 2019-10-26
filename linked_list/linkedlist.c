#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct node
{
    int data;
    struct node* next;
}node;

void createlinkedlist(int n);
node* head = NULL;
int main()
{
    createlinkedlist(5);
    return 0;
}

void createlinkedlist(int n)
{
    int i;
    for(i = 0; i < n; i++)
    {
        struct node* newnode =(struct node*)malloc(sizeof(node));
        if(head == NULL)
        {

            newnode->data = i;
            newnode->next = NULL;
            head = newnode;
        }
        else
        {
            node* temp = head;
            node* curr = head;
            while(temp != NULL)
            {
                curr = temp;
                temp = temp->next;
            }
            curr->next = newnode;
            newnode->data = i;
            newnode->next = NULL;
        }

    }
    printf("pid\n");
    node* temp = head;
    while(temp != NULL)
    {
        printf("%d\n",temp->data);
        temp = temp->next;
    }

}
