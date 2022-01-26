import java.lang.reflect.Array;

public class Stack
{
    // Class attributes
    private int[] container;
    private int top;
    private int size;

    /**
     * Constructor
     * @param size size of the array used in stack
     */
    public Stack(int size)
    {
        this.size = size;
        this.top = -1;
        container = new int[size];
    }

    /**
     * Pushed val into stack
     * @param val generic variable, gets pushed in
     */
    public void push(int val)
    {
        if(isFull())
        {
            System.out.println("Stack is full");
            // You could grow the array
        }
        else
        {
            top = top + 1;
            container[top] = val;
        }
    }

    /**
     * Pops off top of stack
     * @return what got popped
     */
    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Nothing to delete");
            return -1;
        }
        int valToPop = container[top];
        top = top - 1;
        return valToPop;
    }

    /**
     * Gets top of stack
     * @return top of stack
     */
    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Empty");
            return -1;
        }
        return container[top];
    }

    /**
     * Checks if empty
     * @return t or f if empty
     */
    public boolean isEmpty()
    {
        return top == -1;
    }

    /**
     * Checks if full
     * @return t or f if full
     */
    public boolean isFull(){
        return top == size;
    }

    // Getters and Setters
    public int[] getContainer() {
        return container;
    }

    public void setContainer(int[] container) {
        this.container = container;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

