#include <bits/stdc++.h>
using namespace std;

typedef struct Node{
	char key;
	struct Node* next;
}node;

typedef struct Sta{
	char data[100];
	int top;
}sta;

void Push(sta* s,char k){
	s->top=s->top+1;
	if(s->top>99){
		cout<<"Stack is full. Cannot push "<<k<<endl;
		return;
	}
	s->data[s->top]=k;
}

char pop(sta* s){
	if(s->top==-1){
		cout<<"Stack is empty. Cannot pop."<<endl;
		return '.';
	}
	s->top=s->top-1;
	return s->data[s->top+1];
}

node* CreateNode(char key){
	node* k=new node;
	k->next=NULL;
	k->key=key;
	return k;
}

void Read_Graph(int n,int e,node** List){
	char a,b;
	for(int i=0;i<e;i++){
		cin>>a>>b;
		int k=a-'a';
		node* m=CreateNode(b);
		if(List[k]==NULL){
			List[k]=m;
		}
		else{
			node* temp=List[k];
			if(List[k]->next==NULL || b<List[k]->key){
				if(List[k]->key<b){
					List[k]->next=m;
				}
				else{
					m->next=List[k];
					List[k]=m;
				}
			}
			else{
				while(temp->next!=NULL && temp->next->key<b){
					temp=temp->next;
				}
				m->next=temp->next;
				temp->next=m;
			}
		}
	}
}

void DFS_Non_Recursive(int i,node** List,int* color,char* parent,int n){
	sta* s=new sta;
	string ss="";
	s->top=-1;
	char d='a'+i;
	Push(s,d);
	int p=0;
	node*temp=NULL;
	while(s->top!=-1){
		p=0;
		i=s->data[s->top]-'a';
		color[i]=1;
		temp=List[i];
		while(temp!=NULL){
			if(color[temp->key-'a']==0){
				if(ss.length()!=0){
					ss+=", ";
				}
				ss=ss+"("+s->data[s->top]+","+temp->key+")";
				//cout<<"("<<s->data[s->top]<<","<<temp->key<<"), ";
				Push(s,temp->key);
				p=1;
				break;
			}
			temp=temp->next;
		}
		if(p==1){continue;}
		else{
			color[i]=2;
			pop(s);
		}
	}
	cout<<ss;
}

void DFS(node** List,int* color,char* parent,int n){
	for(int i=0;i<26;i++){
		color[i]=0;
		parent[i]='.';
	}
	int p=0;
	for(int i=0;i<26;i++){
		if(color[i]==0 && List[i]!=NULL){
			if(p){cout<<", ";}
			p=1;
			DFS_Recursive(i,List,color,parent,n);
		}
	}
	cout<<endl;
}

void DFS_Enhanced_Non_Recursive(int i,node** List,int* color,char* parent,int* dd,int n){
	sta* s=new sta;
	s->top=-1;
	static int time=0;
	char d='a'+i;
	Push(s,d);
	time++;
	dd[i]=time;
	int p=0;
	node*temp=NULL;
	while(s->top!=-1){
		p=0;
		i=s->data[s->top]-'a';
		color[i]=1;
		temp=List[i];
		while(temp!=NULL){
			if(temp->key=='.'){}
			else if(color[temp->key-'a']==0){
				Push(s,temp->key);
				time++;
				dd[temp->key-'a']=time;
				p=1;
				temp->key='.';
				break;
			}
			else if(color[temp->key-'a']==1){
				cout<<"Back Edge: ("<<s->data[s->top]<<","<<temp->key<<")"<<endl;
			}
			else{
				if(dd[i]<dd[temp->key-'a']){
					cout<<"Forward Edge: ("<<s->data[s->top]<<","<<temp->key<<")"<<endl;
				}
				else{
					cout<<"Cross Edge: ("<<s->data[s->top]<<","<<temp->key<<")"<<endl;
				}
			}
			temp=temp->next;
		}
		if(p==1){continue;}
		else{
			time++;
			color[i]=2;
			pop(s);
		}
	}
}

void DFS_Enhanced(node** List,int* color,char* parent,int n){
	int* d=new int[26];
	for(int i=0;i<26;i++){
		color[i]=0;
		d[i]=INT_MAX;
		parent[i]='.';
	}
	for(int i=0;i<26;i++){
		if(color[i]==0 && List[i]!=NULL){
			DFS_Enhanced_Recursive(i,List,color,parent,d,n);
		}
	}
	cout<<endl;
}

int main(){
	int n,e;
	cin>>n>>e;
	int* color=new int[26];
	char* parent=new char[26];
	node** List=new node*[26];
	Read_Graph(n,e,List);
	string* ss;
	DFS(List,color,parent,n);
	cout<<"Tree edges:";
	DFS(List,color,parent,n);
	DFS_Enhanced(List,color,parent,n);
	return 0;
}