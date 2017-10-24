#include<iostream>
using namespace std;
int main()
{
	int n;
	cout <<"Enter a range: ";
	cin >>n;
	for(int i=0; i<=n; i++)
	{
		for(int j=n; j>i; j--)
		{
			cout <<"*";
		}
		for(int k=1; k<=2*i; k++)
		{
			cout <<" ";
		}
		for(int l=n; l>i; l--)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	for(int i=1; i<=n; i++)
	{
		for(int x=1; x<=i; x++)
		{
			cout <<"*";
		}
		for(int y=2*n; y>2*i; y--)
		{
			cout <<" ";
		}
		for(int z=1; z<=i; z++)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	return 0;
}