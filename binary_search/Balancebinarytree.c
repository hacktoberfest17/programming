/*
 * Program to Construct a Balanced Binary Tree using Sorted Array
 *			An example of binary tree:
 *                   40
 *                   /  \
 *                  20   60
 *                 /  \   \
 *                10  30   80
 *                          \
 *                           90    
 *
 */
#include <stdio.h>
#include <stdlib.h> 
 
struct btnode
{
    int value;
    struct btnode *l;
    struct btnode *r;
};
 
typedef struct btnode N;
N* bst(int arr[], int first, int last);
N* new(int val);
void display(N *temp);
 
int main()
{   
    int arr[] = {10, 20, 30, 40, 60, 80, 90};
    N *root = (N*)malloc(sizeof(N));  
    int n = sizeof(arr) / sizeof(arr[0]), i;
 
    printf("Given sorted array is\n");
    for (i = 0;i < n;i++)
        printf("%d\t", arr[i]);
    root = bst(arr, 0, n - 1); 
    printf("\n The preorder traversal of binary search tree is as follows\n");
    display(root);
    printf("\n");   
    return 0;
}
 
/* To create a new node */
N* new(int val)
{
    N* node = (N*)malloc(sizeof(N));
 
    node->value = val;
    node->l = NULL;
    node->r  =  NULL;
    return node;
}
 
/* To create a balanced binary search tree */
N* bst(int arr[], int first, int last)
{
    int mid;
    N* temp = (N*)malloc(sizeof(N));
    if (first > last)
        return NULL;
    mid = (first + last) / 2;
    temp = new(arr[mid]);
    temp->l = bst(arr, first, mid - 1);
    temp->r = bst(arr, mid + 1, last);
    return temp;
}
 
/* To display the preorder */
void display(N *temp)
{
    printf("%d->", temp->value);
    if (temp->l != NULL)
        display(temp->l);
    if (temp->r != NULL)
        display(temp->r);
}
