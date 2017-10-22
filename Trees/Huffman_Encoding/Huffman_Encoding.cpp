#include<bits/stdc++.h>
using namespace std;

typedef struct _Node{
		string ch;
		int freq;
		_Node *left;
		_Node *right;
		_Node *parent;
}node;

typedef struct Queue{
		node *data[100];
		int front;
		int rear;
}queue;

node *createNode(char c,int f)
	{
		node *tmp=new node;
		tmp->ch=c;
		tmp->freq=f;
		tmp->left=NULL;
		tmp->right=NULL;
		tmp->parent=NULL;
		return tmp;
	}
node *merge(node *q1,node *q2)
	{
		node *tmp=new node;
		 tmp->ch.append(q1->ch);
		 tmp->ch.append(q2->ch);
		  tmp->freq=q1->freq+q2->freq;	//adding the freq of two nodes.
		 tmp->left=NULL;
		 tmp->right=NULL;
		 tmp->parent=NULL;
		 return tmp;
	}
void setleft(node **q,node **q1)
{
	(*q)->left=*q1;				//making q1 to the left of q.
	(*q1)->parent=(*q);

}
void setright(node **q,node **q2)
{
	(*q)->right=*q2;			//making q2 to the right of q.
	(*q2)->parent=(*q);
}
void insert(Queue *Q,node *q)
	{
		int i,j,flag=0;
		if(Q->rear< Q->front)		      //contidion for empty Queue.
		  Q->data[++Q->rear]=q;
		else
		{
			for(i=Q->rear;i>=Q->front;i--)				//finding correct position for node q according to freq.
			{											//the Queue is sorted according to frequency.
				if(Q->data[i]->freq > q->freq )
				{
					Q->data[i+1]=Q->data[i];


				}
				
				else{
					 for(;i>=Q->front;i--)
					 {
					 	if(Q->data[i]->freq==q->freq&&Q->data[i]->ch[0] > q->ch[0])	//if freq is same then sorted then
					 		Q->data[i+1]=Q->data[i];								//considering lexicographic order.
					 	else{
					 		 Q->data[i+1]=q;flag=1;Q->rear++;break;
					 	    }
					 }
					 if(flag==1)
					 	break;
					 
				   }
			}
			if(i==Q->front-1)						//if insertion is taking place at the beginning of Queue.
				{Q->data[i+1]=q;Q->rear++;}
			
		}

	}
node *Delete(Queue *Q)
{
	return(Q->data[Q->front++]);	//for deletion in the beginning of the Queue.
}

void printresult(node *P[],int k)
{
	string s;
	for(int i=0;i<k;i++)
	{
		s="";
    node *tmp=P[i];					//traversing from leaf node to the parent node.
    while(tmp->parent!=NULL)		//and appending the string s accordingly.
    {
    	node *t=tmp->parent;
    	if(t->left==tmp)
    		s="0"+s;
    	else
    		s="1"+s;
    	tmp=t;

    }
    cout<<P[i]->ch<<"="<<s<<" ";
    }
}
int main()
{
	string str;
	getline(cin,str);		
	int freq[26]={0};					//array to store frequency of the characters.
	node *P[26];						//array to store the Leaf Nodes.
	int k=0;
	Queue Q;
	Q.front=0;
	Q.rear=-1;
	for(int i=0;str[i]!='\0';i++)		
		str[i]=tolower(str[i]);
	for(int i=0;str[i]!='\0';i++)
			{
				if(str[i]>='a'&&str[i]<='z')  //calculating the freq of each character and storing them in freq array
					 freq[str[i]-'a']++;
				

			}

    for(int i=0;i<26;i++)
    {
    	if(freq[i]>0)
    	{									

    		node *q=createNode('a'+i,freq[i]);	//Leaf nodes are created and stored in P array.
    		P[k++]=q;
    		insert(&Q,q);						//inserting the leaf nodes in the Priority Queue.
    	}
  
    }
   while((Q.rear-Q.front)!=0)
    {
    	node *q1=Delete(&Q);		       //Deleting two starting nodes from the Queue.
    	node *q2=Delete(&Q);
    	node *q=merge(q1,q2);	          //merging the two nodes q1,q2 into q
    	setleft(&q,&q1);setright(&q,&q2); //creating proper linking btw q,q1 and q,q2.
    	insert(&Q,q);				      //inserting the final merge node again back to the Queue.
    }

    node *root=Q.data[Q.front];
    int pos=0;
    for(int i=0;str[i]!='\0';i++)
    {
    	for(int j=pos;j<k;j++)				//arranging the Leaf Nodes in array P according to their corresponding
    	{									// sequence in the string.
    		if(str[i]==P[j]->ch[0])
    		{
    			node *t=P[j];
    			P[j]=P[pos]; 
    			P[pos]=t;
    			pos++;
    		}
    	}
    }
    printresult(P,k);		//to print the final result.
	return 0;
}