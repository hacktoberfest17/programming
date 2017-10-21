#include <iostream>
#include <iomanip>
using namespace std;

double square_root(double num) {

	double x = num;
	double y = 1;
	double e = 0.00000001;

	while (x - y > e) {
		x = (x + y) / 2;
		y = num / x;
	}
	return x;
}

int main() {

	cout << setprecision(10) << square_root(6);
	return 0;
}
