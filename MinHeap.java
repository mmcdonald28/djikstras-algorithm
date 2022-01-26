public class MinHeap
{
    // Making min heap, pairs with better/lower value wil be at the root of the tree to get removed easier,
    // While the bottom will be the pairs with the bad/high number value
    Node root;
    Node [] heap;
    int size;

    // Constructor
    public MinHeap()
    {
        size = 0;
        heap = new Node[100]; // This queue for the heap can hold up to 100 ppl
        root = null;
    }

    /**
     * Inserts into the heap
     * @param value value inserted
     */
    public void insert (int value) // name = key, ranking = value
    {
        Node newNode = new Node(value);

        // If empty
        if (root == null)
        {
            size = size + 1;
            root = newNode;
            heap[0] = root;
        }
        else
        {
            size = size + 1;
            heap[size-1] = newNode;
        }
        percolateUp(size - 1);
    }

    /**
     * Percolates up the heap recursively swapping nodes when needed
     * @param childIdx idx of the child node being looked at
     */
    public void percolateUp(int childIdx)
    {
        if (childIdx > 0)
        {
            // Swap parent & child if child < parent
            if (heap[childIdx].value < heap[childIdx/2].value)
            {
                Node swap = heap[childIdx];
                heap[childIdx] = heap[childIdx / 2];
                heap[childIdx / 2] = swap;
                // recursively call the function again this time w the parent
                percolateUp(childIdx / 2);
            }
        }
    }

    /**
     * Deletes root from heap
     * @return int deleted
     */
    public int delete()
    {
        // Delete the root (lowest ranking in the queue)
        Node temp = heap[0];
        heap[0] = heap[size-1];
        size--;

        percolateDown(0);

        return temp.value;
    }

    /**
     * Percolates down the heap recursively swapping the nodes as needed
     * @param parentIdx parent node being looked at
     */
    public void percolateDown(int parentIdx)
    {
        int idxL;
        int idxR;

        // Since 0*2 = 0;
        if(parentIdx == 0)
        {
            idxL = 1;
            idxR = 2;
        }
        else
        {
            idxL = parentIdx * 2;
            idxR = parentIdx * 2 + 1;
        }

        int min = parentIdx;

        /* Checks if the children are less than the parents, and
        checks if these indexes exist in the defined array, this was made in
        response to a ton of null pointer exceptions I was getting*/
        if (idxL < size && heap[idxL].value < heap[parentIdx].value)
            min = idxL;
        if (idxR < size && heap[idxR].value < heap[min].value)
            min = idxR;

        if (heap[min].value < heap[parentIdx].value)
        {
            Node swap = heap[parentIdx];
            heap[parentIdx] = heap[min];
            heap[min] = swap;
            percolateDown(min);
        }
    }

    /**
     * Displays heap
     */
    public void display ()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print("Heap: " + heap[i].value + " ");
        }
        System.out.println();
    }

    /**
     * Searches for element in heap
     * @param val val being searched for
     * @return int of element searched for
     */
    public int search(int val)
    {
        int idx = 0;
        while (heap[idx].value != val)
        {
            idx++;
        }
        return heap[idx].value;
    }


    //-----------------------------------------------------------------------------------------------------------------

    public class Node
    {
        int value;
        Node left;
        Node right;

        public Node(int v)
        {
            value = v;
            left = null;
            right = null;
        }
    }
}

