package DesignPatterns.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Packet implements Priceable {

    private  String packetName;
    private List<Product> productList;

    public Packet(String packetName) {
        this.packetName = packetName;
        this.productList = new ArrayList<>();
    }

    public String getPacketName() {
        return packetName;
    }

    public void setPacketName(String packetName) {
        this.packetName = packetName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getPrice() {
        int totalPrice = 0;
        for(Product product : productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
