#include <iostream>
using namespace std;

bool is_prime(int n) {
	if (n == 2 || n == 3)
		return true;
	if (n % 2 == 0 || n % 3 == 0)
		return false;
	for (int i = 1; 36*i*i-12*i < n ; i++)
		if ((n % (6*i+1) == 0) || (n % (6*i-1) == 0)) 
			return false;
	return true;
}
