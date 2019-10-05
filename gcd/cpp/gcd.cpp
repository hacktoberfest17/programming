#include <bits/stdc++.h>
using namespace std;
// Iterative gcd function
int gcd(int m, int n)
{
    return __gcd(m,n);
}


int main()
{
    int m = 0;
    int n = 0;

    std::cout << "Please enter a number\n";
    std::cin >> m;

    std::cout << "Please enter another number\n";
    std::cin >> n;
    
    std::cout << "GCD of m and n: " << gcd(m, n) << '\n';

    return 0;
}
