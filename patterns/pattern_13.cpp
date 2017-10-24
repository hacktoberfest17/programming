#include<iostream>
using namespace std;
int main()
{
	int length, height;
	char ch;
	
	cout <<"\nEnter any character(Or special character) from keyboard to print the outline of rectangle: ";
	cin >>ch;
	
	cout <<"\n\nEnter Length: ";
	cin >>length;
	cout <<"Enter Height: ";
	cin >>height;
	
	cout <<endl;
	
	for(int i=1; i<=length; i++)
	{
		cout <<ch <<" ";
	}
	cout <<ch;
	cout <<endl;
	
	for(int j=1; j<=height; j++)
	{
		cout <<ch;
		for(int l=1; l<=((length*2)-1); l++)
		{
			cout <<" ";
		}
		cout <<ch;
		cout <<endl;
	}
	
	for(int i=1; i<=length+1; i++)
	{
		cout <<ch <<" ";
	}
	cout <<endl;
	return 0;
}