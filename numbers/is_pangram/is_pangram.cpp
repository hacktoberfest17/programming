#include <iostream>
#include <vector>
using namespace std;

bool is_pangram(string str) {

	vector<bool> pangram(26, false);

	for (int i = 0; i < str.length(); i++) {
		if (str[i] >= 'A' && str[i] <= 'Z')
			pangram[str[i] - 'A'] = true;
		if (str[i] >= 'a' && str[i] <= 'z')
			pangram[str[i] - 'a'] = true;
	}

	for (int i = 0; i < 26; i++)
		if (!pangram[i])
			return false;

	return true;
}

int main() {

	bool pangram = is_pangram("The quick brown fox jumps over the lazy dog");
	if (pangram)
		cout << "Given string is a pangram" << endl;
	else
		cout << "Given string is not a pangram" << endl;

	return 0;
}
