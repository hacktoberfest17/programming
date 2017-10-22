// MOD AUTHOR:  Taylor Hudson
// GITHUB    :  https://github.com/allencompsci
// DATE      :  October 20, 2017
// DESCRITION:  This C++ program implements the factorial operation in a space efficient, non-recursive manner and works beyond long double

#include<iostream.h>
#include<string>
#include<conio.h>

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
std::string sub(std::string a, std::string b) { // ADDED 
	std::string temp = "";
	while ((int)a.length() < (int)b.length()) {
		a = "0" + a;
	}
	while ((int)b.length() < (int)a.length()) {
		b = "0" + b;
	}
	int carry = 0;
	for (int i = a.length() - 1; i >= 0; i--) {
		char val = (char)(((a[i] - 48) - (b[i] - 48)) + 48 + carry);
		if (val < 48) {
			carry = -1;
			val += 10;
		}
		else {
			carry = 0;
		}
		temp = val + temp;
	}
	while (temp[0] == '0' && temp.length() != 1) {
		temp = temp.substr(1);
	}
	return temp;
}
std::string multi(std::string a, std::string b) { //ADDED
	std::string temp = a;
	if ((int)a.length() < (int)b.length()) {
		a = b;
		b = temp;

	}
	temp = a;
	while (b != "1") {
		temp = add(temp, a);
		b = sub(b, "1");
	}
	return temp;
}
std::string factorial_big(long double n) { // ADDED
	std::string term = std::to_string(n);
	std::string fact = "1";
	while (term != "0") {
		fact = multi(fact, term);
		term = sub(term, "1");
	}
	return fact;
}

void main()
{
	clrscr();
	long double n,fact=1,num;
	std::cout<<"\n\t Enter a number:"; // MODIFIED
	std::cin>>num; // MODIFIED
	n=num;
	while(num>0)
	{
		fact=fact*num;
		--num;
	}
	std::cout<<"\n\t factorial of "<<n<<" is:"<<fact; // MODIFIED
	std::cout << "\n\t factorial of " << n << " is:" << factorial_big(n) << std::endl; // ADDED
	
	getch();
}
