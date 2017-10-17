#include <bits/stdc++.h>
#define fi first
#define se second
using namespace std;
typedef long long ll;

ll tree[1000003];
ll sz[1000003];

ll root(ll i){
    while(tree[i]!=i){
        i=tree[i];
    }
    return i;
}

void un(ll p,ll q){
    p=root(p);
    q=root(q);
    if(sz[p]>sz[q]){
        tree[q]=p;
        sz[p]+=sz[q];
    }else{
        tree[p]=q;
        sz[q]+=sz[p];
    }
}

ll find(ll p,ll q){
    if(root(p)==root(q)){
        return 1;
    }else return 0;
}

int main(){
	for(ll i=0;i<1000003;i++){
		tree[i]=i;
		sz[i]=1;
	}
}
