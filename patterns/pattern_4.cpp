#include<iostream>
using namespace std;
int main()
{
	int n;
	cout <<"Enter a range: ";
	cin >>n;
	
	for(int i=0; i<=n; i++)
	{
		for(int j=0; j<=i; j++)
		{
			cout <<"*";
		}
		for(int k=n; k>i; k--)
		{
			cout <<" ";
		}
		for(int a=n; a>i; a--)
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