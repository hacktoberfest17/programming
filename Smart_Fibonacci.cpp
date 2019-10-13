#include <bits/stdc++.h>
using namespace std;
class Node {
public:
    int data;
    Node* next;
    Node* prev;
};
Node* create_list(long int n)
{
	Node* head = NULL;
	Node* second=NULL;
	Node* ptr=NULL;
	head = new Node();
	second = new Node();
	head->data=0;
	second->data=1;
	head->next=second;
	second->prev=head;
	ptr=second;
	for(int i=3;i<=n;i++)
	{
		Node *nw = NULL;
		nw = new Node();
		nw->next=NULL;
		nw->prev=NULL;
		nw->data=(ptr->data + ptr->prev->data)%10;
		ptr->next=nw;
		nw->prev=ptr;
		ptr=nw;
	}
	return head;
}
int main()
{
	long int t,n;
	cout<<"Enter the Number of Test Cases :";
	cin>>t;
	while(t--)
    {
        cout<<"\nEnter the n terms :";
        cin>>n;
        Node* head=NULL;
        Node* temp=NULL;
        Node* ptr=NULL;
        Node* tempp=NULL;
        Node* st=NULL;
        head = create_list(n);
        st=head;
        while(st!=NULL)
        {
            cout<<st->data<<" ";
            st=st->next;
        }
        cout<<endl;
        tempp = head;

        head=head->next;
        free(tempp);
        ptr=head;
        while(1)
        {
            while(1)
            {
                cout<<ptr->data<<" ";
                if(ptr->next==NULL || ptr->next->next==NULL)
                {
                    ptr->next=NULL;
                    break;
                }
                temp=ptr->next;
                ptr->next=temp->next;
                temp->next=NULL;
                temp->prev=NULL;
                ptr=ptr->next;
                free(temp);
            }
            cout<<endl;
            head=head->next;
            ptr=head;
            if(head->next==NULL || head->next->next==NULL)
                break;

        }
        	cout<<"\nOutput:";
            cout<<ptr->data<<endl;

    }
}
