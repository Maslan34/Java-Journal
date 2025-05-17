package DesignPatterns.Structural.Composite;

// Structural
// Composite : Nesneleri ağaç yapısı (tree structure) şeklinde organize etmemizi sağlar.
// Hiyerarşik yapılar kurmak için (örneğin, dosya sistemleri, UI bileşen ağaçları, şirket organizasyonları)

public class Main {
    public static void main(String[] args) {

        Product tomato = new Product("tomato", 3);
        Product apple = new Product("apple", 2);
        Product onion = new Product("onion", 1);

        Packet vegetablePacket = new Packet("vegatables");
        vegetablePacket.getProductList().add(tomato);
        vegetablePacket.getProductList().add(apple);
        vegetablePacket.getProductList().add(onion);

        Product samsungs8 = new Product("samsungs8", 12000);
        Product apple16 = new Product("apple16", 15000);
        Product playsation5 = new Product("playsation5", 9000);

        Packet technologyPacket = new Packet("technology");
        technologyPacket.getProductList().add(samsungs8);
        technologyPacket.getProductList().add(apple16);
        technologyPacket.getProductList().add(playsation5);

        Product basketball = new Product("basketball", 20);

        Cart cart = new Cart("cart");
        cart.getCart().add(technologyPacket);
        cart.getCart().add(basketball);
        cart.getCart().add(vegetablePacket);

        System.out.println("Total Price: " + cart.getCartTotalPrice());
        Cart cart2 = new Cart("cart2");

        Package clothingPackage = new Package("Clothing Package");

        Packet underWearPacket = new Packet("underwear");
        Product shoes = new Product("shoes", 300);
        Product pants = new Product("pants", 200);
        underWearPacket.getProductList().add(shoes);
        underWearPacket.getProductList().add(pants);

        Product tshirt = new Product("tshirt", 100);
        clothingPackage.getPacketList().add(underWearPacket);
        clothingPackage.getProductList().add(tshirt);



        Packet accessory = new Packet("accessory");
        Product ring = new Product("ring", 40);
        Product necklace = new Product("necklace", 70);
        accessory.getProductList().add(ring);
        accessory.getProductList().add(necklace);

        Product glasses = new Product("glasses", 400);

        cart2.getCart().add(glasses); // Adding a one product
        cart2.getCart().add(accessory);// Adding a one packet that includes two products
        cart2.getCart().add(clothingPackage); // Adding one package that includes one packet and one product

        System.out.println("Total Price Clothing: " + cart2.getCartTotalPrice());
    }
}
