package Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private String id;
    private String customerID;
    private int price;
    private String note;
    private LocalDate date;
    private Customer customer;
    private ArrayList<Product> products;

    public Cart() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() { // ✅ Tekil değil, liste olarak döner
        return products;
    }

    public void setProducts(ArrayList<Product> products) { // ✅ Tekil yerine liste olarak kaydet
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", customerID='" + customerID + '\'' +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
