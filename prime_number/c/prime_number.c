#include <stdio.h>
#include <stdlib.h>
#include <math.h>

bool prime(long long n) {
	if (n < 2) return false;
	if (n == 2) return true;
	if (n % 2 == 0) return false;
	for (int i = 3; i <= sqrt(n); ++i)	{
		if (n % i == 0) return false;
	}
	return true;
}

int main(int argc, char const *argv[]) {
	long long n;
	bool aux;
	scanf("%lld", &n);
	aux = prime(n);
	if (aux == true) {
		printf("it's prime!\n");
	}
	else
		printf("it's not prime!\n");
	return 0;
}
