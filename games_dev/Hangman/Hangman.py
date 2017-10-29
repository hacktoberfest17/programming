from random import randrange


# the code below is for using random words chosen from a text file
'''
# open text file with a bunch of words and save them to a list
fr = open('words.txt', 'r') 
words = fr.readlines()
# remove \n from each string
words = [x.replace('\n', '') for x in words]
fr.close()
'''
'''
# get a random word
random_index = randrange(0,len(words))
random_word = words[random_index]
'''

# use RandomWords library to generate a random word
from random_words import RandomWords
rw = RandomWords()
random_word = rw.random_word()

print('I have chosen a word. You are allowed six wrong guesses.')
wrong_guesses = 0
empty_word = []

# print _ to denote the length of the word
for x in range(len(random_word)):
	empty_word.append('_') # save _ to a new string that matches the length of the word. append is used because string is initially empty

print(" ".join(empty_word))

		
while (wrong_guesses < 6):
	guess = input('Guess a letter: ')
	if guess in random_word:
		for i in range(len(random_word)):
			if random_word[i] is guess:
				empty_word[i] = random_word[i]
	if '_' not in empty_word:
		print(" ".join(empty_word))
		print('YOU SOLVED IT!')
		break
	print(" ".join(empty_word))
	if guess not in random_word:
		wrong_guesses += 1
		print('WRONG GUESSES: ', wrong_guesses)
		print(" ".join(empty_word))

if wrong_guesses is 6:
	print('SORRY, THE WORD WAS: ', random_word)
		
	

