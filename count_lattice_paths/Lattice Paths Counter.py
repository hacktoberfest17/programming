class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    """
    Recursive method to calculate the number of paths from one point to another
    which only involve going down or to the right. Note that the starting
    point thus must be higher than the initial point, and this method  is
    not really feasible for numbers larger than 10
    """

    def calc_num_paths_to_point(self, p2):
        if self.x == p2.x or self.y == p2.y:
            return 1

        return self.calc_num_paths_to_point(Point(p2.x, p2.y - 1)) + self.calc_num_paths_to_point(Point(p2.x - 1, p2.y))


# Note that the grid's origin is in the top-left of the grid, not the bottom-left.
# Also, higher y values signify a point lower on the grid, not higher on it.
start = Point(0, 0)
end = Point(3, 3)


"""
Dynamic method to calculate the number of paths from the top-left
coordinate in a grid to the bottom-right. Only works if m==n
"""


def calc_num_paths_to_point(m, n):
    # m is the number of rows - 1, n is the number of columns - 1

    # Creates a 2D table to store the number of paths to the problem's
    # sub paths. Had n arrays, each with length m

    # Compensate for the values being 1 less than if they were in a grid
    # where (0,0) were the origin
    m += 1
    n += 1

    subPathCounts = [[0 for x in range(m)] for y in range(n)]

    # Sets the first value of each sub path to 1
    for i in range(m):
        subPathCounts[i][0] = 1

    # Sets each value of the first array to 1
    for j in range(n):
        subPathCounts[0][j] = 1

    for i in range(1, m):
        for j in range(n):
            # Sets the value of each element in the matrix to the sum of
            # the values directly above it and directly to the left of it
            subPathCounts[i][j] = subPathCounts[i - 1][j] + \
                subPathCounts[i][j - 1]

    # Print the arrays for better visualization
    # for path in subPathCounts:
    #     print(path)

    # Return the very last value of the very last sub path
    return subPathCounts[m - 1][n - 1]

"""
Formulaic method. Quickest by far.
"""

import math

def calc_num_paths_to_point_fast(m, n):
    return int( math.factorial(m - 1 + n - 1) / (math.factorial(m-1) * math.factorial(n-1)) )


# Use all three methods in order of speed for comparison

print("Recursive Method (Slowest)")
print("Enter a number between 1 and 10")
num = int(input())

print(start.calc_num_paths_to_point(Point(num,num)))

print("Done\n")

print("Dynamic Method (Faster)")
print("Enter a number between 1 and 2500")
num = int(input())

print(calc_num_paths_to_point(num, num))

print("Done\n")

print("Formulaic Method (Fastest but can't take big inputs)")
print("Enter a number between 1 and 500")
num = int(input())

print(calc_num_paths_to_point_fast(num, num))

print("Done\n")
