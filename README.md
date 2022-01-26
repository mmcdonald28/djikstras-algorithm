# djikstras-algorithm
A data structures project created from a Queue, Stack, Minheap, and Adjacency List all created by me. 
The program asks you to input a graph in the format of the input file (input.txt) or you can input your own file in similar format.
The input file format: The first line will always have the number of nodes in the graph followed by the number of
edges. In the example above, we have a graph with 12 nodes (0-11) and 55 edges. The
following 55 lines (since we have 55 edges) will consist of 3 numbers per line: To, From, Weight.
For the example above, the first edge goes from 0 to 1 and has a weight of 3, the second edge
goes from 0 to 11 with a weight of 5 and the last edge goes from 11 to 11 with a weight of 12
(self-pointing edge).
Ran from the Tester file, the program displays the input file / graph in adajacency list format, the promps the user if they would like the see the djikstras algorithm of the graph (a shortest path program), or if the user would like to see a depth first search and breadth first search.
