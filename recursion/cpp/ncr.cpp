#include<bits/stdc++.h>

using namespace std;

#define pb push_back
#define mp make_pair
#define vi vector<int>
#define f first
#define s second
#define pii pair<int,int>
#define vii vector<pair<int,int> >
#define si stack<int>


#define MOD 1000000007

long long int ncr(int n,int k){
	int a[k+1];
    memset(a, 0, sizeof(a));

    a[0] = 1; 

    for (int i = 1; i <= n; i++)
    {
        for (int j = min(i, k); j > 0; j--)
            a[j] = a[j] + a[j-1];
    }
    return a[k];
}

int main()
{
	freopen("in.txt","r",stdin);
	int t;
	cin>>t;
	while(t--){
		int n,k;
		scanf("%d%d",&n,&k);
		cout<<ncr(n,k)<<endl;	
	}
	return 0;
}