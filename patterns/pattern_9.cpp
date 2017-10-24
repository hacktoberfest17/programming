#include<iostream>
using namespace std;
int main()
{
	int n;
	cout <<"Enter a Range: ";
	cin >>n;
	
	for(int i=0; i<=n; i++)
	{
		for(int j=0; j<=n-i; j++)
		{
			cout <<"*";
		}
		for(int k=1; k<=2*i; k++)
		{
			cout <<" ";
		}
		for(int l=0; l<=n-i; l++)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	
	for(int i=0; i<=n; i++)
	{
		for(int j=0; j<=i; j++)
		{
			cout <<"*";
		}
		for(int k=2*(n-i); k>0; k--)
		{
			cout <<" ";
		}
		for(int l=0; l<=i; l++)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	return 0;
}