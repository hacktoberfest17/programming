#include<iostream>
using namespace std;

void swap1(int *a,int *b)
{
	int temp;
	temp=*a;
	*a=*b;
	*b=temp;

}
void bubble_sort(int arr[],int n)
{
	//run for n-2 iteration.
	for(int itr=0;itr<n-1;itr++)
	{
	for(int j=0;j<n-itr-1;j++)
	{
		if(arr[j+1]<arr[j])
		{
			swap1(&arr[j+1],&arr[j]);
		}
	}
	}
}
int main()
{
	int n;
	cin>>n;
	int arr[n];
	for(int i=0;i<n;i++)
	{
		cin>>arr[i];
	}

	bubble_sort(arr,n);

    for(int i=0;i<n;i++)
	{
		cout<<arr[i]<<" ";
	}
}
