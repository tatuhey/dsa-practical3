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

        double result = solve(term);
        System.out.println(result);
        
        sc.close();
    }

    public static double solve(String equation) {
        double result = 0;

        DSAQueue postfix = parseInfixToPostfix(equation);
        result = evaluatePostfix(postfix);

        System.out.println(postfix);
        return result;
    }

    private static DSAQueue parseInfixToPostfix(String equation) {
        DSAStack stackOp = new DSAStack();
        CircularQueue cirQPostfix = new CircularQueue();

        String[] terms = parseTerm(equation);
        int index = 0;

        while(index < terms.length) {

            String term = terms[index];

            if (term.equals("(")) {
                stackOp.push(term);
            } else if (term.equals(")")) {
                while(!stackOp.top().equals("(")) {
                    cirQPostfix.enqueue(stackOp.top());
                }
                stackOp.pop();
            } else if (term.equals('+') || term.equals('-') || term.equals('*') || term.equals('/')) {
                char currentOp = term.charAt(0);
                while(!stackOp.isEmpty() && !stackOp.top().equals('(') && (presedenceOf(((String) stackOp.top()).charAt(0)) >= presedenceOf(currentOp))) {
                    cirQPostfix.enqueue(stackOp.pop());
                }
                stackOp.push(term);
            } else {
                cirQPostfix.enqueue(Double.parseDouble(term));
            }
            index++;
        }
        while(!stackOp.isEmpty()) {
            cirQPostfix.enqueue(stackOp.pop());
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
        DSAStack evalStack = new DSAStack();

        while(!postfixQueue.isEmpty()) {
            Object term = postfixQueue.dequeue();
            
            if (term instanceof Double) {
                evalStack.push(term);
            } else {
                char op = ((String) term).charAt(0);
                double op2 = (Double) evalStack.pop();
                double op1 = (Double) evalStack.pop();

                double result = executeOperation(op, op1, op2);
                
                evalStack.push(result);
             }
        }

        return (Double) evalStack.pop();
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
        switch(op) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
    
}