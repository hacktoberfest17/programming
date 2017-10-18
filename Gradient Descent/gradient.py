from numpy import *

def compute_error(b, m, points):
    totalerror = 0
    for i in range(0, len(points)):
        x = points[i, 0]
        y = points[i, 1]
        totalerror += (y - (m * x + b)) ** 2
    return totalerror / float(len(points))

def step_gradient(b, m, points, learning_rate):
    #gradient descent
    b_gradient = 0
    m_gradient = 0
    N = float(len(points))

    for i in range(0, len(points)):
        x = points[i, 0]
        y = points[i, 1]
        b_gradient += -(2/N) * (y - ((m * x) + b))
        m_gradient += -(2 / N) * x * (y - ((m * x) + b))
    new_b = b - (learning_rate * b_gradient)
    new_m = m - (learning_rate * m_gradient)

    return [new_b, new_m]

def gradient_descent_runner(points, initial_b, initial_m, learning_rate,  num_of_iterations):
    b = initial_b
    m = initial_m

    for i in range(num_of_iterations):
        b, m = step_gradient(b, m, array(points), learning_rate)
    return [b, m]

def run():
    points = genfromtxt('data1.csv', delimiter=',')
    learning_rate = 0.0001 #hyperparameter
    #slope and yintercept y = mx + b
    initial_b = 0
    initial_m = 0
    num_of_iterations = 1000
    [b, m] = gradient_descent_runner(points, initial_b, initial_m, learning_rate,  num_of_iterations)

    print(b)
    print(m)

if __name__ == "__main__":
    run()

