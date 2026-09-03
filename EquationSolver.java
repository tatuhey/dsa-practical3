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
        
        return result;
    }

    private static DSAQueue parseInfixToPostfix(String equation) {
        DSAStack stackOp = new DSAStack();
        CircularQueue cirQPostfix = new CircularQueue();

        String[] terms = parseTerm(equation);
        int index = 0;

        while(index < terms.length) { // because length of array is +1 than the index, so we use < instead of <= as it length starts a from 1 and index starts from 0

            String term = terms[index];

            if (term.equals("(")) {
                stackOp.push(term); // push the opening bracket to the stack
            } else if (term.equals(")")) {
                while(!stackOp.top().equals("(")) { // when the top of the stack is not an opening bracket, we pop the operators and enqueue them to the postfix queue
                    cirQPostfix.enqueue(stackOp.pop());
                }
                stackOp.pop(); // after all else, we pop the opening bracket from the stack
            } else if (term.equals("+") || term.equals("-") || term.equals("*") || term.equals("/")) {
                char currentOp = term.charAt(0); // convert string to char because presedenceOf() takes char as input
                while(!stackOp.isEmpty() && !stackOp.top().equals("(") && (presedenceOf(((String) stackOp.top()).charAt(0)) >= presedenceOf(currentOp))) { // left side of presedenceOf has to be char so we convert the top of stack to string then to char
                    cirQPostfix.enqueue(stackOp.pop());
                }
                stackOp.push(term);
            } else {
                cirQPostfix.enqueue(Double.parseDouble(term)); // convert string to double because now it should only have numbers
            }
            index++;
        }
        while(!stackOp.isEmpty()) {
            cirQPostfix.enqueue(stackOp.pop());
        }

        return cirQPostfix;
        
    }
 
    private static String[] parseTerm(String equation) {

        String[] split = equation.split(" ");
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