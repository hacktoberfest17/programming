#include <bits/stdc++.h>
#define ll long long int

using namespace std;
vector<ll> gr[1010];

void bfs(ll u,ll V,bool vis[])
{
    queue<ll> q;
    vis[u]=true;
    q.push(u);
    while(!q.empty())
    {
        ll ver=q.front();
        q.pop();
        cout<<ver<<" ";
        for(ll i=0; i<gr[ver].size(); i++)
            if(!vis[gr[ver][i]])
            {
                vis[gr[ver][i]]=true;
                q.push(gr[ver][i]);
            }
    }
}
void bfsMain(ll src,ll V)
{
    bool vis[V];
    fill(vis,vis+V,false);
    bfs(src,V,vis);
    for(ll i=0; i<V; i++)
        if(!vis[i])
            bfs(i,V,vis);
}
int main()
{
    ll v,e;
    cin>>v>>e;
    while(e--)
    {
        ll u,v;
        cin>>u>>v;
        gr[u].push_back(v);
        gr[v].push_back(u);

    }
    ll src;
    cin>>src;
    bfsMain(src,v);
    return 0;
}
