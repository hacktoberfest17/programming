import numpy
from numpy.linalg import norm
from spacy.gold import GoldParse
from spacy.language import EntityRecognizer
from spacy.en import English
parser = English()

apple = parser.vocab[u'apple']
def cosine(v1,v2):
    cos=numpy.dot(v1,v2)/(norm(v1)*norm(v2))
    return cos
others = list({w for w in parser.vocab if w.has_vector and w.orth_.islower() and w.lower_ != unicode("apple")})
# def vector_fun():
#     answer=cosine(w.vector,apple.vector)
#     return answer
others.sort(key=lambda w: cosine(w.vector, apple.vector))

others.reverse()


print "top most similar words to apple:"
for word in others[:10]:
    print word.orth_

king = parser.vocab[u'king']
man = parser.vocab[u'man']
woman = parser.vocab[u'woman']

result = king.vector - man.vector + woman.vector

allWords = list({w for w in parser.vocab if w.has_vector and w.orth_.islower() and w.lower_ != "king" and w.lower_ != "man" and w.lower_ != "woman"})
allWords.sort(key=lambda w: cosine(w.vector, result))
allWords.reverse()
print("\n----------------------------\nTop 3 closest results for king - man + woman:")
for word in allWords[:3]:
    print(word.orth_)
