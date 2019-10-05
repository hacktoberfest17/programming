#include <iostream>

using std::cin;
using std::cout;
using std::endl;

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main() {
    int n1, n2;

    cout << "Give first number- ";
    cin >> n1;
    cout << "Give second number- ";
    cin >> n2;

    cout << "Greatest Common Divisor: " << gcd(abs(n1), abs(n2)) << endl;
}
