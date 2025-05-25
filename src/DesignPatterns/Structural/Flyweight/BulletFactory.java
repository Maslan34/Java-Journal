package DesignPatterns.Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class BulletFactory {
    private static Map<BulletDimension,Bullet> map = new HashMap<BulletDimension,Bullet>();

    public static Bullet createBullet(BulletDimension dimension) {
        Bullet bullet = map.get(dimension);

        if(bullet == null) {
            bullet = new Bullet(dimension);
            map.put(dimension, bullet);

        }
        return bullet;

    }
}
