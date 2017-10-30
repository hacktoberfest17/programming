//============================================================================
// Name        : call_by_reference.cpp
// Author      : Anuj Pahade
// Version     :
//============================================================================

#include <iostream>
using namespace std;

// function declaration
template <class X>
void swap(X &n1, X &n2);

int main ()
{
   int num1 = 100;
   int num2 = 200;
   cout << "Value of number 1 before swap: " << num1 << endl;
   cout << "Value of number 2 before swap: " << num2 << endl;
   cout<<"\n";
   /* calls the swap function*/
   swap(num1, num2);
   cout << "Value of number 1 after swaping: " << num1 << endl;
   cout << "Value of number 2 after swapping: " << num2 << endl;

   return 0;
}
/*function definition*/
void swap(X &num1, X &num2)
{
   X temp;
   temp = num1; /* save the value at address num1 in another variable*/
   num1 = num2;
   num2 = temp;

   return;
}
