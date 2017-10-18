# FLOYD WARSHALL ALGORITHM

The Floyd-Warshall algorithm is an algorithm for finding shortest paths in a weighted graph with positive or negative edge weights (but with no negative cycles). A single execution of the algorithm will find the lengths (summed weights) of the shortest paths between all pairs of vertices. Although it does not return details of the paths themselves, it is possible to reconstruct the paths with simple modifications to the algorithm. 

It compares all possible paths through the graph between each pair of vertices.

Time Complexity: O(V^3) where V represents the number of vertices.
