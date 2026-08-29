public abstract class DSAQueue {
    
    // cannot be private
    protected Object[] queue;
    protected int count;
    protected int DEFAULT_CAPACITY = 100;

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

    // they are defined in the subclasses (shuffleQ and circularQ)
    // https://math.hws.edu/eck/cs124/javanotes6/c5/s5.html
    // https://stackoverflow.com/questions/79411745/polymorphism-and-abstract-classes-in-java
    // https://www.w3schools.com/java/java_polymorphism.asp
    // PDI lecture06

    public abstract void enqueue(Object value);
    public abstract Object dequeue(Object value);
    public abstract Object peek();
}


class shuffleQueue extends DSAQueue {

    // https://stackoverflow.com/questions/18141596/which-exception-to-throw-when-user-tries-to-add-to-a-full-container
    @Override
    public void enqueue(Object value) {
        if (isFull())
            throw new IllegalStateException("Queue is full");
        else {
            queue[count] = value;
            count++;
        }
    }

    @Override
    public Object dequeue(Object value) {
        Object frontVal = peek();
        for(int i = 1; i < count-1 ; i++) {
            queue[i] = queue[i+1];
        }
        count--;
        return frontVal;
    }

    @Override
    public Object peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        else
            return queue[0];
    }
}