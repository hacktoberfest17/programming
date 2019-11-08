#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
struct node
{
  int info;
  struct node *left,*right;
};

typedef struct node* NODE;

NODE getnode()
{
	NODE x;
	// Allocate memory on heap for size of node structure
	x= (NODE) malloc(sizeof(struct node));
	// Display a message incase of allocation failure
	if(x==NULL)printf("Node creation failure!\n");
	// Return a pointer to the newly created node
	return x;
}

NODE insert( int  item, NODE root)
{
  NODE temp, prev, cur;
  char direction[10];
  int i;
  temp = getnode();
  temp->info = item;
  temp->right = NULL;
  temp->left = NULL;
  if(root == NULL) return temp;
  printf("Enter the direction L for left and R for right:\n");
  scanf("%s",direction);
  for(i=0;direction[i]!='\0';i++)
  direction[i] = toupper(direction[i]); //converts l->L and r->R for code simplicity 
  prev = NULL;
  cur = root;
  for(i=0;direction[i]!='\0' && cur!=NULL; i++)
  {
    prev = cur;
    if(direction[i]=='L')
      cur = cur->left;
    else
      cur = cur->right;
  }
  if(cur!=NULL || i!=strlen(direction))
  {
    printf("Insert failure!");
    free(temp);
    return root;
  }
  if(direction[i-1]=='L')
    prev->left = temp;
  else if(direction[i-1]=='R')
    prev->right = temp;
  return root;
}

void in_order(NODE root)
{
  if(root == NULL)
    return;
  in_order(root->left);
  printf("%d\t",root->info);
  in_order(root->right);
}

void pre_order(NODE root)
{
  if(root == NULL)
    return;
  printf("%d\t",root->info);
  pre_order(root->left);
  pre_order(root->right);
}
void post_order(NODE root)
{
  if(root == NULL)
    return;
  post_order(root->left);
  post_order(root->right);
  printf("%d\t",root->info);
}
int main()
{
	NODE root = NULL;
  int ch,data;
	do
	{
		printf("\n1. Insert Element\n");
		printf("2. In Order Traversal\n");
		printf("3. Pre Order Traversal\n");
    printf("4. Post Order Traversal\n");
		printf("5. Exit\n");
		printf("Enter your choice:");
		scanf("%d",&ch);
		switch(ch)
		{
			default:
				break;
			case 1:
				printf("Enter element to insert:");
				scanf("%d",&data);
				root = insert(data,root);
				break;
			case 2:
        printf("\nIn Order Traversal is:\n");
				in_order(root);
				break;
			case 3:
				printf("\nPre Order Traversal is:\n");
        pre_order(root);
				break;
			case 4:
			printf("\nPost Order Traversal is:\n");
      post_order(root);
			break;
			case 5:
				break;

		}
	}while(ch!=5);
	return 0;
}
