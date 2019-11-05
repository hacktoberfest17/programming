#include <bits/stdc++.h>
#define ll long long 
using namespace std;

ll find_rev(ll num){
    ll rev;
    ll rem;
    while(num!=0)
	{
		rem=num%10;
		rev=rev*10+rem;
		num=num/10;
	}
	return rev;
}

bool adam_check(ll num){
    ll rev,numsquare,revsquare;
    rev=find_rev(num);
    numsquare=pow(num,2);
    cout<<"The square of the number is : "<<numsquare<<endl;
    revsquare=find_rev(numsquare);
    cout<<"The reverse of the square of the number is : "<<revsquare<<endl;
    ll revsquareroot;
    revsquareroot=sqrt(revsquare);
    cout<<"The square root of the reverse of the squared of the number is : "<<revsquareroot<<endl;
    cout<<"The reverse of the number is : "<<rev<<endl;
	//cout<<find_rev(numroot)<<endl;
    if(rev==revsquareroot){
        return true;
    }
    else return false;
}

int main() {
    
    ll num;
    cout<<"Enter the number you want to check : ";
    cin>>num;
    if(adam_check(num)==true)
        cout<<endl<<"The number you entered is an adam's number";
    else cout<<endl<<"The number you entered is not an adam's number";
    
	return 0;
}

