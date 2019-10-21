// CPP program to check twin prime 
#include <iostream> 
using namespace std; 

// Please refer below post for details of this 
// function 
// https://goo.gl/Wv3fGv 
bool isPrime(int n) 
{ 
	// Corner cases 
	if (n <= 1) return false; 
	if (n <= 3) return true; 

	// This is checked so that we can skip 
	// middle five numbers in below loop 
	if (n%2 == 0 || n%3 == 0) return false; 

	for (int i=5; i*i<=n; i=i+6) 
		if (n%i == 0 || n%(i+2) == 0) 
		return false; 

	return true; 
} 

// Returns true if n1 and n2 are twin primes 
bool twinPrime(int n1, int n2) 
{ 
	return (isPrime(n1) && isPrime(n2) && 
						abs(n1 - n2) == 2); 
} 

// Driver code 
int main() 
{ 
	int n1 = 11, n2 = 13; 
	if (twinPrime(n1, n2)) 
		cout << "Twin Prime" << endl; 
	else
		cout << endl 
			<< "Not Twin Prime" << endl; 
	return 0; 
} 
