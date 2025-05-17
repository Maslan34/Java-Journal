package DesignPatterns.Structural.Composite.BadExample;

public class Main {

    public static void main(String[] args) {

        // Bad Example
        Product tomato = new Product("tomato",3);
        Product apple = new Product("apple",2);
        Product onion = new Product("onion",1);

        Packet vegetablePacket = new Packet("vegatables");
        vegetablePacket.getProductList().add(tomato);
        vegetablePacket.getProductList().add(apple);
        vegetablePacket.getProductList().add(onion);

        Product samsungs8 = new Product("samsungs8",12000);
        Product apple16 = new Product("apple16",15000);
        Product playsation5 = new Product("playsation5",9000);

        Packet technologyPacket = new Packet("technology");
        technologyPacket.getProductList().add(samsungs8);
        technologyPacket.getProductList().add(apple16);
        technologyPacket.getProductList().add(playsation5);

        Product basketball = new Product("basketball",20);

        Cart cart = new Cart("cart");
        cart.getPacketList().add(technologyPacket);
        cart.getPacketList().add(vegetablePacket);
        cart.getProductList().add(basketball);

        System.out.println("Total Price: "+ cart.getCartTotalPrice());

        // Bad Example

        // What if we add a "package" that  packet and product ?. We need to change the all code again. Violation of Open/CLosed.





    }
}
