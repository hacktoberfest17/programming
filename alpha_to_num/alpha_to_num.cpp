#include <iostream>
#include <string>
#include <ctype.h>

using namespace std;

// A simple method to convert chars to their integer alphabetical order
int alpha_to_num(char c){
	if( c >= 'a' && c <= 'z')
		return c - 'a';
	if( c >= 'A' && c <= 'Z')
		return c - 'A';

	return -1;
}


int main()
{
	string strinput;
	getline(cin, strinput);
	int intinput;
	for (int i = 0; i < strinput.length(); i++){
		auto res = alpha_to_int(strinput[i]);
		if(res != -1){
			cout << res << "\n";
		}
	}

	return 0;
}
