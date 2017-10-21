#include<bits/stdc++.h>

using namespace std;

int main()
{
	cout<<"Rule of three\n";
	cout<<"For an equation of the form :\n";
	cout<<"a ->b\n";
	cout<<"x ->c\n";
	cout<<"where x is unknown\n";
	int a,b,c,x;
	cout<<"Please enter value of a b c ";
	cin>>a>>b>>c;
	x=(a*c)/b;
	cout<<"Value of x is:"<<x;
	return 0;
}

