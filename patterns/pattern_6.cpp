#include<iostream>
using namespace std;
int main()
{
	int n;
	cout <<"Enter a range: ";
	cin >>n;
	for(int i=1; i<=n; i++)
	{
		for(int j=n; j>=i; j--)
		{
			cout <<" ";
		}
		for(int k=2; k<=2*i; k++)
		{
			cout <<"*";
		}
		cout <<endl;
	}
	return 0;
}