#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll build(ll node, ll tree[],ll a[],ll start,ll end){
	if(start==end){
		tree[node]=a[start];
		return a[start];
	}else{
		ll mid=(start+end)/2;
		tree[node]=build(2*node,tree,a,start,mid)+build(2*node+1,tree,a,mid+1,end);
	}
}

ll update(ll node, ll tree[], ll a[], ll index, ll start, ll end,ll new_val){
	if(index<start || index>end){
		return tree[node];
	}else if(start==end && start==index){
		tree[node]=new_val;
		a[index]=new_val;
		return new_val;
	}else{
		ll mid=(start+end)/2;
		tree[node]=update(2*node,tree,a,index,start,mid,new_val)+update(2*node+1,tree,a,index,mid+1,end,new_val);
	}
}

ll query(ll node, ll tree[], ll a[], ll start, ll end, ll l, ll r){
	if(end<l || start>r){
		return 0;
	}else if(start>=l && end<=r){
		return tree[node];
	}else{
		ll mid=(start+end)/2;
		return query(2*node,tree,a,start,mid,l,r)+query(2*node+1,tree,a,mid+1,end,l,r);
	}
}

int main(){
	ll tree[100000]={0},node=1,a[100000],n;
	cin>>n;
	for(ll i=0;i<n;i++){
		cin>>a[i];
	}
	build(node,tree,a,0,n-1);
	//update(node,tree,a,2,0,n-1,0);
	ll p=query(node,tree,a,0,n-1,3	,n-1);
	cout<<p;
}
