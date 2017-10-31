Breadth First Traversal

Breadth First Traversal for a graph is similar to Breadth First Traversal of a tree. 
The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again. 
To avoid processing a node more than once, we use a boolean visited array. For simplicity, it is assumed that all vertices are reachable from the starting vertex.

The Depth First Search (DFS) Main function is used for the case if all vertices are not reachable from the starting vertex.

Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
