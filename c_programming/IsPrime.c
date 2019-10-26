// C program to check if a 
// number is prime 

#include <stdio.h> 

int main() 
{ 
	int n, i, flag = 1; 

	// Ask user for input 
	printf("Enter a number: \n"); 

	// Store input number in a variable 
	scanf("%d", &n); 

	// Iterate from 2 to n/2 
	for (i = 2; i <= sqrt(n) / 2; i++) { 

		// If n is divisible by any number between 
		// 2 and n/2, it is not prime 
		if (n % i == 0) { 
			flag = 0; 
			break; 
		} 
	} 

	if (flag == 1) { 
		printf("%d is a prime number", n); 
	} 
	else { 
		printf("%d is not a prime number", n); 
	} 

	return 0; 
} 
