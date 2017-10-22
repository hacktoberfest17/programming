from numpy import exp, array, random, dot

trainingSet_ins = array([[0,0,1],[0,1,0],[0,1,1],[1,0,1],[1,1,0],[1,1,1]])
trainingSet_outs = array([[0,0,1,1,1,1]]).T
random.seed(1)
synapse_weights = 2 * random.random((3, 1)) - 1
for iteration in xrange(10000):
    output = 1 / (1 + exp(-(dot(trainingSet_ins, synapse_weights))))
    synapse_weights += dot(trainingSet_ins.T, (trainingSet_outs - output) * output * (1 - output))
print 1 / (1 + exp(-(dot(array([1,0,0]), synapse_weights))))
