package StackAndQueueAndList;


import java.util.Scanner;

public class ArithmeticalExpr {
    public void calc() {
        var stackOperator = new Stack<String>();
        var stackNum = new Stack<Double>();


        var scanner = new Scanner(System.in);

        String expr = scanner.nextLine();

        var strList = expr.split(" ");

        for (var buffer : strList) {
            if      (buffer.equals("("));
            else if (buffer.equals("+")) stackOperator.push(buffer);
            else if (buffer.equals("-")) stackOperator.push(buffer);
            else if (buffer.equals("*")) stackOperator.push(buffer);
            else if (buffer.equals("/")) stackOperator.push(buffer);
            else if (buffer.equals("sqrt")) stackOperator.push(buffer);
                //When Meeting 'Bracket', PoP a Operator
            else if (buffer.equals(")")) {
                String operator = stackOperator.pop();
                double result = stackNum.pop();
                if      (operator.equals("+")) result = stackNum.pop() + result;
                else if (operator.equals("-")) result = stackNum.pop() - result;
                else if (operator.equals("*")) result = stackNum.pop() * result;
                else if (operator.equals("/")) result = stackNum.pop() / result;
                else if (operator.equals("sqrt")) result = Math.sqrt(result);
                stackNum.push(result);
            }
            else stackNum.push(Double.parseDouble(buffer));
        }
        System.out.println(stackNum.pop());

    }
}
