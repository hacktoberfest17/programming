// Code to check whether given string is palindrome

bool is_palindrome(string str) {

     for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
          if (str[i] != str[j])
               return false;
     }
     return true;
}
