// PascalTriangle.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

int fact(int x) {
	if (x < 2) {
		return 1;
	}
	else {
		return x * fact(x - 1);
	}
}

int choose(int n, int r) {
	return fact(n) / (fact(r)*fact(n - r)); //Choose function, nCr, ex. 5 cards "choose" 3 how many combos of cards can you pick? 5C3
}

int main() {
beginning:
	int row = 0;
	cout << "What row of Pascal's Triangle would you like to see?" << endl;
	cin >> row;
	if (row >= 13) {
		cout << "Too large!" << endl;
		goto beginning;
	}
	int row1 = 0;
	//from 0 to row, in each row go across
	while (row1 <= row) {
		if (row1 == 0) {
			cout << 1; //if they just put in 0 (the first row of Pascal's Tri., just print 1)
		}
		else {
			for (int i = 0; i < row + 1; i++) { 
				if (choose(row1, i) == 0) {
					cout << " "; //if nCr is 0, print a space
				}
				else {
					cout << choose(row1, i) << " "; //else, print nCr
				}

			}
		}

		cout << endl; //new line
		row1++; // next row
	}

	cout << endl;

	system("pause");

}