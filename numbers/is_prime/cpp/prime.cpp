#include<iostream>
using namespace std;
int main()
{
	long long int n,f=0;
	cin>>n;
	if(n==1) 
		cout<<"It is neither prime nor composite"<<endl;
	else
	{	for(int i=2; i<n;i++)
			if (n%i==0)
			f++;
		if(f==0)
		cout<<"It is prime"<<endl;
		else cout<<"It is composite"<<endl;
	}
	return 0;

}