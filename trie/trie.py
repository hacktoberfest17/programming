import pickle

class Node:
	"""Creates a Node for the Trie"""
	def __init__(self):
		self.child=[None]*36
		self.isEnd = False

class Trie:

	def __init__(self):
		self.root = Node()

	def index(self,ch):
		"""Determines the index coressponding to a given starting character"""
		if ord(ch)>=97 and ord(ch)<=122:
			return ord(ch)-ord('a')
		else:
			return 25+ord(ch)-ord('0')

	def insert(self,ele):
		"""inserts an element ele in the Trie"""
		l = len(ele)
		curr = self.root
		for i in range(l):
			idx = self.index(ele[i])
			if not curr.child[idx]:
				curr.child[idx]=Node()

			curr = curr.child[idx]

		curr.isEnd = True

	def search(self,key):
		"""Looks for a particular element in trie i.e. returns True if Element found else return False"""
		curr = self.root
		l = len(key)
		for i in range(l):
			idx = self.index(key[i])
			if not curr.child[idx]:
				return False
			curr = curr.child[idx]

		return curr.isEnd and curr!=None

"""to save a Trie object in the file"""
def save_object(obj,filename):
	with open(filename,'wb') as output:
		pickle.dump(obj,output,pickle.HIGHEST_PROTOCOL)


if __name__=='__main__':
	trie=[]
	for k in range(0,36):
		t = Trie()
		trie.append(t)
	keys=['app','aff','aef']
	for term in keys:
		if ord(term[0])>=97 and ord(term[0])<=122:
			idx = ord(term[0])-ord('a')
			trie[idx].insert(term)
		else:
			idx=25+ord(term[0])-ord(0)
			trie[idx].insert(term)	
	
	print trie[0]
	save_object(trie[0],'/home/nikhil/wikipediasearch/a.pkl')	

