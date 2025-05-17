package DesignPatterns.Structural.Composite.BadExample;

import java.util.ArrayList;
import java.util.List;

public class Packet {

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
}
