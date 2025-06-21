package DesignPatterns.Behavioural.State.Joystick;

public class AttackState implements Joystick {
    @Override
    public void circleButtonPressed() {
        System.out.println("A cross is being made into the penalty area.");
    }

    @Override
    public void squareButtonPressed() {
        System.out.println("Shooting");
    }

    @Override
    public void triangleButtonPressed() {
        System.out.println("A through ball is played.");
    }

    @Override
    public void crossButtonPressed() {
        System.out.println("Giving a pass");
    }
}
