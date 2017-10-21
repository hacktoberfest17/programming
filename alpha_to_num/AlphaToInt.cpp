#include <iostream>
#include <string>
#include <ctype.h>

using namespace std;

int main()
{
	string strinput;
	getline(cin, strinput);
	int intinput;
	for (int i = 0; i < strinput.length(); i++){
		if (isalpha(strinput[i])){
			intinput = tolower(strinput[i]);
			intinput = intinput - 96;
			cout << intinput;
		}
		else{
			cout << strinput[i];
		}
	}

	return 0;
}
