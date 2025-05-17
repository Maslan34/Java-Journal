package DesignPatterns.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Package implements Priceable{

    private String packageName;
    private List<Product> productList;
    private List<Packet> packetList;


    public Package(String packageName) {
        this.packageName = packageName;
        this.productList = new ArrayList<>();
        this.packetList = new ArrayList<>();
    }

    @Override
    public int getPrice() {
        int totalPrice = 0;
        for (Product product : productList) {
            totalPrice+=product.getPrice();
        }
        for (Packet packet : packetList) {
            totalPrice+=packet.getPrice();
        }

        return totalPrice;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Packet> getPacketList() {
        return packetList;
    }

    public void setPacketList(List<Packet> packetList) {
        this.packetList = packetList;
    }
}
