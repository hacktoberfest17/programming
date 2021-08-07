#include<iostream>
using namespace std;


long long fib(int n, long long* a) {
    if (n <= 0) {
        return 0; 
    }
    else if (n == 1) {
        return 1;
    }

    if (a[n] != 0) {
        return a[n];
    }
    
    long long ans = fib(n - 1, a) + fib(n - 2, a);
    a[n] = ans;
    return ans;
}


int main() {
    
    int n;
    long long a[100006] = {0};
    cin>>n;
    cout<<fib(n, a)<<endl;

    return 0;
}
