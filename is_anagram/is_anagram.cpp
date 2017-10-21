#include <iostream>
#include <vector>
using namespace std;

bool is_anagram(string str1, string str2) {

	vector<int> count1(256, 0), count2(256, 0);

	if (str1.length() != str2.length())
		return false;

	for (int i = 0; i < str1.length(); i++) {
		++count1[str1[i]];
		++count2[str2[i]];
	}

	for (int i = 0; i < 256; i++)
		if (count1[i] != count2[i])
			return false;

	return true;
}

int main() {

	bool anagram = is_anagram("LISTEN", "SILENT");

	if (anagram)
		cout << "The strings are Anagram of each other" << endl;
	else
		cout << "The strings are not Anagram of each other" << endl;

	return 0;
}
