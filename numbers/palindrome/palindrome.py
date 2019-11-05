def main():
    print("This palindrome finder can detect if a word is a palindrome OR if a series of letters in any order could make a palindrome!")
    word = input("Enter your word: ")
    letterList = []
    for character in word:
        if (character in letterList):
            letterList.remove(character)
        else:
            letterList.append(character)
    if len(letterList) <= 1:
        print(word + " is a palindrome!")
    else:
        print(word + " is not a palindrome!")

main()