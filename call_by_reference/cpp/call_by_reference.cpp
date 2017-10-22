//============================================================================
// Name        : call_by_reference.cpp
// Author      : Anuj Pahade
// Version     :
//============================================================================

#include <iostream>
using namespace std;

// function declaration
void swap(int &n1, int &n2);

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
void swap(int &num1, int &num2)
{
   int temp;
   temp = num1; /* save the value at address num1 in another variable*/
   num1 = num2;
   num2 = temp;

   return;
}
