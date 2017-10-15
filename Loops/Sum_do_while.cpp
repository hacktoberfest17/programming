// C++ program to add numbers until user enter 0
//Using do while loop
#include <iostream>
using namespace std;
//Driver program
int main() 
{
    float number, sum = 0.0;
    
    do {
        cout<<"Enter a number: ";
        cin>>number;
        sum += number;
    }
    while(number != 0.0);

    cout<<"Total sum = "<<sum;
    
    return 0;
}
