#include<bits/stdc++.h>

using namespace std;

bool binary_search(int a[],int target,int low,int high)
{
	if(low>high)
	return false;
	int mid=low+(high-low)/2;
	if(a[mid]==target)
	return true;
	if(a[mid]>target)
	return binary_search(a,target,low,mid-1);
	else return binary_search(a,target,mid+1,high);
}

int main()
{
	int a[5]={2, 3, 4, 10, 40};				// the array must be sorted to apply binary search
	int n=5;
	int target=15;								//target element to be found
	bool present=binary_search(a,target,0,n-1);
	if(present)									// if element found print yes else no
	{
		cout<<"Yes, the element is present in the array\n";
	}
	else
	{
		cout<<"No, the element is not present in the array\n";
	}
	return 0;
}
