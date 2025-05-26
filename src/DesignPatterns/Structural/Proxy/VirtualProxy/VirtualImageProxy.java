package DesignPatterns.Structural.Proxy.VirtualProxy;

public class VirtualImageProxy implements Image{
    private RealImage realImage;
    private String filename;

    public VirtualImageProxy(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}
