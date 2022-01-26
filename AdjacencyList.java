public class AdjacencyList
{
    // Attributes
    LinkedList [] arr;
    int buckets;

    // Constructor
    public AdjacencyList(int buckets)
    {
        this.buckets = buckets;
        arr = new LinkedList[buckets];

        // Creating linked lists at each slot of the array
        for(int i = 0; i < arr.length;i++)
        {
            arr[i] = new LinkedList();
        }
    }

    /**
     * Calls upon the L.L insert to insert node at end of L.L at correct index
     * @param from he index of the array that has a connection to the node inserted,
     *          the vertex that the connection is coming from
     * @param to vertex of the node being inserted, where the connection is going to
     * @param weight weight of node inserted
     */
    public void insert(int from, int to, int weight)
    {
        arr[from].insert(from,to,weight);
    }

    /**
     * Displays the adjaceny list in easy to read format
     */
    public void display()
    {
        int counter = 0;
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(counter + " --> ");
            arr[i].display();
            counter++;
        }
        System.out.println("");
    }

    // -----------------------------------------------------------------------------------------------------------------

    // Made this class off of modified old L.L code, figured it would save time with the open Hash table
    public class LinkedList
    {
        hashNode head;
        int size = 0;

        // Constructor
        public LinkedList()
        {
            head = null;
        }

        public boolean empty()
        {
            return head == null;
        }

        /**
         * At the given array inserts Node at the end of the L.L
         * @param from the index of the array that has a connection to the node inserted,
         *             the vertex that the connection is coming from
         * @param to vertex of the node being inserted, where the connection is going to
         * @param weight weight of node inserted
         */
        public void insert (int from, int to, int weight)
        {
            // Vars
            hashNode newNode = new hashNode(to,weight,null);
            hashNode temp = head;

            // Check + insert if empty
            if (empty())
            {
                head = newNode;
            }
            // Insert
            else
            {
                while (temp.next != null)
                {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            size++;
        }

        /**
         * Searches for a specific hashnode
         * @param v val being searched for
         * @return the hashnode w/ value v
         */
        public hashNode search (int v) // METHOD ADDED LATE; ASSUMES ALL INPUTS VALID
        {
            hashNode temp = head;
            int counter = 0;

            while (temp != null)
            {
                if (counter == v)
                    return temp;
                temp = temp.next;
                counter++;
            }
            return null;
        }

        /**
         * Displays L.L
         */
        public void display()
        {
            // Node current will point to head
            hashNode temp = head;

            if(head == null)
            {
                return;
            }

            while(temp != null)
            {
                if (temp.next == null)
                {
                    System.out.print("[" + temp.vertex + " " + temp.weight + "]");
                    temp = temp.next;
                }
                else
                {
                    // Prints each node by incrementing pointer
                    System.out.print("[" + temp.vertex + " " + temp.weight+ "]" + " --> ");
                    temp = temp.next;
                }
            }
            System.out.println("");
        }


    }

    // -----------------------------------------------------------------------------------------------------------------

    public class hashNode
    {
        int vertex;
        int weight;
        hashNode next;

        public hashNode(int vertex, int weight, hashNode next)
        {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }
}



