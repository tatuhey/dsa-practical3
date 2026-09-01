/*
DSA - COMP1002
RAIHAN KHALIL ABDILLAH
17900375
STACKS AND QUEUES
DATESTART: 28/08/2026
*/

import java.util.*;

public class EquationSolver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String term;
        System.out.println("Insert the equation below.");
        term = sc.nextLine();

        solve(term);

        sc.close();
    }

    public static double solve(String equation) {
        double result = 0;

        DSAQueue postfix = parseInfixToPostfix(equation);
        result = evaluatePostfix(postfix);

        return result;
    }

    private static DSAQueue parseInfixToPostfix(String equation) {
        DSAStack stackOp = new DSAStack();
        CircularQueue cirQPostfix = new CircularQueue();
        int index = 0;

        while(equation.length() > 0) {

            String[] term = parseTerm(equation);
            if (term[index].equals("(")) {
                stackOp.push(term[index]);
            } else if (term[index].equals(")")) {
                while(!stackOp.top().equals("(")) {
                    cirQPostfix.enqueue(stackOp.top());
                }
                stackOp.pop();
            } else if (term[index].equals('+') || term[index].equals('-') || term[index].equals('*') || term[index].equals('/')) {
                while(!stackOp.isEmpty() && !stackOp.top().equals('(') && (presedenceOf(stackOp.top().toString()) >= presedenceOf(term))) {

                }
            }
        }

        return cirQPostfix;
        
    }
 
    // https://stackoverflow.com/questions/27808112/java-splitting-with-math-expression
    private static String[] parseTerm(String equation) {
        equation =  equation.replaceAll("\\s", "");
        String[] split = equation.split("(?<=[\\d.])(?=[^\\d.])|(?<=[^\\d.])(?=[\\d.])");
        return split;
    }

    private static double evaluatePostfix(DSAQueue postfixQueue) {
        double result = 0;
        return result;
    }

    // https://www.geeksforgeeks.org/java/java-program-to-convert-infix-expression-to-postfix-expression/
    private static int presedenceOf(char theOp) {
        switch(theOp) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static double executeOperation(char op, double op1, double op2) {
        double result = 0;
        return result;
    }
    
}