#include <stdio.h>
#include <stdlib.h>


//struct node defined here.
struct node
{
	int data;
	struct node *next;
	int color;
	struct node *parentbfs;
};

//this function will return a node pointer with memory allocated to it.
struct node *make()
{
	struct node *p=(struct node *)malloc(sizeof(struct node));
	p->next=NULL;
	p->parentbfs=NULL;
	return p;
}

//bfs function.
void bfs(struct node *a[],int size)
{
	//make parent of all the nodes as NULL and mark them as unvisited.
	for(int i=0;i<size;i++)
	{
		a[i]->color=-1;
		a[i]->parentbfs=NULL;
	}

	//start with the very first node and mark it as visited.
	a[0]->color=0;
	struct node *q[100];		//a queue to maintain bfs.

	//initialize the queue.
	for(int j=0;j<100;j++){
		q[j]=(struct node *)malloc(sizeof(struct node));
	}
	int k=1;
	int cnt=1;

	//this loop makes sure that all the elements are visited.
	while(k<size){
		printf("List of connected components %d:\n",cnt);
		cnt++;
		int i=-1;
		int f=0;

		//insert the first element of the array into the queue.
		q[++i]=a[k];
	
		//condition while queue is not empty.
		while(i>=f){
			struct node *u=q[f++];		//dequeue the first element of the queue.
			printf("%d ",u->data);		//print its value.
			struct node *p=u;

			//check its neighberhood elements
			while(p->next!=NULL){
				p=p->next;
				int j;
				//search for the element in the array.
				for(j=0;j<size;j++){
					if(a[j]->data==p->data) break;
				}
				//enqueue all its neighbrhood elements
				if(a[j]->color==-1){
					q[++i]=a[j];
					a[j]->color=0;
					a[j]->parentbfs=u;
				}
			}	

			//mark the element as black as all its neighberhood elements are now visited.
			u->color=1;
		}
		printf("\n");

		//this loop checks whwther there is any element in the array that has not yet been visited.
		for(k=0;k<size;k++){
			if(a[k]->color==-1) break;
		}
	}
}


//main starts here.
int main()
{
	printf("//********************************\\ \n");
	printf("\n\nProgram to find the connected components in an undirected graph.\n\n\n");
	printf("//********************************\\ \n\n\n");
	int v,e;
	printf("Enter the no of vertices and edges.\n");
	scanf("%d%d",&v,&e);		//take input as verteices and edges.
	struct node *a[v+1];		//create an array of pointers.

	//allocate value to every entry of the array.
	for(int i=0;i<v+1;i++)
	{
		a[i]=make();
		a[i]->data=i;
	}

	//scan all the edges.
	printf("\n\nEnter the edges of the graph.\n\n");
	for (int i = 0; i < e; i++)
	{
		int x,y;
		scanf("%d%d",&x,&y);		//take input the two edges.

		//make two nodes having values equal two each of the nodes.
		struct node *p=make();
		p->data=x;
		struct node *q=make();
		q->data=y;

		//if the position in the array is NULL, simply attach the the new node to it.
		//if position is not empty then attach at the starting position.
		if(a[x]->next==NULL)
		{
			a[x]->next=q;
			
		}
		else
		{
			q->next=a[x]->next;
			a[x]->next=q;
		}
		if (a[y]->next==NULL)
		{
			a[y]->next=p;

		}
		else
		{
			p->next=a[y]->next;
			a[y]->next=p;
		}
	}
	
	printf("\n");
	bfs(a,v+1);
	
	printf("\n");
	return 0;
}
