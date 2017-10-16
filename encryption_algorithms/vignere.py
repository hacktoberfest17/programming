#!/usr/bin/python
# Uses Python2, need to edit print statements for python3 compatibility
# usage:
# python vigenere.py <-e,-d> <keyword> <message>

import sys

keyword = "A"
message = ["Hello","World"]
flag = 1

if(len(sys.argv) == 1):
	print("What do you want to do ?\n1) Encrypt \n2) Decrypt")
	i = input()
	if(i<=0 or i>2):
		print("Invalid option")
		exit()
	flag =i

	print("Enter Keyword: ")
	keyword = raw_input()
	if(keyword.isalpha()==False):
		print("Only alphabets allowed. No spaces.")
		exit()
	print("Enter message: ")
	message = raw_input().split(' ')
	for t in message:
		if(t.isalpha()==False):
			print("Only alphabets allowed in message.")
			exit()

elif (len(sys.argv) >= 3):
	trigger = sys.argv[1]
	if(trigger == "-e"):
		flag = 1
	elif(trigger == "-d"):
		flag = 2
	else:
		print("Invalid Flag.")
	keyword = sys.argv[2]
	message = sys.argv[3:]
	if(keyword.isalpha()==False):
		print("Usage: python vignere.py -e <KeyWord> <Message>.\nOnly alphabets allowed in Keyword.\n-e to encrypt, -d to decrypt")
		exit()
	for t in message:
		if(t.isalpha()==False):
			print("Usage: python vignere.py <KeyWord> <Message>.\nOnly alphabets allowed in message.\n-e to encrypt, -d to decrypt")
			exit()
else:
	print("Usage: python vignere.py <KeyWord> <Message>.\nOnly alphabets allowed in both keyword and message.\nNo spaces in the keyword allowed.\n-e to encrypt, -d to decrypt")

j = 0
def encrypt(key, mess):
	global j
	key = key.lower()
	res = ""
	mess = mess.lower()
	for i in range(0,len(mess)):
		shiftamt = ord(key[j]) - ord('a')
		x = ord(mess[i]) + shiftamt
		while (x > ord('z')):
			x -= (ord('z')-ord('a'))
		while (x < ord('a')):
			x += (ord('z')-ord('a'))
		res = res + chr(x)
		j = (j+1)%(len(key))
	return res

def decrypt(key, mess):
	global j
	key = key.lower()
	res = ""
	mess = mess.lower()
	for i in range(0,len(mess)):
		shiftamt = ord(key[j]) - ord('a')
		x = ord(mess[i]) - shiftamt
		while (x > ord('z')):
			x -= (ord('z')-ord('a'))
		while (x < ord('a')):
			x += (ord('z')-ord('a'))
		res = res + chr(x)
		j = (j+1)%(len(key))
	return res

if(flag == 1):
	for i in range(0,len(message)):
		print encrypt(keyword, message[i]),
elif(flag ==2):
	for i in range(0,len(message)):
		print decrypt(keyword, message[i]),




