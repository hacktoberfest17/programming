Depth First Traversal

Depth First Traversal for a graph is similar to Depth First Traversal of a tree. 
The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again. 
To avoid processing a node more than once, we use a boolean visited array.

The function dfsMain is used for cases when all vertices are not reachable from the starting vertex.

Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
