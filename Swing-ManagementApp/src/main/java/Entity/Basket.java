package Entity;

public class Basket {

    private String _id;
    private String productID;
    private Product product;
    public Basket() {}
    public Basket(String productID) {
        this.productID = productID;
    }
    public Basket(String _id, String productID, Product product) {
        this._id = _id;
        this.productID = productID;
        this.product = product;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "_id='" + _id + '\'' +
                ", productID='" + productID + '\'' +
                ", product=" + product +
                '}';
    }
}
