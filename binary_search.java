import java.util.*;
class binary_search
{

int search(int a[], int ub, int lb, int m)
{
int mid;

if(lb <= ub)
{
	mid = (ub+lb)/2;

	if(m > a[mid])
		return search(a, ub, mid+1, m);

	else if(m < a[mid])
		return search(a, mid-1, lb, m);

	else 
	{
		System.out.println("Element found at index "+mid);
		return mid;
	}
}

return -1;
}	
	
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
binary_search ob=new binary_search();

System.out.println("Enter the number of elements");
int n=sc.nextInt();
int a[]=new int[n];

System.out.println("Enter a sorted array");
for(int i=0; i<n; i++)
	a[i] = sc.nextInt();

System.out.println("Enter the search element");
int m=sc.nextInt();

int res = ob.search(a, n, 0, m);

if(res == -1)
	System.out.println("Element not found");
}
}