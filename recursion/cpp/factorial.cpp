#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
//factorial using recursive function
int factorial(int);

int main() {
    int number;
    cin>>number;
    cout<<factorial(number);
            return 0;
}
int factorial(int number){
    int temp;
    if(number<=1) return 1; 
    temp=number*factorial(number-1);
    return temp;
}

