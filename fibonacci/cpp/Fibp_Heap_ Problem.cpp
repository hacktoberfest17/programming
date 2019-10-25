/* PROBLEM STATEMENT
a. Write a function with the following prototype to print the k smallest elements stored
in a ternary min-heap H: void ksmallest (int H[], int n, int k); The function should
print the elements in sorted (increasing) order, and have a running time of O(k log n),
where n is the number of elements stored in H. A heap is allowed to store the same
value at multiple nodes. Your function should print only k values including
repetitions. After the function returns, the heap should continue to contain all of its n
elements

b. Write a function with the following prototype to print all elements less than equal to a
in a ternary min-heap H: void printsmall (int H[], int n, int a); Printing need not be
in a sorted order. If some element less than equal to a appears multiple times in H,
print it as many times as it occurs. Your function must run in O(t) time, where t is the
number of elements printed. The heap should continue to contain all of its n elements
after the function returns.

Your main should do the following:
a) Read the size n of the heap
b) Read n positive integers and store them in an array H[ ].
c) Run buildheap() to convert the array to a ternary min-heap. Print the array H[ ].
d) Read k from the user. Call the function ksmallest to print the k smallest elements
in your heap.
e) Read a. Invoke the function printsmall to print all heap elements less than or
equal to a

Input: First line containing a number n,size of heap
Second line containing n positive integers.
Third line containing a single integer k.
Fourth line containing a single integer a.

Output: First line containing heap elements after buildheap()
 Second line containing k smallest integers in sorted order of the heap
 Third line containing all heap elements less than or equal to k

Input:
80
23 6 57 35 33 15 26 12 9 61 42 27 50 59 3 6 60 66 52 56 11 8 7 29 22 10 62 3 67 15 9 42
22 18 29 7 33 56 51 42 69 13 21 39 24 57 78 4 75 50 13 6 11 20 36 33 62 50 36 1 65 45
44 7 16 25 46 49 33 17 44 55 62 65 14 7 74 44 43 70
10
20
Output:
1 3 3 7 4 6 6 7 9 9 18 27 42 13 24 6 13 11 33 26 7 8 12 29 7 10 62 57 67 15 61 42 22 42
29 35 33 56 51 50 69 59 21 39 33 57 78 23 75 50 15 60 66 20 36 52 62 50 36 56 65 45 44
11 16 25 46 49 33 17 44 55 62 65 14 22 74 44 43 70
1 3 3 4 6 6 6 7 7 7
[Print H here to ensure H is not modified by the above operation]
1 3 3 4 6 6 6 7 7 7 7 8 9 9 10 11 11 12 13 13 14 15 15 16 17 18 20
[Print H here to ensure H is not modified by the above operation]
*/

#include<bits/stdc++.h>
using namespace std ;

void min_heapify(int *arr , int i , int n)
{
	int min = i;
	int l = arr[3*i-1];
	int m = arr[3*i];
	int r = arr[3*i+1];
	
	if( n == 3*i-1)
	{
		if( l < arr[i] )
			min = 3*i-1;
	}

	if( n == 3*i)
	{
		if(m <= l && m < arr[i])
			min = 3*i;
		else if(l <= m && l < arr[i])
			min = 3*i-1;;
	}

	if( n < 3*i - 1)
		return;	

	if(n > 3*i)
	{
		if(r <= l && r <= m && r < arr[i])
			min = 3*i+1;
		else if(l <= r && l <= m && l < arr[i])
			min = 3*i-1;
		else if(m <= l && m <= r && m < arr[i] )
			min = 3*i;
	}
	
	if( min != i )
	{
		swap( arr[min] , arr[i]);
		min_heapify( arr , min , n);
	}

}

void min_heapify2(int *arr , int *arr1 ,int i , int n)
{
	int min = i;
	int l = arr[arr1[3*i-1]];
	int m = arr[arr1[3*i]];
	int r = arr[arr1[3*i+1]];
	
	if( n == 3*i-1)
	{
		if( l < arr[i] )
			min = 3*i-1;
	}

	if( n == 3*i)
	{
		if(m <= l && m < arr[arr1[i]])
			min = 3*i;
		else if(l <= m && l < arr[arr1[i]])
			min = 3*i-1;;
	}

	if( n < 3*i - 1)
		return;	

	if(n > 3*i)
	{
		if(r <= l && r <= m && r < arr[arr1[i]])
			min = 3*i+1;
		else if(l <= r && l <= m && l < arr[arr1[i]])
			min = 3*i-1;
		else if(m <= l && m <= r && m < arr[arr1[i]])
			min = 3*i;
	}
	
	if( min != i )
	{
		swap( arr1[min] , arr1[i]);
		min_heapify2( arr , arr1 , min , n);
	}

}
void build_min_heap(int *arr , int n)
{
	for (int i = (n+1)/3; i >0; i--)
	{
		min_heapify(arr,i,n);
	}

}

int insert(int *arr1 , int *arr , int n , int index )
{
	arr1[n+1] = index; 

	for(int i = n+1 ; i != 1; i=(i+1)/3 )
		if(arr[arr1[i]] < arr[arr1[(i+1)/3]])
			swap(arr1[i] , arr1[(i+1)/3]);
	/*for (int i = 1; i <= n+1; ++i)
	{
		cout<<arr1[i]<<" ";
	}
	cout<<endl;*/
	return n+1 ;

}

int remove(int *arr , int *arr1 , int n )
{
	arr1[1] = arr1[n];
	min_heapify2( arr , arr1 , 1 , n-1);
	
	return n-1;
}

void ksmallest(int *arr , int size, int k , int n)
{
	int arr1[1000];
	
	int i = 1 , j = 1;

	arr1[1] = 1;

	

	while( j <= k)
	{
		int l = 3*i-1 , m = 3*i , r = 3*i+1;

		cout<<arr[arr1[1]]<<" ";
		size = remove( arr , arr1 , size);
		
		j++;
		
		if(l <= n)
			size = insert(arr1 , arr ,size , l);
		if(m <= n)
			size = insert(arr1 , arr ,size , m);
		if(r <= n)
			size = insert(arr1 , arr , size , r);

		i = arr1[1];


	}
}

void printsmall(int *arr , int n , int a , int i)
{
	if( i <= n && arr[i] <= a ){
		cout<<arr[i]<<" ";
		printsmall(arr , n , a , 3*i-1);
		printsmall(arr , n , a , 3*i);
		printsmall(arr , n , a , 3*i+1);
	}



}
int main(){
	int n;			
	cin>>n;

	int arr[100];

	for (int i = 1; i <= n; ++i)
	{
		cin>>arr[i];
	}

	build_min_heap(arr , n);
	
	for (int i = 1; i <= n; ++i)
	{
		cout<<arr[i]<<" ";
	}
	cout<<endl;
	
	int k;
	cin>>k;
	int size = 1;

	ksmallest(arr , size , k , n);
	cout<<endl;
	
	int a;
	cin>>a;

	printsmall(arr , n , a ,1 );
	cout<<endl;
	return 0;
}