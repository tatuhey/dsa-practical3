import java.util.*;

public class Testing {
    
    public static void main(String[] args) {
        int selection = 100000;
        Scanner sc = new Scanner(System.in);

        while(selection != 0){
            selection = sc.nextInt();

            System.out.println("Select testing:");
            System.out.println("1. Stack\n2. Shuffle queue\n3. Circular Queue\n0. Exit");
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

        for(int i = 0; i <= cap; i++) {
            int randomNum = (int) (Math.random() * 101);
            stackTest.push(randomNum);
        }

        int selection = 100000;
        while(selection != 0) {
            System.out.println("1. getcount\n2. isempty\n3. isfull\n4. push\n5. pop\n0. exit");
            selection = sc.nextInt();
            switch(selection) {
                case 1:
                    System.out.println(stackTest.getCount());
                    break;
                case 2:
                    System.out.println(stackTest.isEmpty());
                    break;
                case 3: 
                    System.out.println(stackTest.isFull());
                    break;
                case 4:
                    System.out.println("Enter integer to push");
                    selection = sc.nextInt();
                    stackTest.push(selection);
                    break;
                case 5:
                    System.out.println(stackTest.pop());
                    break;
                default:
                    System.out.println("Wrong selection.");
            }
        }


        sc.close();
    }

    public static void shufflequeueTesting() {

    }
    public static void circularqueueTesting() {

    }

}
