#include <iostream>
#include <cassert>
#include <vector>

long long ackermann(long long m, long long n) {
	// implemented as explicitly defined here https://en.wikipedia.org/wiki/Ackermann_function
	if (m == 0) return n + 1;
	if (m > 0 && n == 0) return ackermann(m-1, 1);
	if (m > 0 && n > 0) return ackermann(m-1, ackermann(m, n-1));
	assert(!"Invalid input");
}

bool test() {
	// Test values also got from Wikipedia.
	std::vector<std::vector<long long>> test_results = {
		{1, 2, 3, 4, 5},  		// A(0, 0) to A(0, 4)
		{2, 3, 4, 5, 6},  		// A(1, 0) to A(1, 4)
		{3, 5, 7, 9, 11},		// ...
		{5, 13, 29, 61, 125},	// ... to A(3, 4)
	};
	// Values for larger m and n are to large to be stored in type long long.
	for (int i = 0; i < 4; ++i) {
		for (int j = 0; j < 4; ++j) {
			std::cout << "A(" << i << ", " << j << ") = " << test_results[i][j];
			
			long long a = ackermann(i, j);

			if (a != test_results[i][j]) {
				std::cout << "\tTest failed. Expected " << test_results[i][j]
						  << ", got " << a << '.' << std::endl;
				return false;
			}
			std::cout << std::endl;
		}
	}
	return true;
}

int main() {
	if (test()) std::cout << "All tests passed. Function works as expected." << std::endl;

	return 0;
}