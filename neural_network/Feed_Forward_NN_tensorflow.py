
import tensorflow as tf
from tensorflow.examples.tutorials.mnist import input_data
import os
os.environ['TF_CPP_MIN_LOG_LEVEL']='2'
mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)
from PIL import Image

n_nodes_hl1 = 200
n_nodes_hl2 = 100
n_nodes_hl3 = 60
n_nodes_hl4 = 30
n_classes = 10
hm_epochs = 20
batch_size = 100

x = tf.placeholder('float', [None, 784])
y = tf.placeholder('float', [None, 10])
# pkeep = tf.placeholder('float')
pkeep = 0.80

hidden_1_layer = {'weights': tf.Variable(tf.truncated_normal([784, n_nodes_hl1], stddev=0.1)),
  'biases': tf.Variable(tf.random_normal([n_nodes_hl1]))}

hidden_2_layer = {'weights': tf.Variable(tf.truncated_normal([n_nodes_hl1, n_nodes_hl2], stddev=0.1)),
  'biases': tf.Variable(tf.random_normal([n_nodes_hl2]))}

hidden_3_layer = {'weights': tf.Variable(tf.truncated_normal([n_nodes_hl2, n_nodes_hl3], stddev=0.1)),
  'biases': tf.Variable(tf.random_normal([n_nodes_hl3]))}
  
hidden_4_layer = {'weights': tf.Variable(tf.truncated_normal([n_nodes_hl3, n_nodes_hl4], stddev=0.1)),
  'biases': tf.Variable(tf.random_normal([n_nodes_hl4]))}
  
output_layer = {'weights': tf.Variable(tf.truncated_normal([n_nodes_hl4, n_classes], stddev=0.1)),
  'biases': tf.Variable(tf.random_normal([n_classes]))}
  



def neural_network_model(data):

	l1 = tf.add(tf.matmul(data, hidden_1_layer['weights']), hidden_1_layer['biases'])
	l1 = tf.nn.sigmoid(l1)
	l1 = tf.nn.dropout(l1, pkeep)

	l2 = tf.add(tf.matmul(l1, hidden_2_layer['weights']), hidden_2_layer['biases'])
	l2 = tf.nn.sigmoid(l2)
	l2 = tf.nn.dropout(l2, pkeep)

	l3 = tf.add(tf.matmul(l2, hidden_3_layer['weights']), hidden_3_layer['biases'])
	l3 = tf.nn.sigmoid(l3)
	l3 = tf.nn.dropout(l3, pkeep)

	l4 = tf.add(tf.matmul(l3, hidden_4_layer['weights']), hidden_4_layer['biases'])
	l4 = tf.nn.sigmoid(l4)
	l4 = tf.nn.dropout(l4, pkeep)

	output = tf.add(tf.matmul(l4, output_layer['weights']), output_layer['biases'])

	return output


def train_neural_network(x):
	prediction = neural_network_model(x)
	global_step = tf.Variable(10, trainable=False)
	starter_learning_rate = 0.003
	learning_rate = tf.train.exponential_decay(starter_learning_rate, global_step,1000, 0.98, staircase=True)
	# learning_rate = tf.train.natural_exp_decay(starter_learning_rate, global_step, 100, 0.98, staircase=True, name=None)

	cost = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(logits=prediction, labels=y))
	optimizer = tf.train.AdamOptimizer(learning_rate=learning_rate).minimize(cost, global_step=global_step) 
	with tf.Session() as sess:
		sess.run(tf.global_variables_initializer())

		for epoch in range(hm_epochs):
			epoch_loss = 0
			for j in range(int(mnist.train.num_examples/batch_size)):
				epoch_x, epoch_y = mnist.train.next_batch(batch_size)
				_, c = sess.run([optimizer, cost], feed_dict={x:epoch_x, y:epoch_y})
				epoch_loss += c
			print('Epoch', epoch+1, 'completed out of', hm_epochs, 'loss:', epoch_loss)

		correct = tf.equal(tf.argmax(prediction, 1), tf.argmax(y, 1))
		accuracy = tf.reduce_mean(tf.cast(correct, 'float'))
		print('Accuracy:', accuracy.eval({x:mnist.test.images, y:mnist.test.labels}))

train_neural_network(x)
