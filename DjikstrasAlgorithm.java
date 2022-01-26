public class DjikstrasAlgorithm
{

    /**
     * Looks at the adjacency list, and outputs the shortest path to get to each vertex from a starting vertexs
     * @param vertexes Number of vertexes, used to set up the table used to show the data
     * @param adjList The AdjList that you do the program on
     * @param start The starting node, in most cases / our case 0
     */
    public static void djikstras(int vertexes, AdjacencyList adjList, int start)
    {
        // Variables
        // This 2D table arr represents the tables showing the shortest path
        int[][] dArr = new int[vertexes][4]; // vertexes = number of vertexes (rows), 3 = columns, c1 = node #, 2 = known, 3 = Dv, 4 = Pv
        MinHeap min = new MinHeap();

        // Updating initial info
        for (int i = 0; i < vertexes; i++)
        {
            dArr[i][0] = i;
            dArr[i][1] = 0;
            dArr[i][2] = 1000; // Assuming no input I work with deals with a weight that high
            dArr[i][3] = 0;
        }

        // Setting start points initial values
        dArr[start][1] = 0;
        dArr[start][2] = 0;
        dArr[start][3] = 0;

        // Inserting initial in the heap
        min.insert(start);

        // Runs while the heap is not empty
        while(min.size > 0)
        {
            // Extracting the current from the heap
            int v = min.delete();

            // If the element in the heap not been found
            if (dArr[v][1] == 0)
            {
                dArr[v][1] = 1; // Set the element in the heap found to = 1
                AdjacencyList.LinkedList currentLL = adjList.arr[v]; //Accesses the specific L.L at that index of the deleted Node

                // Loop to run through that vertex's connections and do the
                for (int i = 0; i < currentLL.size; i++)
                {
                    // Gets the node within each Linked List, at index i
                    AdjacencyList.hashNode tempNode = currentLL.search(i);

                    // Compare if current edges/connections weight + distance of v < temp's distance from table
                    if ((tempNode.weight + dArr[v][2]) < dArr[tempNode.vertex][2])
                    {
                        dArr[tempNode.vertex][2] = tempNode.weight + dArr[v][2];
                        dArr[tempNode.vertex][3] = v; // Pv
                    }
                    min.insert(tempNode.vertex);
                }
            }
        }

        System.out.println("Vertex, known, Distance to that node, Previous node\n|V|K|Dv|Pv|");

        for (int i = 0; i < vertexes; i++)
        {
            System.out.print("|");
            for (int j = 0; j < 4; j++)
            {
                System.out.print(dArr[i][j] + "|");
            }
            System.out.println(" ");
        }
        // 1 Create 2D array w initial info
        // 2 Insert initial in heap & update table Dv to 0
        // 3 Extract current from heap and find connection in adjacency list
        // 3.1 Compare Dv + Wx < dw from table
        // v = current node, w = weight of connection, x = idx of connection
        // If true: replace values in table dv+w, Pv
        // 3.2 Insert all that are not max or known heap
    }

    /**
     * Outputs depth first search of the adjacency list
     * @param adjList the adjacency list
     */
    public static void DFS (AdjacencyList adjList)
    {
        Stack stack = new Stack(adjList.arr.length);
        String ans = "";
        int current = 0;
        int counter = 0;

        // This loops as long as the counter isn't as long as the length of array
        while (counter != adjList.arr.length)
        {
            // Checks if the current vertex was already output to the answer
            boolean used = false;
            for (int i = 0; i < ans.length(); i++)
            {
                if (Integer.parseInt(ans.substring(i,i+1)) == current)
                    used = true;
            }

            // If the variable was already used pop the next element off of the stack
            if (used)
            {
                current = stack.pop();
            }
            // If the variable wasn't used add it to the array, and begin progress to
            else
            {
                // Adding the value to the answer array and updating counter
                ans += current;
                counter++;

                AdjacencyList.LinkedList currentLL = adjList.arr[current]; // Accesses the specific L.L at that index of the deleted Node
                // Loops through an vertexes connections, adding them to the stack.
                for (int i = 0; i < currentLL.size; i++)
                {
                    AdjacencyList.hashNode temp = currentLL.search(i); // Accesses specific node in the L.L
                    stack.push(temp.vertex);
                }

                // Get new vertex from the stack & repeat loop
                current = stack.pop();
            }
        }
        System.out.println("DFS: " + ans);
    }

    /**
     * breadth first search of the adj list
     * @param adjList the adj list
     */
    public static void BFS (AdjacencyList adjList)
    {
        Queue queue = new Queue(adjList.arr.length);
        String ans = "";
        int current = 0;
        int counter = 0;

        // This loops as long as the counter isn't as long as the length of array
        while (counter != adjList.arr.length)
        {
            // Checks if the current vertex was already output to the answer
            boolean used = false;
            for (int i = 0; i < ans.length(); i++)
            {
                if (Integer.parseInt(ans.substring(i,i+1)) == current)
                    used = true;
            }

            // If the variable was already used pop the next element off of the stack
            if (used)
            {
                current = queue.dequeue();
            }
            // If the variable wasn't used add it to the array, and begin progress to
            else
            {
                // Adding the value to the answer array and updating counter
                ans += current;
                counter++;

                AdjacencyList.LinkedList currentLL = adjList.arr[current]; // Accesses the specific L.L at that index of the deleted Node
                // Loops through an vertexes connections, adding them to the stack.
                for (int i = 0; i < currentLL.size; i++)
                {
                    AdjacencyList.hashNode temp = currentLL.search(i); // Accesses specific node in the L.L
                    queue.enqueue(temp.vertex);
                }

                // Get new vertex from the stack & repeat loop
                current = queue.dequeue();
            }
        }
        System.out.println("BFS: " + ans);
    }

}