def shingles_from_document(k, doc):
	word = ""
	temp = ""
	shingles = set()
	word = doc.read(k)
	if not word:
		return
	while True:
		ch=doc.read(1)
		if not ch: break
		temp = word[1:] + ch
		word = temp
		shingles.add(word)
	return shingles

if __name__ == "__main__":
	f = open("file.txt", "r+")
	print(shingles_from_document(2, f))
