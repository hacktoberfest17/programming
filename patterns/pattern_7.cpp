#include<iostream>
using namespace std;
int main()
{
	int n;
	cout <<"Enter a range: ";
	cin >>n;
	
	for(int i=1; i<n; i++)
	{
		for(int j=n; j>i; j--)
		{
			cout <<" ";
		}
		for(int k=1; k<2*i; k++)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	for(int x=1; x<n; x++)
	{
		for(int y=1; y<=x; y++)
		{
			cout <<" ";
		}
		for(int z=2*n-1; z>2*x; z--)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	return 0;
}