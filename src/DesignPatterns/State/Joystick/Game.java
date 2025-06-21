package DesignPatterns.State.Joystick;

public class Game {

    private Joystick joystick;

    public Game() {
        System.out.println("Game Started...");
        this.joystick = new AttackState();
    }

    public void triggerTriangle() {
        this.joystick.triangleButtonPressed();
    }

    public void triggerCircle() {
        this.joystick.circleButtonPressed();
    }

    public void triggerCross(){
        this.joystick.crossButtonPressed();
    }

    public void triggerSquare() {
        this.joystick.squareButtonPressed();
    }

    public void changeState() {
        System.out.println("Possession is lost or won — the situation is changing.");
        if(this.joystick instanceof AttackState)
            this.joystick = new DefanceState();
        else
            this.joystick =new AttackState();
    }
}
