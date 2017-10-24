/*PROBLEM STATEMENT
Implement Fibonacci Heaps. You need to only implement following operations:
	-MAKE-FIB-HEAP
	-FIB-HEAP-INSERT
	-FIB-HEAP-EXTRACT-MIN
	-FIB-HEAP-UNION
You can use the command interpreter that uses codes c, i, e, u and S to make, insert,
extract the minimum, do a union operation and to show the heap structure, respectively. 
*/

#include<bits/stdc++.h>
using namespace std;

typedef struct node
{
	node *left , *right , *child , *parent;
	int key , degree; 
	bool mark ;
}node;

node *create_node(int a)
{
	node *temp = new node();
	temp->left = temp;
	temp->right = temp;
	temp->parent = NULL;
	temp->child = NULL;
	temp->degree = 0;
	temp->key = a;
	temp->mark = false;
	

	return temp;
}

node* delete_node(node *head)
{
	head->left->right = head->right;
	head->right->left = head->left;
	head->right = head;
	head->left = head;

	return head;
}

void showHeap( node *x, int depth )
{
	x->mark = true;
	if ( x->right->mark == false )
		showHeap( x->right, depth );
	
	
	if ( x->child != NULL )
	{	
		for (int i = 1; i <= (6*depth); ++i)
			cout<<" ";
	
		cout<<x->key<<endl;
		x->mark = false;

	}
	else if(x->parent == NULL && depth != 0)
	{
		for (int i = 1; i <= 6*depth; ++i)
			cout<<" ";
		
		cout<<x->key;
		x->mark = false;

		if ( x->child == NULL ) 
			cout<<"\n"<<endl;
	}
	else if(depth == 0){
		cout<<x->key<<endl;
		x->mark = false;
	}
	else{
		for (int i = 1; i <= (6*depth); ++i)
			cout<<" ";
	
		cout<<x->key<<"\n"<<endl;
		x->mark = false;
	}
	
	if ( x->child != NULL )
		showHeap( x->child, depth + 1 );
	
}


node* concat( node *h1 , node* h2)
{
	node *temp1 = h1->right;
	node *temp2 = h2->right;

	h1->right = temp2;
	h2->right = temp1;
	temp1->left = h2;
	temp2->left = h1;

	if(h2->key < h1->key)
		h1 = h2;
	
	return h1;
}

node* consolidate( node *h , int n)
{
	int size = (log(n)/log(2))+1;

	int arr[size] = {0};
	node *node_arr[size] = {NULL} ;
	node *temp = h;
	
	while(true)
	{
		if(arr[temp->degree] == 0 || node_arr[temp->degree] == temp   )
		{
			arr[temp->degree] = temp->key;
			
			node_arr[temp->degree] = temp;
			temp=temp->right;
			if(temp ==h)
				break;
		}
		else if(arr[temp->degree] != 0 && node_arr[temp->degree] != temp)
		{
			if(temp->degree == 0 )
			{
				if(temp->key <= node_arr[0]->key)
				{
					node_arr[0] = delete_node(node_arr[0]);
					temp->child = node_arr[0];
					node_arr[0]->parent = temp; 
					arr[temp->degree]=0;
					temp->degree++;
				}
				else
				{
					temp = delete_node(temp);
					node_arr[0]->child = temp;
					temp->parent = node_arr[0];
					arr[temp->degree]=0;
					node_arr[0]->degree++;
					temp = node_arr[0];
			
				}
			}
			else
			{
				if(temp->key <= node_arr[temp->degree]->key)
				{
					node *h1 = temp->child;
					node *h2 = node_arr[temp->degree];
					h2 = delete_node(h2);

					concat(h1 , h2);
					arr[temp->degree]=0;
					temp->degree++;

				}
				else
				{
					node *h1 = node_arr[temp->degree]->child;
					node *h2 = temp;

					h2 = delete_node(h2);
					concat(h1 , h2);
					arr[temp->degree] = 0;
					node_arr[temp->degree]->degree++;
					temp = node_arr[temp->degree];
				}

			}

		}


	}





}

node* Union (node *h1 , node *h2 )
{
	h1 = concat(h1 , h2);
	return h1;
}

node* extract_min( node *h , int *n , bool status)
{
	node *head1 = h->right;
	h = delete_node(h);
	
	if(*n == 0)
	{
		cout<<"empty heap"<<endl;
		return h;
	}

	if(status == true)
		cout<<"extracted min element is "<<h->key<<endl;

	
	node *temp1 = head1->right;

	while(temp1 != head1)
	{
		if(temp1->key < head1->key)
			head1 = temp1;
		temp1 = temp1->right;
	}

	if(h->degree == 0)
	{
		return head1;
	}
	else
	{
		
		node *head2 = h->child;
		head2->parent = NULL;
		h->child = NULL;
		node *temp2 = head2->right;
		
		while(temp2 != head2)
		{
			if(temp2->key < head2->key)
				head2 = temp2;
			temp2 = temp2->right;
		}
	
		if(head1 != h)
			head2 = Union(head1 , head2);
		
		*n = *n -1;
		head2 = consolidate(head2 , *n );


		return head2;

	}

}



int main()
{
	int num;
	char c;
	cin>>c;
	cin>>c>>num;
	node *h1 = create_node(num);
	int counter = 1;
	bool status =false;

	while((c = getchar()) != EOF)
	{
		cin>>c;
		if(c=='i')
		{
			cin>>num;
			counter++;
			node *h2 = create_node(num);
			h1 = Union(h1 , h2);
			
			h1 = consolidate(h1 , counter);
			
		}
		else if(c == 'd' || c =='e')
		{
			h1 = extract_min(h1 , &counter , status);


		}
		else if(c =='+')
			status = true;
		else if(c == '-')
			status = false;
		else if(c == 'S')
			showHeap(h1,0);
		if(c == 'q')
			break;


	}
	
	return 0;
}