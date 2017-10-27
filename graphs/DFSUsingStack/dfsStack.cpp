#include<iostream>
#include<vector>
#include<queue>
#include<climits>
#include<stack>

using namespace std;

void dfs(vector<int>* adj, int source, int nodes)
{
    int u;
    stack<int> mystack;
    int visited[nodes];
    for(int i = 0; i < nodes; i++)
    {
        visited[i] = 0;
    }   
    mystack.push(source);
    visited[source] = 1;
    while(!mystack.empty())
    {
        u = mystack.top();
        mystack.pop();
        for(int j = 0; j < adj[u].size(); j++)
        {
            if(!visited[adj[u][j]])
            {
                mystack.push(adj[u][j]);
                visited[adj[u][j]] = 1;
            }
        }
        cout << u << " " ;
    }
}

int main()
{
    vector <int> adj[1000];
    int x, y, nodes, edges;
    int source;
    cin >> nodes;
    cin >> edges;
    cin >> source;
    for(int i = 0; i< edges; i++)
    {
        cin >> x >> y;
        adj[x].push_back(y); // inserting y in the adjacency list of x
    }
    dfs(adj, source, nodes);
    cout << endl;
    return 0;
}
