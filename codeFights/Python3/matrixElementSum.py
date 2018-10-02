# https://codefights.com/arcade/intro/level-2/xskq4ZxLyqQMCLshr

def matrixElementsSum(matrix):
    noOfRows = len(matrix)
    noOfElements = len(matrix[0])
    currRow = matrix[0]
    k=0
    i=0
    mainsum = 0
    for i in range(noOfRows):
        for j in range(noOfElements):
            if matrix[i][j] is not 0:
                mainsum+= int(matrix[i][j])
            else:
                k = i
                for k in range(noOfRows):
                    matrix[k][j]=0
                
    return mainsum

#New Code

def matrixSum(matrix):
    #Switch order of traversal from row->column 
    #to column->row
