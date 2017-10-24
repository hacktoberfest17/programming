#include<iostream>
using namespace std;
int main()
{
	int n;
	cout <<"Enter a Range: ";
	cin >>n;
	
	for(int i=1; i<=n; i++)
	{
		for(int j=n; j>=i; j--)
		{
			cout <<"*";
		}
		for(int k=1; k<i*2; k++)
		{
			cout <<" ";
		}
		for(int l=n; l>=i; l--)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	return 0;
}