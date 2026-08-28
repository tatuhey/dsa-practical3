public class DSAStack {

    private Object[] stack;
    private int count;
    private int DEFAULT_CAPACITY = 100;
    private int capacity;

    // default constructor
    public DSAStack() {
        stack = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    // alternate constructor
    public DSAStack(int capacity) {
        stack = new Object[capacity];
        count = 0;
    }

    // accessors
    public int getCount() {
        return capacity;
    }

    public boolean isEmpty() {
        if (count == 0)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (count == capacity)
            return true;
        else
            return false;
    }

    // mutators
    public void push(Object value) {
        if (isFull()) 
            throw new IllegalStateException("Stack is full"); //https://stackoverflow.com/questions/18141596/which-exception-to-throw-when-user-tries-to-add-to-a-full-container
        else {
            stack[count] = value;
            count++;
        }
    }

    public void pop(Object topValue) {
        top(topValue);
        count--;
    }

    public void top(Object topValue) {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        else
            topValue = stack[count - 1];

    }
}