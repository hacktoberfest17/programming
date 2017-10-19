#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

vector<int> prime_factors(int num) {

	vector<int> factors;
	for (int i = 2; i <= sqrt(num); i++) {
		while (num % i == 0) {
			factors.push_back(i);
			num /= i;
		}
	}
	if (num > 2)
		factors.push_back(num);
	return factors;
}

int main() {

	vector<int> factors = prime_factors(156);
	for (int i = 0; i < factors.size(); i++)
		cout << factors[i] << " ";
	return 0;
}
