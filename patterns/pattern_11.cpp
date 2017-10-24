#include<iostream>
using namespace std;
int main()
{
	int n;
	cout <<"Enter a range: ";
	cin >>n;
	
	for(int i=0; i<=n; i++)
	{
		for(int j=0; j<=n-i; j++)
		{
			cout <<" ";
		}
		for(int k=0; k<=i; k++)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	for(int i=0; i<=n; i++)
	{
		for(int k=0; k<=i; k++)
		{
			cout <<" ";
		}
		for(int j=0; j<=n-i; j++)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	return 0;
}