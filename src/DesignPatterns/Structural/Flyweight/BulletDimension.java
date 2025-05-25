package DesignPatterns.Structural.Flyweight;

public enum BulletDimension {

    Three(3),
    Five(5),
    Seven(7);

    private int dimension;

    BulletDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return "BulletDimension{" +
                "dimension=" + dimension +
                '}';
    }
}
