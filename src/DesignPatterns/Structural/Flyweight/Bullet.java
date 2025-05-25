package DesignPatterns.Structural.Flyweight;

public class Bullet {

    private BulletDimension bulletDimension;

    public Bullet(BulletDimension bulletDimension) {
        this.bulletDimension = bulletDimension;
        try {
            Thread.sleep(100); // Waiting 0.1 second
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(bulletDimension.getDimension()+"mm bullet created");
    }

    public void handleFire(){
        System.out.println("Bang!");
    }


}
