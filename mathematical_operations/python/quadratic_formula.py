import re
i = raw_input()
q = re.split(r'[+-]', i)
a = int(q[0][:-2] or 1)
b = int(q[1][:-1] or 1)
if i[i.index(str(b)) - 1] == '-':
	b = -b
c = int(q[2])
if i[i.index(str(c)) - 1] == '-':
	c = -c
print 'a = {0}, b = {1}, c = {2}'.format(a, b, c);
if b ** 2 - (4 * a * c) < 0:
	print 'Unable to factor.'
else:
	x = (-b + ((b ** 2 - (4 * a * c)) ** 0.5)) / (2 * a)
	y = (-b - ((b ** 2 - (4 * a * c)) ** 0.5)) / (2 * a)
	print 'The solutions of the quadratic {0} are x = {1} and x = {2}'.format(i, x, y)
