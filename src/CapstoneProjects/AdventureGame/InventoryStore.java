package CapstoneProjects.AdventureGame;

public class InventoryStore extends NormalLocation {

    public InventoryStore(Player player) {
        super("Inventory Store", player, 2);
    }

    @Override
    public boolean onLocation() {

        System.out.println("You are now in the Inventory Store!");
        System.out.println("You can buy new things here.");

        boolean isValid = false;

        while (!isValid) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");

            if (input.hasNextInt()) {
                int selection = input.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("Weapon Shop opened...");
                        exhibitWeapons();
                        isValid = true;
                        break;
                    case 2:
                        System.out.println("Armor Shop opened...");
                        exhibitArmors();
                        isValid = true;
                        break;
                    case 3:
                        System.out.println("Exiting Inventory Store...");
                        isValid = true;
                        break;
                    default:
                        System.out.println("Invalid selection. Please enter 1, 2, or 3.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                input.next();
            }
        }

        return true;

    }

    public void exhibitWeapons() {
        System.out.println(getPlayer().getInventory().getWeapon().getDamage());
        System.out.println(getPlayer().getCoin());
        System.out.println(getPlayer().getDamage());
        System.out.println("-------------- Weapons --------------");
        for(Weapon w : Weapon.getAllWeapons())
            System.out.println(w.toString());
        System.out.println("Please Select A Weapon");
        int selectedWeapon = input.nextInt();
        while(selectedWeapon<1 || selectedWeapon> Weapon.getAllWeapons().length) {
            System.out.println("Invalid input. Please Enter a valid number.");
            selectedWeapon = input.nextInt();
        }

        purchaseWeapon(selectedWeapon);

    }


    public void purchaseWeapon(int selectedWeapon) {
        Weapon weapon= Weapon.getAllWeapons()[selectedWeapon-1];
        int damage=0;
        if(weapon.getPrice()>getPlayer().getCoin())
            System.out.println("Your coin is insufficient to buy this weapon.\nPlease choose a cheaper one or try again after earning some coin.");
        else if(getPlayer().getInventory().getWeapon() !=null && getPlayer().getInventory().getWeapon().getId() == weapon.getId()  )
            System.out.println("You have already this weapon!");
        else{
            System.out.println("You have purchased "+ weapon.getName()+" weapon");
            // Removing current weapon damage from player
            getPlayer().setDamage( getPlayer().getDamage()- getPlayer().getInventory().getWeapon().getDamage() );
            // Removing current weapon damage from player

            damage= getPlayer().getDamage()+weapon.getDamage();
            getPlayer().setDamage(damage);
            getPlayer().setCoin(getPlayer().getCoin() - weapon.getPrice());
            getPlayer().getInventory().setWeapon(weapon);
            System.out.println("You gained strength now. Your current damage is "+ damage);
            System.out.println("Your remaining coin: "+getPlayer().getCoin());

        }
        System.out.println(damage);
        System.out.println(getPlayer().getCoin());
        System.out.println(getPlayer().getDamage());

    }


    public void exhibitArmors() {

        System.out.println("-------------- Armors --------------");
        for(Armor a : Armor.getAllArmors())
            System.out.println(a.toString());
        System.out.println("Please Select An Armor");
        int selectedArmor = input.nextInt();
        while(selectedArmor<1 || selectedArmor> Armor.getAllArmors().length) {
            System.out.println("Invalid input. Please Enter a valid number.");
            selectedArmor = input.nextInt();
        }

        purchaseArmor(selectedArmor);
    }


    public void purchaseArmor(int selectedArmor) {
        System.out.println(getPlayer().getInventory().getArmor());
        Armor armor= Armor.getAllArmors()[selectedArmor-1];
        if(armor.getPrice()>getPlayer().getCoin())
            System.out.println("Your coin is insufficient to buy this weapon.\nPlease choose a cheaper one or try again after earning some coin.");
        else if(getPlayer().getInventory().getArmor() !=null && getPlayer().getInventory().getArmor().getId() == armor.getId())
            System.out.println("You have already this armor!");
        else{
            System.out.println("You have purchased "+ armor.getName()+" armor!");


            getPlayer().setCoin(getPlayer().getCoin() - armor.getPrice());
            getPlayer().getInventory().setArmor(armor);

            System.out.println("Your remaining coin: "+getPlayer().getCoin());

        }
        System.out.println(getPlayer().getCoin());
        System.out.println(getPlayer().getInventory().getArmor());


    }
}
