// How to check if a given number is a power of 2
#include <iostream>
using namespace std;

bool isPowerOfTwo(int x){
    return (x && !(x&(x-1)));
}

int main() {
	int n;
	cin>>n;
	if(isPowerOfTwo(n)) cout<<"This number can be written as power of 2";
	else cout<<"No";
	return 0;
}