#include <iostream>
#include <stdio.h>

using namespace std;

struct node
{
	int data;
	struct node *left, *right;
	int height;
};

node* newNode(int data)
{
	node *new_node = new node;
	new_node->data = data;
	new_node->left = new_node->right = NULL;
	new_node->height = 1;
	return new_node;
}

int height(node *root)
{
	if (root != NULL)
		return root->height;
	return 0;
}

int max(int a, int b)
{
	return (a>b)?a:b;
}

int getBalance(node *root)
{
	if (root == NULL)
		return 0;
	return (height(root->left)-height(root->right));
}

node* leftrotation(node* x)
{
	node *y = x->right;
	node *t = y->left;

	y->left = x;
	x->right = t;

	x->height = 1+max(height(x->left), height(x->right));
	y->height = 1+max(height(y->left), height(y->right));

	return y;
}

node* rightrotation(node* y)
{
	node *x = y->left;
	node *t = x->right;

	x->right = y;
	y->left = t;

	y->height = 1+max(height(y->left), height(y->right));
	x->height = 1+max(height(x->left), height(x->right));

	return x;
}

node* insert(node *root, int data)
{
	if (root == NULL)
		return (newNode(data));
	
	if (data < root->data)
		root->left = insert(root->left, data);
	else if(data > root->data)
		root->right = insert(root->right, data);
	else
		return root;

	root->height = 1+ max(height(root->left), height(root->right));

	int balance = getBalance(root);

	if (balance > 1 && data < root->left->data)
		return rightrotation(root);

	else if(balance > 1 && data > root->left->data)
	{
		root->left = leftrotation(root->left);
		return rightrotation(root);
	}

	else if(balance < -1 && data > root->right->data)
		return leftrotation(root);

	else if(balance < -1 && data < root->right->data)
	{
		root->right = rightrotation(root->right);
		return leftrotation(root);
	}
	return root;
}

node* minValue(node* root)
{
    node* current = root;
 
    /* loop down to find the leftmost leaf */
    while (current->left != NULL)
        current = current->left;
 
    return current;
}

node* deleteNode(node *root, int data)
{
	if (root == NULL)
		return root;
	if(data < root->data)
		root->left = deleteNode(root->left, data);
	else if(data > root->data)
		root->right = deleteNode(root->right, data);
	else
	{
		if (root->left == NULL || root->right == NULL)
		{
			node *temp = root->left? root->left : root->right;

			if(temp == NULL)
			{
				temp = root;
				root = NULL;
			}
			//Copying contents of root child
			else
				*root = *temp;

			delete temp;
		}
		else
		{
			node *temp = minValue(root->right);

			root->data = temp->data;
			root->right = deleteNode(root->right, temp->data);
		}
	}

	if(root == NULL)
		return root;

	root->height = 1 + max(height(root->left), height(root->right));
	int balance = getBalance(root);

	if(balance > 1 && getBalance(root->left) >= 0)
		return rightrotation(root);
	else if(balance > 1 && getBalance(root->left)<0)
	{
		root->left = leftrotation(root->left);
		return rightrotation(root);
	}
	else if(balance < -1 && getBalance(root->right)>=0)
		return leftrotation(root);
	else if(balance < -1 && getBalance(root->right)<0)
	{
		root->right = rightrotation(root->right);
		return leftrotation(root);
	}
	return root;
}

void preorder(node *root)
{
	if (root != NULL)
	{
		cout<<root->data<<" ";
		preorder(root->left);
		preorder(root->right);
	}
}

int main()
{
	node *root;
	root = insert(root, 9);
    root = insert(root, 5);
    root = insert(root, 10);
    root = insert(root, 0);
    root = insert(root, 6);
    root = insert(root, 11);
    root = insert(root, -1);
    root = insert(root, 1);
    root = insert(root, 2);

    preorder(root);

    root = deleteNode(root, 10);
    cout<<"\n";
    preorder(root);
	return 0;
}