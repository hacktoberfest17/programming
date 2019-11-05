#include <bits/stdc++.h>
typedef long long int  ll;
using namespace std;

int main(){

	int n;
	cout<<"Enter n \n";
	cin>>n;
	long double alpha1 = (-1+sqrt(5))/2;
	long double ans = sqrt(5)*pow(alpha1,n);
	long double final = 1/ans;
	ll f = round(final);
	cout<<"Number : "<<f<<endl;
	return 0;
}