#----linear regression using tensorflow----#
#-------------@Copyright MohitYadav ------#
#------------------------------------------#
#------------------------------------------#
import numpy as np
import pandas as pd
import tensorflow as tf
import matplotlib.pyplot as plt
import xlrd



DATA_FILE = "Data/slr05.xls"


#step 1: read data from .xls file
data_sheet = pd.read_excel(DATA_FILE,sheet_name=None)
data_sheet.head()

#step 2: create placeholder for input X and label Y(number of theft)
X = tf.placeholder(tf.float32, name="X")
Y = tf.placeholder(tf.float32, name="Y")

#step 3: create variable w and b initialized to 0
w = tf.Variable(0.0,name="weights")
b = tf.Variable(0.0,name="bias")

#step 4: Y = wX+b
Y_predicted = X*w+b

#step 5 use squared error as a loss function
loss = tf.square(Y - Y_predicted, name="loss")

#step 6 using gradient descent optimizer wuth learning rate of 0.01 to minimize loss
optimizer = tf.train.GradientDescentOptimizer(learning_rate=0.001).minimize(loss)

#step 7 Start session
with tf.Session() as sess:
    #step 8 : initialize the necessary variables, in this case, w and b
    sess.run(tf.global_variables_initializer())
    writer = tf.summary.FileWriter ('./Graph'  , sess . graph)
    #step 9 : train the model
    for i in range(100):
        for index in range(len(data_sheet)):

            x,y=data_sheet.loc[index]['X'],data_sheet.loc[index]['Y']
            sess.run(optimizer,feed_dict={X:x,Y:y})
    w_value,b_value = sess.run([w,b])
    print(w_value,b_value,loss)
