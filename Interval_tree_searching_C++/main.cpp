//using c++
//interval trees

#include <iostream>
#include <fstream>
using namespace std;
#define dim 100001
int n,m;
int maxArb[4*dim+66];
int start,finish, poz,val,maxim;

inline int Maxim(int a,int b)
{
    if(a>b)
        return a;
    else return b;
}

void update(int, int, int);
void query(int, int, int);

int main()
{
    int a,b,x;
    ifstream fin("arbint.in");
    ofstream fout("arbint.out");
    fin>>n>>m;
    //update
    for(int i=1;i<=n;i++)
    {
        fin>>x;
        poz=i; val=x;
        update(1,1,n);
    }
    //update

    //query
    for(int i=1;i<=m;i++)
    {
        fin>>x>>a>>b;
        if(x == 0)
        {
            maxim=-1;
            start=a; finish=b;
            query(1,1,n);
            fout<<maxim<<'\n';
        }
        else
        {
            poz=a; val=b;
            update(1,1,n);
        }
    }
    //query

    return 0;
}

void update(int nod, int left, int right)
{
    if(left==right)
    {
        maxArb[nod]=val;
        return;
    }
        int div = (left+ right)/2;
        if(poz<=div) update(2*nod,left,div);
        else         update(2*nod+1,div+1,right);

        maxArb[nod]=Maxim(maxArb[2*nod],maxArb[2*nod+1]);
}
void query(int nod, int left, int right)
{
    if(start<= left && finish>=right)
    {
        if(maxim<maxArb[nod])
            maxim=maxArb[nod];
            return;
    }
    int div=(left+right)/2;
    if(start<=div) query(2*nod,left,div);
    if(div<finish) query(2*nod+1,div+1,right);
}
