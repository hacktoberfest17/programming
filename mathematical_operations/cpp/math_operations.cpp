#include<iostream>

using namespace std;

int main()
{
  int a,b;
  cout<<"Please enter first number  : ";
  cin>>a;
  cout<<"Please enter second number : ";
  cin>>b;

  int sum = a + b;
  int product = a * b;
  int difference = a - b;
  int quotient = a / b;
  int remainder = a % b;

  cout<<"The sum of the two number is         : "<<sum<<endl;
  cout<<"The product of the two number is     : "<<product<<endl;
  cout<<"The difference between two number is : "<<difference<<endl;
  cout<<"The quotient of the two number is    : "<<quotient<<endl;
  cout<<"The remainder of the two number is   : "<<remainder<<endl;

  return 0;
}
