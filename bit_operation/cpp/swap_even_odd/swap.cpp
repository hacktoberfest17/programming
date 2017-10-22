#include<iostream>
using namespace std;
int main()
 {
	//code
	int t;
	cin>>t;
	while(t--)
	{
	    int n;
	    cin>>n;
	    unsigned int even=n&(0x5555);
	    unsigned int odd=n&(0xAAAA);
	    even=even<<1;
	    odd=odd>>1;
	    unsigned int num=even|odd;
	    cout<<num<<endl;
	}
	return 0;
}
