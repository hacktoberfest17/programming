// Code to check whether given string is palindrome
// Additional checks for numbers. 
bool is_palindrome(string str) {

     for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
          if (str[i] != str[j])
               return false;
     }
     return true;
}
bool is_palindrome(int n){
     return is_palindrome(to_string(n));    
}
bool is_palindrome(long n){
     return is_palindrome(to_string(n));    
}
