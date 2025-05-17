package DesignPatterns.Structural.Composite.BadExample;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String cartName;
    private List<Packet> packetList;
    private List<Product> productList;

    public Cart(String basketName) {
        this.cartName = basketName;
        this.packetList = new ArrayList<>();
        this.productList = new ArrayList<>();
    }

    public int getCartTotalPrice() {
        int totalPrice=0;

        for(Product product: productList) {
            totalPrice+=product.getProductPrice();
        }

        for(Packet packet: packetList) {
            List<Product> packetProductList = packet.getProductList();
            for(Product product: packetProductList) {
                totalPrice+=product.getProductPrice();
            }
        }

        return totalPrice;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public List<Packet> getPacketList() {
        return packetList;
    }

    public void setPacketList(List<Packet> packetList) {
        this.packetList = packetList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
