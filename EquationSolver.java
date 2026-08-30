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

        parseInfixToPostfix(equation);
        evaluatePostfix();

        return result;
    }

    private DSAQueue parseInfixToPostfix(String equation) {
        DSAStack stackOp = new DSAStack();
        CircularQueue cirQPostfix = new CircularQueue();

        while()
    }

    private double evaluatePostfix(DSAQueue postfixQueue) {
        double result = 0;
        return result;
    }

    private int presedenceOf(char theOp) {
        int result = 0;
        return result;
    }

    private double executeOperation(char op, double op1, double op2) {
        double result = 0;
        return result;
    }
    
}