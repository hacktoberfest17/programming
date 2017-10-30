#include <iostream>
#include <exception>
#include "queue.h"
using namespace std;

int main()
{
	//replace the int by the type of elements to be inserted into the queue 
	queue <int> a;
	cout<<"Please choose from the following: "<<endl;
	cout<<"1. Enqueue"<<endl;
	cout<<"2. Dequeue"<<endl;
	cout<<"3. Check whether the queue is empty"<<endl;
	cout<<"4. Check the size of queue"<<endl;
	cout<<"5. Show the front element of the queue"<<endl;
	int opt; //variable to be used for switch case statement 
	cin>>opt;
	home: //defining a label for using goto statement 
	switch(opt)
	{
		case 1: cout<<"Enter the element to enqueue : ";
				int x;
				cin>>x;
				a.enqueue(x);
				break;
		case 2: cout<<"You are about to delete an element from queue. Enter y/Y to confirm : ";
				char ch;		
				cin>>ch;
				if(ch=='y'||ch=='Y')
				{
					//use try catch block since dequeue() can return an exception 
					try
					{
						int x = a.dequeue();
						cout<<x<<" is deleted from the queue."<<endl;
					}
					catch(EmptyQueueException e)
					{
						cout<<e.what(); //this function prints the exception message 
					}
				}	
				break;
		case 3: if(a.isEmpty()==1)
					cout<<"Yes, the queue is empty!"<<endl;
				else
					cout<<"No, the queue is not empty."<<endl;
				break;
		case 4: cout<<"The size of the queue is : "<<a.size()<<endl;
				break;
		case 5: 
				//use try catch block since front() can return an exception 
				try
				{
					cout<<"The front element in the queue is : "<<a.front()<<endl;
				}
				catch(EmptyQueueException e)
				{
					cout<<e.what();
				}
				break;
	}
	cout<<"Enter 0 to return to main menu/any other number to exit."<<endl;
	cin>>opt;
	if(opt==0)
	{
		cout<<"Choose the required option(1-Enq,2-Deq,3-isEmpty,4-Size,5-Front) : ";
		cin>>opt;
		goto home;
	}
	return 0;
}

