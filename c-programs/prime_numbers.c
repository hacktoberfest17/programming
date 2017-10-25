/*
	Prime numbers and Functions 
	@author - bhansa
	@creationdate - 9/7/2017

	Note : for positive integers
*/

#include <stdio.h>
void noobPrime(int num);

int main(){

	/*
		Condition for prime numbers -> numbers which are divisible either by 1 or themselves 
		Example :(1) 2 is only divisble by 1 or 2 itself.
				 (2) 13 is only divisible by 1 or 13 itself.

		Let's write some code :-)	
	*/

	int num;

	/* Lets create a function to check whether a number is a prime number or not.
	
		Use very basic understanding for condition of a prime number.
		Let's call it noobPrime()
	
		We will try to create three to four functions with different complexity.

		If you don't have any idea about creating functions :

			Visit (Have a quick read) :
				https://www.programiz.com/c-programming/c-functions 
				http://beginnersbook.com/2014/01/c-functions-examples/

			Normally a function looks like this :

				return_type function_name (argument list)
					{
					    Set of statements – Block of code
					} 

	 */

	scanf("%d", &num);

	//Lets call our prime check funstion 

	noobPrime(num);

}

void noobPrime(int num){

	//creating a flag variable
	int flag = 1, iterator;

	if(num <= 2){

		//ofcourse it is prime, coz 1 is prime and 2 is prime (but what about zero -> homework)

		flag = 1;

	}

	for(iterator = 2; iterator < num; iterator++){

		if(num%iterator == 0){
			flag = 0;
			break;
			// wait!! why break, how does it work ???
		}
	}

	// lets print the truth

	if(flag == 1){
		printf("num: %d is prime", num);
	}

	else
		printf("num:%d is not prime", num);

}