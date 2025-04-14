package OOPKeystones.Polymorphism;

public class ITPoly extends StaffPoly {

    private String mission;

    public ITPoly(String name, String phoneNumber, String mail, String area, String shift, String mission) {
        super(name, phoneNumber, mail, area, shift);
        this.mission = mission;
    }

    public void networkSetup(){
        System.out.println("IT "+this.getName()+" is setting up the network!");
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
