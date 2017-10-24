from random import randint

s = raw_input().lower()

rps = ['rock', 'paper', 'scissors']
if s not in rps:
	print 'Invalid input. Choose from either rock, paper, or scissors.'
else:
	win = {
		'rock': 'scissors',
		'scissors': 'paper',
		'paper': 'rock'
	}
	r = rps[randint(0, 2)]
	print 'I chose {}!'.format(r)
	if r == s:
		print 'Tie.'
	if win[r] == s:
		print 'I win.'
	else:
		print 'I lose.'
