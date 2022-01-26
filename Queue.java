public class Queue
{
    // Attributes
    int size;
    int[] arr;
    int front = -1;
    int rear = -1;

    /**
     * Constrcutor
     * @param size of queue
     */
    public Queue(int size)
    {
        this.size = size;
        arr = new int[size];
    }

    /**
     * Insert item to wrapped queue
     * @param item the item to insert
     */
    public void enqueue(int item)
    {
        // No isFull check bc it will never hit the full condition anyway
            rear = (rear + 1) % size;
            arr[rear] = item;

        // Had to initialize front to not be -1 b/c of my empty condition
        if (front == -1)
            front = 0;
    }

    /**
     * remove from wrapped queue
     * @return the value that gets removed
     */
    public int dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Empty");
            return - 1;
        }
        else
        {
            int temp = arr[front];
            arr[front] = 0;
            front = (front +1) % size;
            return temp;
        }
    }

    /**
     * Prints queue
     */
    public void print()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public boolean isEmpty()
    {
        return (front == -1);
    }

    public boolean isFull()
    {
        if (front == 0 && rear == size-1)
        {
            return true;
        }
        else if (rear == front - 1)
        {
            return true;
        }
        else
            return false;
    }



}
