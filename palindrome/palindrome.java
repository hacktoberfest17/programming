
// assumes only alphanumerical characters in str (no white space, no punctuation)
boolean isPalindrome(String str) {

	int i = 0;
	int j = str.length() - 1;

	if(str.length() == 0) {
		return false;
	}

	while(i <= j) { 
		if(str.charAt(i) != str.charAt(j)) {
			return false;
		}
		i++;
		j--;
	}

	return true;
}