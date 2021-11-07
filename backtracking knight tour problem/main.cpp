#include <bits/stdc++.h>
#define ll long long
#define N 8
using namespace std;
ll solveKnightTour(ll x,ll y,ll moveI,ll sol[N][N],ll xMove[],ll yMove[]);
bool isSafe(ll x,ll y,ll sol[N][N])
{
    if(x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1)
        return true;
    return false;
}
void printSolution(ll sol[N][N])
{
    for(ll i=0; i<N; i++)
    {
        for(ll j=0; j<N; j++)
        {
            cout<<sol[i][j]<<" ";
        }
        cout<<endl;
    }
}
bool solve()
{
    ll sol[N][N];
    memset(sol,-1,sizeof(sol));
    ll xMove[]= {2,1,-1,-2,-2,-1,1,2};
    ll yMove[]= {1,2,2,1,-1,-2,-2,-1};
    sol[0][0]=0;
    if(solveKnightTour(0,0,1,sol,xMove,yMove)==false)
        cout<<"solution does not exist"<<endl;
    else
        printSolution(sol);
    return true;
}
ll solveKnightTour(ll x,ll y,ll moveI,ll sol[N][N],ll xMove[N],ll yMove[N])
{
    ll k,next_x,next_y;
    if(moveI==N*N)
        return true;
    for(k=0; k<8; k++)
    {
        next_x=x+xMove[k];
        next_y=y+yMove[k];
        if(isSafe(next_x,next_y,sol))
        {
            sol[next_x][next_y]=moveI;
            if(solveKnightTour(next_x,next_y,moveI+1,sol,xMove,yMove)==true)
                return true;
            else
                sol[next_x][next_y]=-1;
        }
    }
    return false;
}
int main()
{
    solve();
    return 0;
}
