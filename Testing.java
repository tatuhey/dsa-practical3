/*
made by hand aka bit bad
03/09/2026
*/

import java.util.*;

public class Testing {
    
    public static void main(String[] args) {
        int selection = 100000;
        Scanner sc = new Scanner(System.in);

        while(selection != 0){
            System.out.println("Select testing:");
            System.out.println("1. Stack\n2. Shuffle queue\n3. Circular Queue\n0. Exit");
            selection = sc.nextInt();
            switch(selection) {
                case 1:
                    stackTesting(sc);
                    break;
                case 2:
                    shufflequeueTesting(sc);
                    break;
                case 3:
                    circularqueueTesting(sc);
                    break;
                case 0:
                    System.out.println("Exiting the testing");
                    break;
                default:
                    System.out.println("Wrong menu selection");
            }
        }

        sc.close();
    }

    public static void stackTesting(Scanner sc){
    
        int cap = 0;
        
        System.out.println("Input capacity of stack");
        cap = sc.nextInt();
        DSAStack stackTest = new DSAStack(cap);

        for(int i = 0; i < cap; i++) {
            int randomNum = (int) (Math.random() * 101);
            stackTest.push(randomNum);
        }

        int selection = 100000;
        while(selection != 0) {
            System.out.println("Stack\n1. getcount\n2. isempty\n3. isfull\n4. push\n5. pop\n6. top\n7. pop all\n8. push all (based on prior cap value)\n0. exit\n");
            selection = sc.nextInt();
            switch(selection) {
                case 1:
                    System.out.println("getCount(): " + stackTest.getCount() + "\n");
                    break;
                case 2:
                    System.out.println("isEmpty(): " + stackTest.isEmpty() + "\n");
                    break;
                case 3: 
                    System.out.println("isFull(): " + stackTest.isFull() + "\n");
                    break;
                case 4:
                    System.out.println("Enter integer to push");
                    selection = sc.nextInt();
                    stackTest.push(selection);
                    break;
                case 5:
                    System.out.println("pop(): " + stackTest.pop() + "\n");
                    break;
                case 6:
                    System.out.println("top(): " + stackTest.top() + "\n");
                    break;
                case 7:
                    for(int i = 0; i < cap; i++) {
                        System.out.println("pop(): " + stackTest.pop());
                    }
                    break;
                case 8:
                    for(int i = 0; i < cap; i++) {
                        int randomNum = (int) (Math.random() * 101);
                        stackTest.push(randomNum);
                    }
                    break;
                case 0:
                    System.out.println("exiting...");
                    break;
                default:
                    System.out.println("Wrong selection.");
            }
        }
    }

    public static void shufflequeueTesting(Scanner sc) {
        int cap = 0;
        
        System.out.println("Input capacity of stack");
        cap = sc.nextInt();
        DSAQueue shuffleqTest = new ShuffleQueue(cap);

        for(int i = 0; i < cap; i++) {
            int randomNum = (int) (Math.random() * 101);
            shuffleqTest.enqueue(randomNum);
        }

        int selection = 100000;
        while(selection != 0) {
            System.out.println("Shuffle Queue\n1. getcount\n2. isempty\n3. isfull\n4. enqueue\n5. dequeue\n6. peek\n7. dequeue all\n8. enqueue random (based on prior cap value)\n0. Exit");
            selection = sc.nextInt();
            switch(selection) {
                case 1:
                    System.out.println("getCount(): " + shuffleqTest.getCount() + "\n");
                    break;
                case 2:
                    System.out.println("isEmpty(): " + shuffleqTest.isEmpty() + "\n");
                    break;
                case 3:
                    System.out.println("isFull(): " + shuffleqTest.isFull() + "\n");
                    break;
                case 4:
                    System.out.println("Enter integer to enqueue");
                    selection = sc.nextInt();
                    shuffleqTest.enqueue(selection);
                    break;
                case 5:
                    System.out.println("dequeue(): " + shuffleqTest.dequeue() + "\n");
                    break;
                case 6:
                    System.out.println("peek(): " + shuffleqTest.peek() + "\n");
                    break;
                case 7:
                    for(int i = 0; i < cap; i++) {
                        System.out.println("dequeue(): " + shuffleqTest.dequeue());
                    }
                    break;
                case 8:
                    for(int i = 0; i < cap; i++) {
                        int randomNum = (int) (Math.random() * 101);
                        shuffleqTest.enqueue(randomNum);
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong selection");
            }
        }

    }
    public static void circularqueueTesting(Scanner sc) {
        int cap = 0;
        
        System.out.println("Input capacity of stack");
        cap = sc.nextInt();
        DSAQueue circularqTest = new CircularQueue(cap);

        for(int i = 0; i < cap; i++) {
            int randomNum = (int) (Math.random() * 101);
            circularqTest.enqueue(randomNum);
        }

        int selection = 100000;
        while(selection != 0) {
            System.out.println("Circular Queue\n1. getcount\n2. isempty\n3. isfull\n4. enqueue\n5. dequeue\n6. peek\n7. dequeue all\n8. enqueue random\n0. Exit");
            selection = sc.nextInt();
            switch(selection) {
                case 1:
                    System.out.println("getCount(): " + circularqTest.getCount() + "\n");
                    break;
                case 2:
                    System.out.println("isEmpty(): " + circularqTest.isEmpty() + "\n");
                    break;
                case 3:
                    System.out.println("isFull(): " + circularqTest.isFull() + "\n");
                    break;
                case 4:
                    System.out.println("Enter integer to enqueue");
                    selection = sc.nextInt();
                    circularqTest.enqueue(selection);
                    break;
                case 5:
                    System.out.println("dequeue(): " + circularqTest.dequeue() + "\n");
                    break;
                case 6:
                    System.out.println("peek(): " + circularqTest.peek() + "\n");
                    break;
                case 7:
                    for(int i = 0; i < cap; i++) {
                        System.out.println("dequeue(): " + circularqTest.dequeue());
                    }
                    break;
                case 8:
                    for(int i = 0; i < cap; i++) {
                        int randomNum = (int) (Math.random() * 101);
                        circularqTest.enqueue(randomNum);
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong selection");
            }
        }
    }

}
