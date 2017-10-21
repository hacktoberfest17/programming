#include <iostream>
#include <cmath>
#include <vector>

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

vector <int> factorize(int n)
{
	vector <int> res;
	
	while(n != 1)
	{
		res.push_back(spf[n]);
		n /= spf[n];
	}
	
	return res;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	sieve();
	
	vector <int> factorization = factorize(100);
	
	for(int p : factorization)
		cout << p << ' ';
	cout << '\n';
	
	return 0;
}
