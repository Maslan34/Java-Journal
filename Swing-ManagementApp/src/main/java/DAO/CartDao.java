package DAO;

import Core.MongoDBConnection;
import Entity.Cart;
import Entity.Product;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CartDao {

    private MongoDBConnection mongoDBConnection;
    private ProductDao productDao = new ProductDao();
    private CustomerDao customerDao = new CustomerDao();

    public CartDao (){
        this.mongoDBConnection = MongoDBConnection.getInstance();
    }


    public ArrayList<Cart> findAll() {
        ArrayList<Cart> carts = new ArrayList<>();
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Carts");

            // Fetch all carts
            FindIterable<Document> cartDocs = collection.find();

            for (Document cartDoc : cartDocs) {
                Cart cart = new Cart();
                cart.setId(cartDoc.getObjectId("_id").toString());
                cart.setPrice(cartDoc.getInteger("price"));
                cart.setCustomerID(cartDoc.getString("customerID"));
                cart.setNote(cartDoc.getString("note"));
                cart.setDate(LocalDate.parse(cartDoc.getString("date")));
                cart.setCustomer(this.customerDao.findById(cartDoc.getString("customerID")));

                // ProductID'leri çek ve Product objelerine dönüştür
                ArrayList<Product> products = new ArrayList<>();
                for (String productId : cartDoc.getList("productIDs", String.class)) {
                    products.add(this.productDao.findById(productId));
                }
                cart.setProducts(products); // `List<Product>` olarak kaydet

                carts.add(cart);
            }
        } catch (Exception e) {
            System.out.println("Error Fetching Carts: " + e.getMessage());
        }
        return carts;
    }



    public boolean save(Cart cart) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Carts");

            // Create new Cart data

            List<String> productIDs = new ArrayList<>();
            for (Product product : cart.getProducts()) {
                productIDs.add(product.getId());
            }

            System.out.println("Product IDs: " + productIDs);


            Document cartDoc = new Document()
                    .append("price", cart.getPrice())
                    .append("customerID", cart.getCustomer().getId())
                    .append("productIDs", productIDs)
                    .append("note", cart.getNote())
                    .append("date", cart.getDate().toString());


            collection.insertOne(cartDoc); // ✅ Tek bir doküman olarak kaydet!

            return true;
        } catch (Exception e) {
            System.out.println("Error Saving Cart: " + e.getMessage());
            return false;
        }
    }
}
