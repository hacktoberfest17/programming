st = input()
st = st.lower()
m = [0]*26
for i in range(0,len(st)):
	if st[i]!= ' ':
		pos = (ord(st[i])-97)
		m[pos] = m[pos]+1
for i in range(0,26):
	if m[i]>1:
		print(chr(i+97)+ " ---> " + str(m[i]))	
