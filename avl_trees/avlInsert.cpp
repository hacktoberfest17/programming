#include <iostream>
#include <stdio.h>

using namespace std;

struct node
{
	int data;
	int height;
	struct node *left, *right;
};

node* newNode(int data)
{
	node *new_node = new node;
	new_node->data = data;
	new_node->left = NULL;
	new_node->right = NULL;
	new_node->height = 1;
	return new_node;
}

int height(node *n)
{
	if (n == NULL)
		return 0;
	return n->height;
}

int max(int a, int b)
{
	return (a>b)?a:b;
}

int getbalance(node *root)
{
	if (root == NULL)
		return 0;
	return (height(root->left) - height(root->right));
}

node* leftrotation(node *x)
{
	node *y = x->right;
	node *t = y->left;

	//Rotation
	y->left = x;
	x->right = t;

	x->height = max(height(x->left), height(x->right))+1;
	y->height = max(height(y->left), height(y->right))+1;

	return y;
}

node* rightrotation(node *y)
{
	node *x = y->left;
	node *t = x->right;

	//Rotation
	x->right = y;
	y->left = t;

	y->height = max(height(y->left), height(y->right))+1;
	x->height = max(height(x->left), height(x->right))+1;

	return x;
}

node* insert(node *root, int data)
{
	if (root == NULL)
		return (newNode(data));

	if(data< root->data)
		root->left = insert(root->left, data);
	else if (data > root->data)
		root->right = insert(root->right, data);
	else
		return root;

	root->height = 1+ max(height(root->left), height(root->right));

	int balance = getbalance(root);
	//left left case
	if (balance > 1 && data < root->left->data)
		return rightrotation(root);
	//left right case
	else if(balance > 1 && data > root->left->data)
	{
		root->left = leftrotation(root->left);
		return rightrotation(root);
	}
	//right right case
	else if(balance < -1 && data > root->right->data)
		return leftrotation(root);
	//right left case
	else if(balance < -1 && data < root->right->data)
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
	node *root = NULL;

	root = insert(root, 10);
	root = insert(root, 20);
	root = insert(root, 30);
	root = insert(root, 40);
	root = insert(root, 50);
	root = insert(root, 25);

	preorder(root);
	return 0;
}
