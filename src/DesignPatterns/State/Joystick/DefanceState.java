package DesignPatterns.State.Joystick;

public class DefanceState implements Joystick {
    @Override
    public void circleButtonPressed() {
        System.out.println("A sliding tackle is being made.");
    }

    @Override
    public void squareButtonPressed() {
        System.out.println("The player is being tackled.");
    }

    @Override
    public void triangleButtonPressed() {
        System.out.println("The goalkeeper is coming off his line.");
    }

    @Override
    public void crossButtonPressed() {
        System.out.println("Man-marking is being done.");
    }
}
