//C++ tricks for competitive programming (for C++ 11)
#include<bits/stdc++.h>
using namespace std;
int main(){
int num=10,a,b;

//**************** Checking if the number is even or odd without using the % operator:
if (num & 1)
   cout << "ODD";
else
   cout << "EVEN";

//****************Fast Multiplication or Division by 2
num = num << 1;   // Multiply n with 2
num = num >> 1;   // Divide n by 2


// ****************Swapping of 2 numbers using XOR: 
// A quick way to swap a and b
a ^= b;
b ^= a;
a ^= b;

//****************Avoiding use of strlen():
//  Use of strlen() can be avoided by:
char s[10];
for (int i=0; s[i]; i++) 
{ 
}
// loop breaks when the character array ends.

//**************Calculating the number of digits directly
 num =floor(log10(num)) + 1;  


 //************** C++11 has in built algorithms for following:
int first[10];int n;
      // are all of the elements positive?
      all_of(first, first+n, ispositive()); 

      // is there at least one positive element?
      any_of(first, first+n, ispositive());

      // are none of the elements positive?
      none_of(first, first+n, ispositive());


  return 0;  
}