package DesignPatterns.Structural.Flyweight;

public abstract class Soldier {

    private BulletDimension bulletDimension;

    public Soldier(BulletDimension bulletDimension) {
        this.bulletDimension = bulletDimension;
    }

    public void fire() {
        //Bullet bullet = new Bullet(bulletDimension); -> No Flyweight
        Bullet bullet = BulletFactory.createBullet(bulletDimension);
        bullet.handleFire();
    }

    public void sprayArea() {
        System.out.println("Rat-a-tat");
        for (int i = 0; i < 5; i++) {
            Bullet bullet = new Bullet(bulletDimension);
            bullet.handleFire();
        }
    }
}
