// MOD AUTHOR:  Aarushi Arya
// GITHUB    :  https://github.com/aarushi15002
// DATE      :  October 30, 2017
// DESCRITION:  This C++ program implements the fibonacci operation in a space efficient, non-recursive manner and works beyond long long

#include <iostream>
#include <string>
using namespace std;

string add(string a, string b) { // ADDED 
	string temp = "";
	while ((int)a.length() < (int)b.length()) {
		a = "0" + a;
	}
	while ((int)b.length() < (int)a.length()) {
		b = "0" + b;
	}
	int carry = 0;
	for (int i = a.length() - 1; i >= 0; i--) {
		char val = (char)(((a[i] - 48) + (b[i] - 48)) + 48 + carry);
		if (val > 57) {
			carry = 1;
			val -= 10;
		}
		else {
			carry = 0;
		}
		temp = val + temp;
	}
	if (carry != 0) {
		temp = "1" + temp;
	}
	while (temp[0] == '0' && temp.length() != 1) {
		temp = temp.substr(1);
	}
	return temp;
}

string fib_Accurate(long long n) { // ADDED
	string tmp = "";
	string fibMinus1 = "1";
	string fibMinus2 = "0";
	string comma = ", ";
	for (long long i = 2; i < n; i++) {
		tmp = add(fibMinus1, fibMinus2);
		fibMinus2 = fibMinus1;
		fibMinus1 = tmp;
	}
 return tmp;
}

 int fib(int n, int a = 0, int b = 1)
{
    if (n == 0)
        return a;
    if (n == 1)
        return b;
    return fib(n-1, b, a+b);
}

int main()
{
    cout<<"Enter the value :-";
    long long n; //Modified to accept larger values 
    cin>>n;
    cout << "fib(" << n << ") = " << fibAccurate(n) << '\n'; // endl flushes new line character is slightly faster, but more efficent in multiple uses.
    cout << "fib(" << n << ") = "<< fib((int)n) << endl; // Modified to send only int in.
    return 0;
}
