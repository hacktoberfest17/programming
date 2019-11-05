// MOD AUTHOR:  Taylor Hudson
// GITHUB    :  https://github.com/allencompsci
// DATE      :  October 19, 2017
// DESCRITION:  This C++ program implements the fibonacci term operation in a space efficient, non-recursive manner and works beyond long long


#include <iostream>
#include <string>
/* Function declaration */
int getNthValue(int n);
std::string add(std::string, std::string);
std::string fib_Accurate(long long);
/* Program starts here */
int main()
{
    long long nth; // the Nth number EDITED TO TAKE LARGE TERMS
    std::cout << "Enter the number of term to be printed: " << std::endl;

    std::cin >> nth;
    std::cout << getNthValue((int)nth) << std::endl; // EDITED TO IMPOSE DATA TYPE RESTRICTION
    std::cout << fib_Accurate(nth) << '\n'; // ADDED THE CALL
    
}

/* Function definition */
int getNthValue(int n)
{
    /* Initial values */
    int a = 1;
    int b = 0;
    int c;
    
    /* Calculate the sequence untill the Nth number */
    for (int i = 0; i <n; i++)
    {
        c = a + b;        
        a = b;
        b = c;
    }
    return c; // return the desired number 
}
std::string add(std::string a, std::string b) { // ADDED 
	std::string temp = "";
	while ((int)a.length() < (int)b.length()) {
		a = "0" + a;
	}
	while ((int)b.length() < (int)a.length()) {
		b = "0" + b;
	}
	int carry = 0;
	for (int i = a.length() - 1; i >= 0; i--) {
		char val = (char)(((a[i] - 48) + (b[i] - 48)) + 48 + carry);
		if (val > 57) {
			carry = 1;
			val -= 10;
		}
		else {
			carry = 0;
		}
		temp = val + temp;
	}
	if (carry != 0) {
		temp = "1" + temp;
	}
	while (temp[0] == '0' && temp.length() != 1) {
		temp = temp.substr(1);
	}
	return temp;
}
std::string fib_Accurate(long long n) { // ADDED	
    std::string tmp = "";
	std::string fibMinus1 = "1";
	std::string fibMinus2 = "0";
	for (long long i = 2; i < n; i++) {
		tmp = add(fibMinus1, fibMinus2);
		fibMinus2 = fibMinus1;
		fibMinus1 = tmp;
	}
    return tmp;
}
