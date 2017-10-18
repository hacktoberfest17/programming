#include <iostream>
#include <cstdio>
using namespace std;

int phi(int n) {

	float total = n;

	for (int i = 2; i * i <= n; i++) {
		if (n % i == 0) {
			while (n % i == 0)
				n /= i;
			total *= (1.0 - (1.0 / (float)i));
		}
	}
	if (n > 1)
		total *= (1.0 - (1.0 / (float)n));
	return (int)total;
}

int main() {

	for (int i = 1; i <= 10; i++)
		printf("phi(%d) = %d\n", i, phi(i));
	return 0;
}
