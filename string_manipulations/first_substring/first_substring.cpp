/*
// Finding the index of the first occurrence of a given substring.
// Return -1 when not found
// input string = "the quick brown fox jumps over the lazy dog"
// input substring = "fox"
// output = 16
*/

//#include "<bits/stdc++.h>"
#include <string>
#include <iostream>
using namespace std;

int position_substring(string str, string substr)
{
	int pos=-1;
	int i, j;

	if (str.length() <=0 || substr.length() <=0)
		return -1;
	if (substr.length() > str.length())
		return -1;

	for (i=0; i<str.length(); i++) {
		pos = i;
		for (j=0; j<substr.length(); j++) {
			if (toupper(str[pos+j]) == toupper(substr[j])) {
				continue;
			}
			else {
				pos = -1;
				break;
			}
		}
		if (j == substr.length()) {
			return pos;
		}
	}
	return -1;
}

int main()
{
	string str = "the quick brown fox jumps over the lazy dog";
	string substr = "FOX";

	cout << position_substring(str, substr);
	cout << "\n";
	return 0;
}
