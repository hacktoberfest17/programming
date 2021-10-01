#include <iostream> 
using namespace std; 
class Distance { 
public: 
	int feet, inch; 
	Distance() { 
		feet = 0; 
		inch = 0; 
	} 
	Distance(int f, int i){ 
		feet = f; 
		inch = i; 
	} 
	Distance operator+(Distance d2) { 
		Distance d3; 
		d3.feet = feet + d2.feet; 
		d3.inch = inch + d2.inch; 
		return d3; 
	} 
}; 
int main() { 
	Distance d1(8, 9); 
	Distance d2(10, 2); 
	Distance d3; 
	d3 = d1 + d2;
	cout << "\nTotal Feet & Inches: " << d3.feet << "'" << d3.inch; 
	return 0; 
} 
