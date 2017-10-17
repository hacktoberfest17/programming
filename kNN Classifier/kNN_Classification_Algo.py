import numpy as np
import random

points = np.array([[1,1],[1,2],[1,3],[2,1],[2,2],[2,3],[3,1],[3,2],[3,3]])
p = np.array([3,2])
outcomes = np.array([0,0,0,0,1,1,1,1,1])

def distance(p1,p2):
    """Find the distance between two points"""
    return np.sqrt(np.sum(np.power(p2-p1,2)))

def majority_select(votes):
    """ Returns the most frequent class,i.e. who has maximum occurence"""
    vote_counts={}
    for vote in votes:
        #for known ones
        if vote in vote_counts:
            vote_counts[vote]+=1
        #for unknown ones
        else:
            vote_counts[vote] = 1
            
    max_freq=[]
    max_countValue = max(vote_counts.values())
    for vote,count in vote_counts.items():
        if count==max_countValue:
            max_freq.append(vote)
    return random.choice(max_freq)

def nearest_neighbours(points,p,k=5):#k is the no of nearest neighbours to return
    """Returns the closest k neighbours of p""" 
    distances = np.zeros(points.shape[0])#to hold all of the distances.

    for i in range(len(distances)):
        distances[i] = distance(p,points[i])
        #sort the distances to get the shortest distance, using index vector
    ind = np.argsort(distances)# results in an array of indices(sorted indices)
    return ind[:k]

#predicting the class to which the points belong
def knn_predict(p,points,outcomes,k=5):
    ind = nearest_neighbours(p,points,k)
    print(majority_select(outcomes[ind]))

knn_predict(p,points,outcomes,3)#k can be taken as user input
#Scope of the script-
#can classify all points(synthetically generated) on a prediction grid and plot them
