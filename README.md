Project Write Up
----------------
1.) This program utilizes breadth first search to find the paths to connect 2 specified coordinates (given in the form of an Endpoints object). 
After copying the goals argument passed to the method to avoid modifying the original list, the method iterates through the "goals" which 
represent the endpoints that need to be connected, calling a helper function "findWire" for each goal.

The helper function uses breadth first search, implementing a queue to facilitate the traversal through
BFS, and a hashmap to store the "parents" of each node visited, in order to reconstruct the shortest path once the destination coordinate is reached. By first adding the start point 
to the queue, it then iteratively pops a value from the queue, checking the adjacent coordinates. The adjacent coordinates are then added to the queue, so long as they are not obstacles, 
they have not been visited yet, they are not an obstacle, and they are not occupied (unless it is the goal's endpoint). This implementation of breadth first search, once the 
goal value is found, allows us to iterate through the hashmap which was recording the "parents" of each coordinate, reconstructing the shortest path that was found. 

For each goal, if a wire is found by the helper function, the findPaths method adds it to the results list of wires. If a path is not found by the helper function, i is decremented,
if it reaches -1 (meaning no wire can be found) it returns the results. Otherwise, it compares maxResult to result, updating maxResult if result is greater. Then, the goal 
is added to the end of the list, allowing the program to continue finding wires. 

Essentially, it iteratively tries to connect the endpoints, if a dead end is found, it backtracks and tries a different goal. MaxResult maintains a record of the best result found so far, 
which ensures that the final result minimizes the aggregate length of all wires.

2.) One possible board that would be interesting to look at is one where all the start points and end points for the goals are on opposite sides of the board, with an 
obstacle blocking the middle in-between them, leaving only a gap of one. This would only allow one wire to connect across, meaning only the first goal would be completed.
After this, the following goals would not be possible, as every route to connect them would be blocked. At this point, the loop would check all goals, and as the wires from findWire
come back as null, they would get moved to the back of the goals list. Eventually, after there is none left unchecked, the loop conditions would be such 
that the result is returned, with only one wire in the array list.

Another interesting board would be one where multiple goals start from/end at the same point. In this case, the program will find the shortest path for the first one, 
marking down the path that it travelled on the board. Then, when the next goal is processed, having the same start and end points as the other, it will simply find the next
shortest path that does not overlap with the original. It is able to do this because it has marked that the original path is occupied on the board, meaning the findWire method
will avoid those coordinates when it is searching for a path the next time, allowing multiple paths to share source and destination points.

3.) Utilizing breadth first search, the program effectively finds the shortest paths to connect a given start and end point. By iteratively finding the shortest path
for each end point, the algorithm is able to dynamically add wires, meaning it can handle multiple wires sharing start points or end points, avoiding obstacles even if they
were to be added during routing. It also utilizes two array lists, maxResult and result, to compare results that are found, ensuring that the final result has the shortest possible connections.

4.) In the main method "findPaths", it copies over the endpoints N to a local copy, with a time complexity of O(N) where N is the number of endpoints passed. It then has a few linear time operations
before getting to the while loop. The while loop iterates through the N endpoints listed as goals, calling the "findWire" method for each. The "findWire" method
implements breadth first search, which has a time complexity of O(V+E), where V is the number of coordinates and E is the number of edges. In a rectangular grid such as our boards, the number of edges grows faster 
than number of coordinates as coordinates increases. At the smallest scale boards, V+E can be approximated by 2E, and as the boards get larger, it is essentially E, giving time
complexity of O(E) for "findWire", where E is the number of edges. Given that this is nested in the while loop from "findPaths" which is called N times, the time complexity of "findPaths" is
O(N*V), where N is the number of goals, and V is the number of edges in the board. 

This time complexity analysis is supported by the wall clock time measured from testing. In the tests, the base case used was a 1000 x 1000 board with only one goal.
The 1000x1000 board with 1 goal took around 300 milliseconds to complete. 
Upping the size of the grid to 1500x1500 (which about triples the number of edges), the wall clock time increases to around 920 milliseconds, which is about a 3 times increase from the 
first test. This supports the conclusion that the time complexity is O(N*V).
The third test keeps the board size the same, but increases the number of goals to 4, meaning it increased 4 times from the 1 goal in the previous test.
Timing the execution time of this gave a run time of ~3300 milliseconds, which is a little bit under 4 times the previous (920 milliseconds) time, with only one goal. This further supports
the conclusion of the time complexity being O(N*V).

Based on the code analysis and wall clock time evaluation, it appears the time complexity to be O(N*V), where N is the number of goals given, and V is the number of edges on the board.
