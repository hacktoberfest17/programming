# SCORE: 300/300
# Below we will define an n-interesting polygon. 
# Your task is to find the area of a polygon for a given n.

# A 1-interesting polygon is just a square with a side of length 1.
# An n-interesting polygon is obtained by taking the n - 1-interesting polygon and 
# appending 1-interesting polygons to its rim, side by side. 
# You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.

def shapeArea(n):
    num = 1
    for i in range(2, n+1):
        num += (i-1)*4
        
    return num
        
    
