#include <bits/stdc++.h>
using namespace std;
long long int ans[1000][1000];
int main()
{
    long long int n;
    scanf("%lld",&n);
    int m = n+1;
    vector<long long int> a;
    long long int inp;
    for(int i=0;i<m;i++)
    {
        scanf("%lld",&inp);
        a.push_back(inp);
    }

    for(int l=2;l<m;l++)
    {
        for(int j = 1;j<m-l+1;j++)
        {
            int i = l + j - 1;
            ans[j][i] = 100000000000000000;
            int k = j;
            while(k<=i-1)
            {
             ans[j][i] = min(ans[j][k] + ans[k+1][i] + a[j-1]*a[k]*a[i],ans[j][i]);
             k++;
            }
        }
    }
    printf("%lld\n",ans[1][m-1]);
    return 0;

}