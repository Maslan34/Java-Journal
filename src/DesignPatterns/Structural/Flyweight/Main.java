package DesignPatterns.Structural.Flyweight;

import java.util.ArrayList;
import java.util.List;

// Structural
// Flyweight : Nesne yönelimli programlamada bellek kullanımını optimize etmek için kullanılan bir yapısal tasarım desenidir.
//  Çok sayıda nesne oluşturulması gereken durumlarda bu işi tek bir referans üzerinden yaparak
//  Bellek kullanımı önemli ölçüde düşürülebilir.
// Çok sayıda benzer objelerin kullanıldığı durumlarda tercih edilir.

public class Main {
    public static void main(String[] args) {

        List<Soldier> soldierList = new ArrayList<>();

        Captain captain = new Captain(BulletDimension.Five);
        soldierList.add(captain);

        for(int i=0 ;i<100;i++){
            Corporal corporal = new Corporal(BulletDimension.Three);
            soldierList.add(corporal);
        }

        for (Soldier soldier : soldierList) {
            soldier.fire();
        }

        for (Soldier soldier : soldierList) {
           // soldier.sprayArea();
        }
    }
}
