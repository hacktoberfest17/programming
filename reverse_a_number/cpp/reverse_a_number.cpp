#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n,r,num=0;
	cout<<"Enter the number:"<<endl;
        cin>>n;
	while(n!=0)
	{
		r=n%10;
                num=num*10+r;
		n=n/10;
	}
	cout<<"Reversed number="<<num;
	return 0;
}
