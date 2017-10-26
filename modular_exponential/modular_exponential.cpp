#include <iostream>
using namespace std;

int modular_exponential(long base, long power, int modulus) {

	if (base >= modulus)
		base %= modulus;

	int result = 1;

	while (power > 0) {
		if (power & 1)
			result = (result * base) % modulus;
		power = power >> 1;
		base = (base * base) % modulus;
	}
	return result;
}

int main() {

	cout << modular_exponential(24, 2015, 1000) << endl;
	return 0;
}
