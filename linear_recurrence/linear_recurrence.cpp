/*
		LINEAR RECURRENCE MATRIX METHOD 

		Author : Apaar Gupta
		C++
		Solution Time Complexity : O(K^3*log(n))


							PROBLEM STATEMENT


		A linear recurrence may be defined as :

			f(i) =  a1*f(i-1) + a2*f(i-2) + ... + ak*f(i-k)

								where a1,a2,..,ak are known constants
								and f(1),f(2),...,f(k) are known

		Given f, a function defined as a linear recurrence relation.
		Compute f(N). N may be very large (N ~ 10^18)

		Example problem
		Link : http://www.spoj.com/problems/SEQ/


*/

#include <bits/stdc++.h>
#define MAX(a,b)   (((a)>(b))?(a):(b))
#define MIN(a,b)   (((a)>(b))?(b):(a))
#define ABS(x)     (((x)>0)?(x):(-(x)))
#define pb         push_back
#define mp         make_pair
#define fi         first
#define se         second
#define all(x)     x.begin(),x.end()
#define rall(x)    x.rbegin(),x.rend()
#define vi         vector<lli>
#define pii        pair<lli,lli>
#define rep(lo,hi) for(lli i=lo;i<hi;i++)
#define mem(a,val) memset(a,val,sizeof(a))
#define digits(n)  (floor(log10(n))+1)
#define MOD        1000000000
using namespace std;
typedef long long int lli;
typedef vector<vector<lli> > matrix;
const lli INF = (lli)1e18+10;
const int inf = 0x3f3f3f3f;
const double PHI = ((sqrt(5)+1)/2);
const double PI = acos(-1.0);

#define N 100010

lli K;
matrix mul(matrix A,matrix B)
{	matrix C(K+1,vector<lli>(K+1,0));
	for(lli i=1;i<=K;i++)
	for(lli j=1;j<=K;j++)
	for(lli k=1;k<=K;k++)
		C[i][j]=(C[i][j]+(A[i][k]*B[k][j])%MOD)%MOD;
	return C;
}
matrix power(matrix A,lli p)
{	if(p==1) return A;
	if(p%2) return mul(A,power(A,p-1));
	matrix X=power(A,p/2);
	return mul(X,X);
}
int main()
{	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int t;
	cin>>t;
	while(t--)
	{	lli n;
		cin>>K;
		vector<lli> b(K+1),c(K+1);
		rep(1,K+1) cin>>b[i];
		rep(1,K+1) cin>>c[i];
		cin>>n;
		if(n==1)
		{	cout<<b[1]<<endl;
			continue;
		}
		matrix T(K+1,vector<lli>(K+1,0));
		for(lli i=1;i<K;i++) T[i][i+1]=1;
		for(lli j=1;j<=K;j++) T[K][j]=c[K-j+1];
		T=power(T,n-1);
		lli ans=0;
		for(lli i=1;i<=K;i++)
			ans=(ans+(T[1][i]*b[i])%MOD)%MOD;
		cout<<ans<<endl;
	}
	return 0;
}
