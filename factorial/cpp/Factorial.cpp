#include<iostream.h>
#include<conio.h>
void main()
{
	clrscr();
	long double n,fact=1,num;
	cout<<"\n\t Enter a number:";
	cin>>num;
	n=num;
	while(num>0)
	{
		fact=fact*num;
		--num;
	}
	cout<<"\n\t factorial of "<<n<<" is:"<<fact;
	getch();
}
