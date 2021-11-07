#include <iostream>

using namespace std;

int simplif(int a, int b)
{
    int x,y;

    x=a;
    y=b;
    while(x!=y)
        if(x>y)
            x=x-y;
        else
            y=y-x;
            if(x==1)
        cout<<a<<" "<<b;
        else
            cout<<a/x<<" "<<b/x;
}

int main()
{
    int p;
    struct
    {
        int x,y;
    }a,b;
    cin>>a.x>>a.y>>b.x>>b.y;
    if((float)a.x/a.y>(float)b.x/b.y)
        p=1;
        else
        p=2;
    if (p==1)
    {
        simplif(a.x,a.y);
    }
    else
    {
        simplif(b.x,b.y);
    }

    return 0;
}
