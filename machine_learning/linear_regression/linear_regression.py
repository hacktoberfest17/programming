# manual algebrical method
import numpy as np
import sys
print(sys.version)

x = np.array([[1, 2, 1], [2, 3, 1], [3, 4, 1], [6, 8, 1], [14, 6, 1]])
y = [4, 7, 11, 21, 25]

x_tr = np.array(x).T
b = np.dot(np.dot(np.linalg.inv(np.dot(x_tr,x)), x_tr) ,y)
print(b)


# sklearn method
from sklearn.linear_model import LinearRegression
lr = LinearRegression()
x = np.array([[1, 2], [2, 3], [3, 4], [6, 8], [14, 6]])
lr.fit(x, y)
print(lr.coef_, lr.intercept_)