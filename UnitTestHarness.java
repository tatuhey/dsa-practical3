/*
made by gemini
*/

public class UnitTestHarness {

    public static void main(String[] args) {
        System.out.println("=== STARTING DATA STRUCTURE TESTS ===\n");
        testStack();
        
        // Polymorphic testing for queues
        System.out.println("\n--- Testing ShuffleQueue Polymorphically ---");
        testQueue(new ShuffleQueue(5));

        System.out.println("\n--- Testing CircularQueue Polymorphically ---");
        testQueue(new CircularQueue(5));
        
        testCircularWrapAround();
        System.out.println("\n=== ALL TESTS COMPLETED SUCCESSFULLY ===");
    }

    public static void testStack() {
        System.out.println("--- Testing DSAStack ---");
        DSAStack stack = new DSAStack(3);

        // Test isEmpty on new stack
        assertTest("Stack initially empty", stack.isEmpty());
        assertTest("Stack initial count is 0", stack.getCount() == 0);

        // Test Push
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertTest("Stack is full at max capacity", stack.isFull());
        assertTest("Stack count is 3", stack.getCount() == 3);

        // Test Push to Full Stack Exception
        try {
            stack.push("D");
            assertTest("Stack overflow exception throwing", false);
        } catch (IllegalStateException e) {
            assertTest("Stack overflow exception throwing", true);
        }

        // Test Top & Pop
        assertTest("Top element is 'C'", stack.top().equals("C"));
        assertTest("Pop returns 'C'", stack.pop().equals("C"));
        assertTest("Pop returns 'B'", stack.pop().equals("B"));
        assertTest("Count reduced to 1", stack.getCount() == 1);

        stack.pop(); // Remove 'A'
        assertTest("Stack empty after popping all elements", stack.isEmpty());

        // Test Pop on Empty Stack Exception
        try {
            stack.pop();
            assertTest("Stack underflow exception throwing", false);
        } catch (IllegalStateException e) {
            assertTest("Stack underflow exception throwing", true);
        }
    }

    // Accepts abstract type DSAQueue to demonstrate polymorphism
    public static void testQueue(DSAQueue queue) {
        assertTest("Queue initially empty", queue.isEmpty());

        // Test Enqueue
        queue.enqueue("10");
        queue.enqueue("20");
        queue.enqueue("30");
        queue.enqueue("40");
        queue.enqueue("50");

        assertTest("Queue is full", queue.isFull());
        assertTest("Queue count is 5", queue.getCount() == 5);

        // Test Enqueue Full Exception
        try {
            queue.enqueue("60");
            assertTest("Queue overflow exception throwing", false);
        } catch (IllegalStateException e) {
            assertTest("Queue overflow exception throwing", true);
        }

        // Test Peek and Dequeue
        assertTest("Peek front element is '10'", queue.peek().equals("10"));
        assertTest("Dequeue returns '10'", queue.dequeue().equals("10"));
        assertTest("Dequeue returns '20'", queue.dequeue().equals("20"));
        assertTest("Queue count is now 3", queue.getCount() == 3);

        // Clear queue
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertTest("Queue empty after fully dequeuing", queue.isEmpty());

        // Test Dequeue Empty Exception
        try {
            queue.dequeue();
            assertTest("Queue underflow exception throwing", false);
        } catch (IllegalStateException e) {
            assertTest("Queue underflow exception throwing", true);
        }
    }

    // Specific test for Circular Queue boundary conditions
    public static void testCircularWrapAround() {
        System.out.println("\n--- Testing CircularQueue Ring Buffer Wrap-around ---");
        DSAQueue cQueue = new CircularQueue(3);

        cQueue.enqueue("X");
        cQueue.enqueue("Y");
        cQueue.enqueue("Z"); // [X, Y, Z]
        
        cQueue.dequeue(); // Removes X -> Front moves to 1
        cQueue.dequeue(); // Removes Y -> Front moves to 2

        // Enqueueing beyond initial array bounds to verify % array.length wrapping
        cQueue.enqueue("W"); 
        cQueue.enqueue("V"); 

        assertTest("Circular Queue wrapped enqueue successful", cQueue.isFull());
        assertTest("Front item is 'Z'", cQueue.peek().equals("Z"));
        assertTest("Dequeue 'Z'", cQueue.dequeue().equals("Z"));
        assertTest("Next Dequeue is wrapped element 'W'", cQueue.dequeue().equals("W"));
    }

    private static void assertTest(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
        } else {
            System.err.println("[FAIL] " + testName);
        }
    }
}