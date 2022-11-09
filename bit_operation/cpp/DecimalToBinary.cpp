//converts any decimal number into its binary representation
#include <iostream>
using namespace std;

void binary(int num)
{
    int rem;
    if (num<=1)
    {
        cout<<num;
        return;
    }
    rem = num % 2;
    binary(num / 2);
    cout << rem;
}

int main() {
	int n;
	cin>>n;
	cout<<"binary representation of n: ";
	binary(n);
	return 0;
}