#include <iostream>
using namespace std;

long long ncr(long n, long r) {

	if (r > n || n < 0 || r < 0)
		return -1;

	if (r > n / 2)
		r = n - r;
	long long ans = 1;
	for (int i = 1; i <= r; i++) {
		ans *= n - r + i;
		ans /= i;
	}
	return ans;
}

int main() {

	int combination = ncr(15, 5);
	if (combination > 0)
		cout << combination;
	else
		cout << "Invalid Input";
	return 0;
}
