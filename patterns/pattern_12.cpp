//Temple - Using for loop
#include<iostream>
using namespace std;
int main()
{
	int n;
	cout <<"Enter a range: ";
	cin >>n;
	cout <<endl;
	for(int i=0; i<=n; i++)
	{
		for(int j=0; j<=n; j++)
		{
			cout <<" ";
		}
		for(int k=1; k<=i-i; k++)
		{
			cout <<"*";
		}
		for(int l=0; l<=i; l++)
		{
			cout <<"*";
		}
		for(int m=0; m<=n-i; m++)
		{
			cout <<" ";
		}
		cout <<endl;
	}
	for(int i=0; i<=n; i++)
	{
		for(int y=0; y<=n; y++)
		{
			cout <<" ";
		}
		for(int z=0; z<=i-i; z++)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	for(int i=0; i<=n; i++)
	{
		for(int j=0; j<=n-i; j++)
		{
			cout <<" ";
		}
		for(int k=0; k<=2*i; k++)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	for(int i=0; i<=n; i++)
	{
		cout <<"  ";
		for(int j=0; j<=2*n-2; j++)
		{
			cout <<"*";
		}
		cout <<endl;
		
	}
	return 0;
}