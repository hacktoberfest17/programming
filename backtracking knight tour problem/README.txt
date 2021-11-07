BACKTRACKING:KNIGHT TOUR PROBLEM

Backtracking is an algorithmic paradigm that tries different solutions until finds a solution that “works”. 
Problems which are typically solved using backtracking technique have following property in common. 
These problems can only be solved by trying every possible configuration and each configuration is tried only once. 
A Naive solution for these problems is to try all configurations and output a configuration that follows given problem constraints. 
Backtracking works in incremental way and is an optimization over the Naive solution where all possible configurations are generated and tried.

The knight is placed on the first block of an empty board and, moving according to the rules of chess, must visit each square exactly once.

Backtracking works in an incremental way to attack problems. Typically, we start from an empty solution vector and one by one add items (Meaning of item varies from problem to problem. 
In context of Knight’s tour problem, an item is a Knight’s move). When we add an item, we check if adding the current item violates the problem constraint, if it does then we remove the item and try other alternatives. 
If none of the alternatives work out then we go to previous stage and remove the item added in the previous stage. If we reach the initial stage back then we say that no solution exists. 
If adding an item doesn’t violate constraints then we recursively add items one by one. If the solution vector becomes complete then we print the solution.