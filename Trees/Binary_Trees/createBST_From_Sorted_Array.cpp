#include<iostream>
#include<stack>
using namespace std;

// A BST node
struct Node
{
	int data;
	struct Node *left,*right;
};

// A utility function to create new Node
Node* newNode(int val)
{
	Node* temp = new Node;
	temp->data = val;
	temp->left = temp->right = NULL;
}

Node* createBST(int arr[],int l,int r)
{	
	if(l>r)
		return NULL;

	int mid = (l+r)/2;

	Node* root = newNode(arr[mid]);

	root->left = createBST(arr,l,mid-1);
	root->right  = createBST(arr,mid+1,r);

	return root;

}

void inorderIterative(Node* root)
{
	stack<Node*> s;

	Node* current = root;

	while(1)
	{
		if(current)
		{
			s.push(current);
			current = current->left;
		}
		else
		{
			if(!s.empty())
			{
				current = s.top();
				s.pop();
				cout<<current->data<<" ";
				current = current->right;
			}
			else
			{
				break;
			}
		}

	}
}


int main()
{

	int arr[] = {1,2 ,3 ,4 ,5 ,6, 7,8,9,10,11,12};
	int size = sizeof(arr)/sizeof(arr[0]);

	Node* root = createBST(arr,0,size-1);
	
	inorderIterative(root);
}