import numpy as np
from sklearn import datasets

epochs = 2000
digits = datasets.load_breast_cancer()
X, y = digits.data, digits.target

b = len(X)
z = np.array([[1] * b]).T
X = np.concatenate([z, X], axis = 1)
c = len(X[0])
del(z)

w = np.array([np.random.random()]*c)

def relu_func(x):
	if x > 0:
		return 1
	else:
		return 0

def training(epochs=50):
	global w
	for r in range(epochs):
		for s, i in enumerate(X):
			z = np.sum(np.multiply(w, i))
			z = relu_func(z)
			w += (y[s] - z)*i
		
def accuracy_func():
	counter = 0
	for i in range(b):
		value = relu_func(np.sum(np.multiply(w, X[i])))
		if value == y[i]:
			counter += 1
		
	print("classification rate : " + str(counter/b))
	
training(epochs)
accuracy_func()
