/* Check whether the given two trees are identical or not.
Method 1:
Go to each node in both the trees simultaneously using two pointers and keep checking if the 
data is same in these corresponding nodes or not. Then, recursively call the function on LST 
and RST.

3 conditions need to be checked: values at root, isIdentical(LST), isIdentical(RST)

TC=O(n)
SC=O(n) if tree is skewed, O(log n) if balanced.
*/

#include <stdio.h>
#include <stdlib.h>

struct node
{
	int data;
	struct node *left, *right;
};

struct node * createNode(int data)
{
	struct node *new=(struct node *)malloc(sizeof(struct node));
	new->data=data;
	new->left=NULL;
	new->right=NULL;
	return new;
}

void insert_key(struct node **root,int data)
{
	
	if(!*root)
	{
		*root=createNode(data);
		return;
	}
	struct node *ptr=*root;
	//RECURSIVE VERSION
	if(data < ptr->data)
		insert_key(&(ptr->left),data);

	if(data > ptr->data)
		insert_key(&(ptr->right),data);

}

void inorder(struct node *root)
{
	if(root)
	{
		inorder(root->left);
		printf("%d  ",root->data);
		inorder(root->right);
	}
}

int isIdentical(struct node *root1, struct node *root2)
{
	if(!root1 && !root2)
		return 1;
	else if(root1 && root2)
	{
		return root1->data==root2->data &&
		isIdentical(root1->left,root2->left) &&
		isIdentical(root1->right,root2->right);
	}
	return 0;
}


int main()
{
	struct node *root1=NULL;
	struct node *root2=NULL;
	int num;

	insert_key(&root1,50);
	insert_key(&root1,30);
	insert_key(&root1,20);
	insert_key(&root1,40);
	insert_key(&root1,70);
	
	insert_key(&root2,50);
	insert_key(&root2,30);
	insert_key(&root2,90);
	insert_key(&root2,40);
	insert_key(&root2,70);
	inorder(root1);
	inorder(root2);
	num= isIdentical(root1,root2);
	if(num)
		printf("They are identical!\n");
	else
		printf("Not identical!\n");
        	
}