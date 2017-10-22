def is_pangram(string):

	pangram = [False] * 26

	for i in range(len(string)):
		if string[i] >= 'A' and string[i] <= 'Z':
			pangram[ord(string[i]) - ord('A')] = True
		if string[i] >= 'a' and string[i] <= 'z':
			pangram[ord(string[i]) - ord('a')] = True

	for i in pangram:
		if not i:
			return False

	return True

def main():
	pangram = is_pangram('The quick brown fox jumps over the lazy dog')

	if pangram:
		print('Given string is a pangram')
	else:
		print('Given string is not a pangram')

if __name__ == '__main__':
	main()
