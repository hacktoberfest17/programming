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

int main()
{
	//freopen("in.txt","r",stdin);
	int n;
    cin>>n;
	cout<<"Prime factors of "<<n<<" are: "<<endl;
	
	vector<int> prime;      // take set for unique prime numbers
	while (n%2 == 0)
    {
        prime.pb(2);
        n = n/2;
    }

    for (int i = 3; i <= sqrt(n); i = i+2)
    {
        while (n%i == 0)
        {
            prime.pb(i);
            n = n/i;
        }
    }
 
    if (n > 2)
        prime.pb(n);

    for(int i=0;i<prime.size();i++){
    	cout<<prime[i]<<" ";
    }
    cout<<endl;

	return 0;
}