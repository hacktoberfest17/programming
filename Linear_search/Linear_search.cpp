#include<iostream>
using namespace std;
int main()
{	int n,i;
	cout<<"Enter the size of array - ";
	cin>>n;
	int arr[n];
	cout<<"\nEnter the array elements \n";
	for(i=0;i<n;i++)
	    	cin>>arr[i];

	int item;
	cout<<"\nEnter the element you are searching for - ";
	cin>>item;

	int loc=-1;
	for(i=0;i<n;i++)
	{	if(arr[i]==item)
			{	loc=i;
				break;
			}
	}
	if(loc==-1)
	cout<<"\nElement not found";
	else
		cout<<"\nElement found at position - "<<loc+1;

		cout<<" "<<endl;
	return 0;
}
