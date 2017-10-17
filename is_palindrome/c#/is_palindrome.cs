public class is_palindrome
{
	public bool isPalindrome(string str)
	{
		for (int i = 0, j = str.Length - 1; i < str.Length / 2; i++, j--)
		{
			if (str[i] != str[j])
				return false;
		}
		return true;
	}
}
