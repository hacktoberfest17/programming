#include <iostream>
#include <cmath>

#define ll long long

const int N = 1000000;
using namespace std;

int spf[N +100];

void sieve()
{
	for(int i = 1; i <= N; i += 2)
		spf[i] = i;
	
	for(int i = 2; i <= N; i += 2)
		spf[i] = 2;
		
	int till = sqrt(N);
	for(int i = 3; i <= till +1; i += 2)
	{
		if(spf[i] == i)
		{
			for(int j = i +i; j <= N; j += i)
			{
				if(spf[j] == j)
					spf[j] = i;
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	sieve();
	
	for(int i = 2; i < 100; i++)
		cout << i << ": " << spf[i] << '\n';
		
	return 0;
}
