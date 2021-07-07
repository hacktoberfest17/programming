#------logistic regression using Tensorflow------#
#------------Mohit Yadav-------------------------#
#------------------------------------------------#
import numpy as np
import pandas as pd
import tensorflow as tf
import matplotlib.pyplot as plt

#step 1: load MNIST dataset. Scripts already available in tensorflow
from tensorflow.examples.tutorials.mnist import input_data

MNIST = input_data.read_data_sets("/data/mnist",one_hot=True)

#step 2: Define parameters for model
learning_rate = 0.001
batch_size = 128
n_epochs = 25

#step 3: create placeholders

X = tf.placeholder(tf.float32,[batch_size,784])
Y = tf.placeholder(tf.float32,[batch_size,10])

w = tf.Variable(tf.random_normal(shape =[784,10], stddev=0.01 ), name = "weights")

b = tf.Variable(tf.zeros([1,10]), name = "bias")

logts = tf.matmul(X,w) + b

entropy = tf.nn.softmax_cross_entropy_with_logits(logits=logts , labels=Y)
loss = tf.reduce_mean(entropy) # computes the mean over examples in the batch



optimizer =tf . train . GradientDescentOptimizer ( learning_rate = learning_rate ). minimize ( loss)
init = tf . global_variables_initializer ()
with tf.Session () as sess:
    sess.run (init)
    n_batches = int(MNIST.train.num_examples / batch_size)
    for i in range ( n_epochs ): # train the model n_epochs times
        for _ in range ( n_batches ):
            X_batch , Y_batch = MNIST.train.next_batch(batch_size)
            sess.run ([ optimizer , loss ], feed_dict ={ X : X_batch , Y : Y_batch })

