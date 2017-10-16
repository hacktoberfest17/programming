#include<iostream>
#include<stdio.h>
using namespace std;
 
int result[1000] = {0};
long long int fact_dp(int n)
{
    result[0] = 1;
    for (int i = 1; i <= n; ++i) 
    {
    	result[i] = i * result[i - 1];
    }
    
    return result[n];
}
int main()
{
	int n;
	cout<<"Enter a number :";
	cin>>n;
	if(n==0)
		cout<<1<<endl;
	else
		cout<<"Factorial :"<<fact_dp(n)<<endl;

}
