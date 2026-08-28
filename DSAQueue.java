public class DSAQueue {
    
    private Object[] queue;
    private int count;
    private int DEFAULT_CAPACITY = 100;

    // default constructor
    public DSAQueue() {
        queue = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    // alternate constructor
    public DSAQueue(int maxCapacity) {
        queue = new Object[maxCapacity];
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
        return count == queue.length;
    }

    // https://stackoverflow.com/questions/18141596/which-exception-to-throw-when-user-tries-to-add-to-a-full-container
    // mutators
    public void enqueue(Object value) {
        if (isFull())
            throw new IllegalStateException("Queue is full");
        else {
            queue[count] = value;
            count++;
        }
    }

    public Object dequeue(Object value) {
        Object frontVal = peek();
        for(int i = 1; i < count-1 ; i++) {
            queue[i] = queue[i+1];
        }
        count--;
        return frontVal;
    }

    public Object peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        else
            return queue[0];
        
        
    }
}