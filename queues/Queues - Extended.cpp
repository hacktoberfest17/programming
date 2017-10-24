//Queues are extended as queue get automatically cleaned after each and every deletion by putting '0' into deleted values
#include <iostream>
using namespace std;

int queue[5]={0,0,0,0,0};
int front=-1,rear=-1,count=0,check;
char opt1,opt2;

int main()
{
	cout<<"Enter Value For Queue :";
	cin>>queue[++rear];
	count++;
	front=rear;
	/* we have to put the insertion code here too because if we don't we can't give the value '0' to front . if we put the line front=rear in
	the loop if will always equalize the value of front to rear, so at last front and rear both will be 4 - so the deletion code will not work
	as it is only going in if front<rear (The condition is if (front>rear) break and output that queue is underflow) */
	do //For Insertion
	{
		if (rear>=4) //this can't put as "rear>4" because the value of rear is incremented by 1 in the body of the loop. So it is already increased
		{
			cout<<"Queue Overflown"<<endl;
			break;
		}
		cout<<"Enter Value For Queue :";
		cin>>queue[++rear];
		count++;
		cout<<"Do You Want To Insert More Values? (Y/N)";
		cin>>opt1;
		
		
	}while (opt1=='y');
	
	for (int x=0;x<5;x++) //For Display the Queue after Insertion is end
	{
		cout<<queue[x]<<endl;
	}
	//Extended Version Begins From Here
	
	/*cout<<"Do You Want To Delete a/the element(s) of Queue? ";
	cin>>opt2;
	while (opt2=='y')
	{
		if (front>rear)
		{
			cout<<"Queue is Underflown"<<endl;
			break;
		}
		cout<<queue[front++]<<endl;
		count--;
		cout<<"Do you want to delete more elements? ";
		cin>>opt2;
	}*/

	cout<<"Do You Want To Delete a/the element(s) of Queue? (Y/N)";
	cin>>opt2;
	while (opt2=='y')
	{
		if (front>rear)
		{
			cout<<"Queue is Underflown"<<endl;
			break;
		}
		cout<<queue[front]<<endl;
		queue[front]=0;
		front++;
		count--;
		cout<<"Do you want to delete more elements? (Y/N)";
		cin>>opt2;
	}

	for (int x=0;x<5;x++) //For Display the Queue after Deletion is end
	{
		cout<<queue[x]<<endl;
	}
	//check codes after this. Does'nt work at the moment :-(
	for (int y=0;y<5;y++)
	{
		if (queue[y]==0)
		{
			check=0;
			front--;
		}
	}
	if (check=0)
	{
		cout<<"Queue is empty"<<endl;
	
    }
	
}
