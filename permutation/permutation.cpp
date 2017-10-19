#include <iostream>
using namespace std;

long long npr(long n, long r) {
	
	long long ans = 1;
	if (r > n || n < 0 || r < 0)
		return -1;
	for (int i = n; i > n - r; i--)
		ans *= i;
	return ans;
}

int main() {

	cout << npr(15, 5);
	return 0;
}
