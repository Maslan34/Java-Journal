package DesignPatterns.Behavioural.Command.BadExample;

import DesignPatterns.Behavioural.Command.OperatorKind;

public class Calculator {

    public static int calculate(OperatorKind operator, int num1, int num2) {
        if(OperatorKind.SUM.equals(operator)) {
            return num1 + num2;

        }else if(OperatorKind.MULTIPLY.equals(operator)) {
            return num1 * num2;
        }
        else if(OperatorKind.DIVIDE.equals(operator)) {
            return num1 / num2;
        }
        else {
            return num1-num2;
        }
    }
}
