#include<iostream>
using namespace std;
int main()
{
	int n;
	cout <<"Enter a Range: ";
	cin>>n;
	for(int i=0; i<=n; i++)
	{
		for(int j=0; j<=i; j++)
		{
			cout <<" ";
		}
		for(int k=n; k>i; k--)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	return 0;
}