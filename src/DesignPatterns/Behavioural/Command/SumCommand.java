package DesignPatterns.Behavioural.Command;

public class SumCommand implements Calculate{

    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}
