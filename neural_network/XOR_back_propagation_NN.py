#Libraries
import numpy as np

# transfer functions
def sgm(x, Derivative=False):
	if not Derivative:
		return 1.0 / (1.0+np.exp(-x))
	else:
		out = sgm(x)
		return out * (1.0-out) 

def linear(x, Derivative=False):
	if not Derivative:
		return x
	else:
		return 1.0

def gaussian(x, Derivative=False):
	if not Derivative:
		return np.exp(-x**2)
	else:
		return -2 * x * np.exp(-x**2)

def tanh(x, Derivative=False):
	if not Derivative:
		return np.tanh(x)
	else:
		return 1.0 - np.tanh(x)**2

# Class
class BackPropagationNetwork:
	layerCount = 0
	shape = None			# tuple
	weights = []
	tFuncs = []

	def __init__(self, layerSize, layerFunctions = None):	# layerSize -> tuple
		#Initialise network

		#Layer info
		self.layerCount = len(layerSize)-1		# - 1 because no. of layers will be 1 less than the layerSize
		self.shape = layerSize

		if layerFunctions is None:
			lFuncs = []
			for i in range(self.layerCount):
				if i == self.layerCount - 1:
					lFuncs.append(linear)
				else:
					lFuncs.append(sgm)
		else:
			if len(layerFunctions) != len(layerSize):
				raise ValueError("Incompatible list of transfer functions.")
			elif layerFunctions[0] is not None:
				raise ValueError("Input layer cannot have transfer function.")
			else:
				lFuncs = layerFunctions[1:]

		self.tFuncs = lFuncs


		# Input/Output data from the last run
		self._layerInput = []
		self._layerOutput = []
		self._previousWeightDelta = []

		# Create weight arrays
		for (l1,l2) in zip(layerSize[:-1],layerSize[1:]):
			self.weights.append(np.random.normal(scale=0.1, size = (l2, l1+1)))
			self._previousWeightDelta.append(np.zeros((l2,l1+1)))		# +1 for adding bias 


	def Run(self, input):			# input - rows where each row represents the data 
		inCases = input.shape[0]
		self._layerInput = []
		self._layerOutput = []
		for index  in range(self.layerCount):
			if index == 0:
				layerInput = self.weights[0].dot(np.vstack([input.T, np.ones([1, inCases])]))
			else:
				layerInput = self.weights[index].dot(np.vstack([self._layerOutput[-1], np.ones([1, inCases])]))

			self._layerInput.append(layerInput)
			self._layerOutput.append(self.tFuncs[index](layerInput))

		return self._layerOutput[-1].T

	def TrainEpoch(self, input, target, trainingRate = 0.2, momentum = 0.9):
		# This method trains the network for one epoch
		delta = []
		inCases = input.shape[0]
		self.Run(input)

		# Compute deltas
		for index in reversed(range(self.layerCount)):
			if index == self.layerCount-1:
				output_delta = self._layerOutput[index] - target.T
				error = np.sum(output_delta**2)
				delta.append(output_delta * self.tFuncs[index](self._layerInput[index], True))
			else:
				delta_pullback = self.weights[index+1].T.dot(delta[-1])
				delta.append(delta_pullback[:-1,:]*self.tFuncs[index](self._layerInput[index], True))

		# Compute weight deltas
		for index in range(self.layerCount):
			delta_index = self.layerCount-1-index
			if index == 0:
				layerOutput = np.vstack([input.T, np.ones([1, inCases])])
			else:
				layerOutput = np.vstack([self._layerOutput[index-1], np.ones([1, self._layerOutput[index-1].shape[1]])])

			curWeightDelta = np.sum(\
								layerOutput[None,:,:].transpose(2,0,1) * delta[delta_index][None,:,:].transpose(2,1,0), \
								axis = 0)
			weightDelta = trainingRate * curWeightDelta + momentum * self._previousWeightDelta[index]

			self.weights[index] -= weightDelta
			self._previousWeightDelta[index] = weightDelta

		return error

# Test Script

if __name__ == "__main__":

	lFuncs = [None, sgm, tanh]
	# (no.of Inputs, no.of Layers [can have many values], no.of Outputs) Eg: bpn = BackPropagationNetwork((2,2,2,1))
	bpn = BackPropagationNetwork((2,2,1), lFuncs)	# passing lFuncs is optional
	print bpn.shape
	print bpn.weights

	# Training Data
	lvInput = np.array([[0,0],[0,1],[1,0],[1,1]])
	lvTarget = np.array([[0.05],[0.95],[0.95],[0.05]])

	lnMax = 100000
	lnErr = 1e-5
	for i in range(lnMax):
		err = bpn.TrainEpoch(lvInput, lvTarget)
		if i%10000 == 0:
			print "Iteration: ",i," Error: ", err
		if err <= lnErr:
			print "Minimum error at: ", i
			break

	# Testing Data
	lvInput2 = np.array([[0,1],[0,1],[1,0],[1,0],[0,0],[1,1]])
	lvOutput = bpn.Run(lvInput2)
	for i in range(lvInput2.shape[0]):
		print "Input: {0} Output: {1}".format(lvInput2[i],lvOutput[i])

