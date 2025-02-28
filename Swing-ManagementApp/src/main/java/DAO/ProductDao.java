package DAO;

import Core.MongoDBConnection;
import Entity.Customer;
import Entity.Product;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class ProductDao {


    private MongoDBConnection mongoDBConnection;

    public ProductDao (){
        this.mongoDBConnection = MongoDBConnection.getInstance();
    }


    public Product findById(String id) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Products");


            // Casting String to here MongoDb ObjectId
            ObjectId objectId = new ObjectId(id);

            // Search Customer by ID
            Document productDoc = collection.find(Filters.eq("_id", objectId)).first();


            if (productDoc != null) {
                Product product = new Product();
                product.setId(productDoc.getObjectId("_id").toString());
                product.setName(productDoc.getString("name"));
                product.setCode(productDoc.getString("code"));
                product.setPrice(productDoc.getInteger(("price")));
                product.setStock(productDoc.getInteger("stock"));

                return product;
            }
        } catch (Exception e) {
            System.out.println("Error Finding Product: " + e.getMessage());
        }
        return null;
    }

    public boolean update(Product product) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Products");


            ObjectId objectId = new ObjectId(product.getId());


            Document updateFields = new Document()
                    .append("name", product.getName())
                    .append("code", product.getCode())
                    .append("price", product.getPrice())
                    .append("stock", product.getStock());


            collection.updateOne(Filters.eq("_id", objectId), new Document("$set", updateFields));

            return true;
        } catch (Exception e) {
            System.out.println("Error Updating Product: " + e.getMessage());
            return false;
        }
    };

    public boolean save(Product product) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Products");

            // Create new customer data
            Document productDoc = new Document()
                    .append("name", product.getName())
                    .append("code", product.getCode())
                    .append("price", product.getPrice())
                    .append("stock", product.getStock());

            collection.insertOne(productDoc);

            return true;
        } catch (Exception e) {
            System.out.println("Error Saving Product: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Customer> filter(String name, String type) {
        ArrayList<Customer> customers = new ArrayList<>();
        MongoCollection<Document> collection = MongoDBConnection.getCollection("Customers");

        System.out.println("type"+type);
        Bson filter;

        if (name != null && type != null) {
            filter = Filters.and(
                    Filters.regex("name", ".*" + name + ".*", "i"),  // İsmi içerenleri büyük/küçük harfe duyarsız filtrele
                    Filters.eq("type", type) // Türü tam eşleşme olarak filtrele
            );
        } else if (name == null && type != null) {
            filter = Filters.eq("type", type); // Sadece türü eşleşenleri getir
        } else if (name != null && type == null) {
            filter = Filters.regex("name", ".*" + name + ".*", "i"); // Sadece ismi içerenleri getir
        } else {
            return new ArrayList<>(); // Eğer hiçbir kriter yoksa boş liste döndür
        }

        // MongoDB'den verileri çekip listeye ekliyoruz
        FindIterable<Document> results = collection.find(filter);
        for (Document customerDoc : results) {
            Customer customer = new Customer();
            customer.setId(customerDoc.getObjectId("_id").toString());
            customer.setName(customerDoc.getString("name"));
            customer.setPhone(customerDoc.getString("phone"));
            customer.setMail(customerDoc.getString("mail"));
            customer.setAddress(customerDoc.getString("address"));
            customer.setType(Customer.ETYPE.valueOf(customerDoc.getString("type")));

            customers.add(customer);
        }
        System.out.println("customers"+customers);
        return customers;
    }



    public boolean delete(Product product) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Products");

            // Deleting Product by ObjectID
            DeleteResult result = collection.deleteOne(Filters.eq("_id", new ObjectId(product.getId())));

            // if delete is success return true
            return result.getDeletedCount() > 0;
        } catch (Exception e) {
            System.out.println("Error Deleting Product: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Products");

            // Fetch All customer
            FindIterable<Document> productDocs = collection.find();

            for (Document productDoc : productDocs) {
                Product product = new Product();
                product.setId(productDoc.getObjectId("_id").toString());
                product.setName(productDoc.getString("name"));
                product.setCode(productDoc.getString("code"));
                product.setPrice(productDoc.getInteger("price"));
                product.setStock(productDoc.getInteger("stock"));

                products.add(product);
            }
        } catch (Exception e) {
            System.out.println("Error Fetching Products: " + e.getMessage());
        }
        return products;
    }
}
