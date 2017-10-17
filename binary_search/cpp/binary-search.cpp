#include<iostream>

using namespace std;

int binarysearch(int* a, int l, int r, int x)
{	
   	if (r >= l)
   	{
        int mid = l + (r - l)/2;
        if (a[mid] == x)  
        	return mid;
        if (a[mid] > x) 
        	return binarysearch(a, l, mid-1, x);
        else
        	return binarysearch(a, mid+1, r, x);
   }
   return -1;
}

int main(int argc, char const *argv[])
{
	//the array
	int a[8] = {1, 3, 9, 10, 11, 13, 20, 78};
	
	//elemnt to find
	int x = 3;

	int length = sizeof(a)/sizeof(int);

	cout<<"Position of "<<x<<" is "<<binarysearch(a, 0, length -1, x)+1<<endl;
	return 0;
}
