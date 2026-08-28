

public class DSAStack {

    private Object[] stack;
    private int count;
    private int DEFAULT_CAPACITY = 100;

    // default constructor
    public DSAStack() {
        stack = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    // alternate constructor
    public DSAStack(int maxCapacity) {
        stack = new Object[maxCapacity];
        count = 0;
    }

    // accessors
    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == stack.length;

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

    public Object pop() {
        Object topValue = top();
        count--;
        return topValue;
    }

    public Object top() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        else
            return stack[count - 1];

    }
}