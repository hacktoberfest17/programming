#include <bits/stdc++.h>
using namespace std;

const int N=1e6+5;

int A[N], lazy[2*N+2], tree[2*N+2];

void make_tree(int node, int start, int end)
{
	if(start == end)
	{
		tree[node] = A[start];
	}
	else
	{
		int mid = (start+end)/2;
		make_tree(2*node, start, mid);
		make_tree(2*node + 1, mid+1, end);
		
		tree[node] = tree[2*node] + tree[2*node + 1];
	}
	return;
}

void updateRange_tree(int node, int start, int end, int l, int r, int num)
{
	if(lazy[node]!=0)
	{
		tree[node] += (end-start+1)*lazy[node];
		
		if(start!=end)
		{
			lazy[2*node]= lazy[node];
			lazy[2*node+1]= lazy[node];
		}
		lazy[node]=0;
	}
	if(r<start || end<l)
	return;
	
	if(l<=start && end<=r)
	{
		tree[node] += (end-start+1)*num;
		if(start!=end)
		{
			lazy[2*node] += num;
			lazy[2*node+1] += num;
		}
		return;
	}
	
	int mid= (start+end)/2;
	updateRange_tree(2*node,start,mid,l,r,num);
	updateRange_tree(2*node+1,mid+1,end,l,r,num);
		
	tree[node] = tree[2*node]+ tree[2*node+1];
	return;	
}

int query_tree(int node, int start, int end, int l, int r)
{
	if(r<start || end<l)
	return 0;
	if(lazy[node]!=0)
	{
		tree[node] += (end-start+1)*lazy[node];
		if(start!=end)
		{
			lazy[2*node] += lazy[node];
			lazy[2*node] += lazy[node];
		}
		lazy[node]=0;
	}
	
	if(l<=start && end<=r)
	return tree[node];
	
	int mid=(start+end)/2;
	int q1=query_tree(2*node,start,mid,l,r);
	int q2=query_tree(2*node+1,mid+1,end,l,r);
	
	return q1+q2;
}

int main()
{
	int n,q,l,r,num;
	string s;
	
	cin>>n;
	
	for(int i=1;i<=n;i++)
	cin>>A[i];
	
	make_tree(1,1,n);
	
	cin>>q;

	for(int i=1;i<=q;i++)
	{
		cin>>s>>l>>r;
		
		if(s == "update")
		{
			cin>>num;
			updateRange_tree(1,1,n,l,r,num);
		}
		else if(s == "query")
		{
			int ans = query_tree(1,1,n,l,r);
			cout<<ans;
		}
		else
		cout<<"Invalid Input";
	}
	
	return 0;
}
