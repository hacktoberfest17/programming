#include<iostream>
#include<string>
using namespace std;

//convert till Base 36
string arr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

string covert(int N, int B){
	if (N < B)
		return string(1,arr[N]);
	else
		return (covert((int)(N / B), B) + string(1, arr[N%B]));
}

int main(){
	int n, b;
	cin >> n >> b;
	cout << covert(n, b);
	return 0;
}
