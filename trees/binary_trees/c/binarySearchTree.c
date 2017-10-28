// this function will return a binary search tree, the output is sorted array of the input no.s(starting from the leftmost node in binary search tree)

#include<stdio.h>
#include<stdlib.h>
typedef struct node{
	struct node *par;
	int val;
	struct node *left;
	struct node *right;
}node;
node *root;
void insert(int val)
{
	node *curr;
	int flag;
	node *temp=(node *)malloc(sizeof(node));
	if(root==NULL)
	{
		root=temp;
		root->val=val;
		root->par=NULL;
		root->left=NULL;
		root->right=NULL;
	}
	else
	{
		node *lol=root;
		while(lol!=NULL)
		{
			if(val<=lol->val)
			{
				curr=lol;
				lol=lol->left;
				flag=0;
			}	
			else
			{
				curr=lol;
				lol=lol->right;
				flag=1;
			}
		}
		lol=temp;
		lol->val=val;
		lol->left=NULL;
		lol->right=NULL;
		lol->par=curr;
		if(flag==0)
			curr->left=lol;
		else
			curr->right=lol;

	}
}
void print(node *n)
{
	if(n==NULL)
	{
		puts("");
		return;
	}
	print(n->left);
	printf("%d ",n->val);
	print(n->right);
}
int main()
{
	int n,i,x;
	printf("Enter the no of elements in the tree:\n");
	scanf("%d",&n);
	printf("Enter the elements of the tree:\n");
	for(i=0;i<n;i++)
	{
		scanf("%d",&x);
		insert(x);
	}
	print(root);
	return 0;
}
