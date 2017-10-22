#include <bits/stdc++.h>
using namespace std;
/**************TEMPLATE***************************************************************************************************/
#define ll long long int
#define fast_io std::ios::sync_with_stdio(false),cin.tie(NULL),cout.tie(NULL)



/*************************************************************************************************************************/
vector<int>g[200];
bool visit[200];
bool visit2[200];

bool dfs(int node)
{
	if(visit[node]==0)
	{
		visit[node]=1;
		visit2[node]=1;
	}
	bool ans=true;
	for(int i=0;i<g[node].size();i++)
	{
		if(visit[g[node][i]]==0)
		{
			ans &= dfs(g[node][i]);
		}
		else if(visit2[g[node][i]]==1 && g[node][i]!=node)
		{
			return false;
		}
	}
	visit2[node]=false;
	return ans;
}


int main()
{
	
	int n,e;
	cin>>n>>e;
	for(int i=0;i<e;i++)
	{
		int x,y;
		cin>>x>>y;
		g[x].push_back(y);
	}
	
	memset(visit,0,sizeof(visit));
	memset(visit2,0,sizeof(visit2));
	bool ans=true;
	for(int i=1;i<=n;i++)
	{	
		
		
		if(visit[i]==0)
		{
			if(!dfs(i))
			{cout<<"Cycle Detected"<<endl;
			return 0;}
		}
			
		
	}
	
	cout<<"No Cycle Detected"<<endl;
}