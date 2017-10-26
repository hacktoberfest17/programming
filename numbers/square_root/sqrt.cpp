#include <iostream>
#include <conio.h>

using namespace std;

int main() {

	float a1,a2,num,diff;
	
	cin >> num;
	
	a1=0;
	a2=num;
	
	do {
		
		float predRoot = (a1+a2)/2;
		float squared = predRoot * predRoot;
		diff = squared - num;

		if (diff > 0.000001 || diff < -0.000001) {		
			if (squared > num) {
				a2=predRoot;
			} else if (squared < num) {
				a1=predRoot;
			}
		} else {
			cout << predRoot;
		}

	} while (diff > 0.000001 || diff < -0.000001);
	
	return 0;
}
