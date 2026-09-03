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
                    stackTesting();
                    break;
                case 2:
                    shufflequeueTesting();
                    break;
                case 3:
                    circularqueueTesting();
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

    public static void stackTesting(){
        Scanner sc = new Scanner(System.in);
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
            System.out.println("Stack\n1. getcount\n2. isempty\n3. isfull\n4. push\n5. pop\n0. exit\n");
            selection = sc.nextInt();
            switch(selection) {
                case 1:
                    System.out.println(stackTest.getCount() + "\n");
                    break;
                case 2:
                    System.out.println(stackTest.isEmpty()+ "\n");
                    break;
                case 3: 
                    System.out.println(stackTest.isFull()+ "\n");
                    break;
                case 4:
                    System.out.println("Enter integer to push");
                    selection = sc.nextInt();
                    stackTest.push(selection);
                    break;
                case 5:
                    System.out.println(stackTest.pop()+ "\n");
                    break;
                case 0:
                    System.out.println("exiting...");
                    break;
                default:
                    System.out.println("Wrong selection.");
            }
        }

        sc.close();
    }

    public static void shufflequeueTesting() {
        Scanner sc = new Scanner(System.in);
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
            System.out.println("Shuffle Queue\n1. getcount\n2. isempty\n3. isfull\n4. enqueue\n5. dequeue\n0. Exit");
            selection = sc.nextInt();
            switch(selection) {
                case 1:
                    System.out.println(shuffleqTest.getCount() + "\n");
                    break;
                case 2:
                    System.out.println(shuffleqTest.isEmpty() + "\n");
                    break;
                case 3:
                    System.out.println(shuffleqTest.isFull() + "\n");
                    break;
                case 4:
                    System.out.println("Enter integer to enqueue");
                    selection = sc.nextInt();
                    shuffleqTest.enqueue(selection);
                    break;
                case 5:
                    System.out.println(shuffleqTest.dequeue() + "\n");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong selection");
            }
        }

        sc.close();
    }
    public static void circularqueueTesting() {
        Scanner sc = new Scanner(System.in);
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
            System.out.println("Circular Queue\n1. getcount\n2. isempty\n3. isfull\n4. enqueue\n5. dequeue\n0. Exit");
            selection = sc.nextInt();
            switch(selection) {
                case 1:
                    System.out.println(circularqTest.getCount() + "\n");
                    break;
                case 2:
                    System.out.println(circularqTest.isEmpty() + "\n");
                    break;
                case 3:
                    System.out.println(circularqTest.isFull() + "\n");
                    break;
                case 4:
                    System.out.println("Enter integer to enqueue");
                    selection = sc.nextInt();
                    circularqTest.enqueue(selection);
                    break;
                case 5:
                    System.out.println(circularqTest.dequeue() + "\n");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong selection");
            }
        }

        sc.close();
    }

}
