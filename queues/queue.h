#include <exception>
#include <iostream>
using namespace std;
//defining the exception
//reference : https://stackoverflow.com/questions/16182781/how-to-create-exceptions

class EmptyQueueException: public exception
{
public:
  const char* what() const throw()
  {
    return "EmptyQueueException\n";
  }
};
EmptyQueueException eq;


//declaring the template class 
template <class Q> class queue  //template <class obj_type> class class_name
{
private:
	int max_size;
	Q* q_arr; //array based implementation
	int front_index; 
	int rear_index;
public:
	queue() //constructor 
	{
		max_size = 100000;
		q_arr = new Q[max_size];
		front_index = 0;
		rear_index = -1;
	}

	//declaring the functions 
	int size();
	bool isEmpty();
	void enqueue(Q value);
	Q front() throw(EmptyQueueException);
	Q dequeue() throw(EmptyQueueException);
};


//function definitions : return_type class_name :: function_name(arguments)
template <class Q> int queue<Q>::size()
{
	return rear_index - front_index + 1; // adding one since initially rear index is -1. 
}
template <class Q> bool queue<Q>::isEmpty()
{
	if(rear_index==-1)
		return 1;
	return 0;	
}
template <class Q> void queue<Q>::enqueue(Q val) 
{
	int pres_size = size();
	if(pres_size>=max_size)
	{
		cout<<"The queue is full."<<endl;
		return ;
	}	
	else if(rear_index == max_size - 1) /*case when rear reaches last index and still queue not empty
										  so we shift all elements to the beginning of array */
	{
		int k;
		for(k=0;k<pres_size;k++)
		{
			q_arr[k] = q_arr[front_index];
			front_index++;
		}	
		front_index = 0;
		rear_index = --k; 
		//just for checking purpose ; cout<<front_index<<" "<<rear_index<<endl;
	}
	//first increment the rear index and then at that index put the value in the array 
	rear_index++; 
	q_arr[rear_index]=val;
	return ;
}
template <class Q> Q queue<Q>::front() throw(EmptyQueueException) //also throws EmptyQueueException
{
	if(rear_index==-1)
		throw eq;
	return q_arr[front_index];
}
template <class Q> Q queue<Q>::dequeue() throw(EmptyQueueException) //also throws EmptyQueueException
{
	int indx=front_index; /*store the front index since this has to be changed so we won't be able to return actual one,
							front index changes according to whether queue has one element or many*/
	if(rear_index==-1) //if queue is already empty throw the exception so that dequeue fn is terminated 
		throw eq;
	else if(front_index == rear_index) //if queue only has one element then after deleting it, rear becomes -1
	{
		rear_index = -1;
		front_index = -1;	/*	it is not set 0 initially as it anyway has to be incremented even if queue had more than
							  	one element */
	}
	front_index++ ; //if queue had 1 or more elements we increment the front index 
	return q_arr[indx]; 
}