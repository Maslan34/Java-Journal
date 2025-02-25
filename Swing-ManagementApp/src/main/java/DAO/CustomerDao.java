package DAO;

import Core.MongoDBConnection;
import Entity.Customer;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import java.util.ArrayList;


public class CustomerDao {
    private MongoDBConnection mongoDBConnection;

    public CustomerDao (){
        this.mongoDBConnection = MongoDBConnection.getInstance();
    }


    public Customer findById(String id) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Customers");


            // Casting String to here MongoDb ObjectId
            ObjectId objectId = new ObjectId(id);

            // Search Customer by ID
            Document customerDoc = collection.find(Filters.eq("_id", objectId)).first();

            System.out.println(customerDoc);
            if (customerDoc != null) {
                Customer customer = new Customer();
                customer.setId(customerDoc.getObjectId("_id").toString());
                customer.setName(customerDoc.getString("name"));
                customer.setPhone(customerDoc.getString("phone"));
                customer.setMail(customerDoc.getString("mail"));
                customer.setAddress(customerDoc.getString("address"));
                customer.setType(Customer.ETYPE.valueOf(customerDoc.getString("type")));

                return customer;
            }
        } catch (Exception e) {
            System.out.println("Error Finding Customer: " + e.getMessage());
        }
        return null;
    }

    public boolean update(Customer customer) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Customers");


            ObjectId objectId = new ObjectId(customer.getId());


            Document updateFields = new Document()
                    .append("name", customer.getName())
                    .append("phone", customer.getPhone())
                    .append("mail", customer.getMail())
                    .append("address", customer.getAddress())
                    .append("type", customer.getType().name()); // Enum'ı String olarak kaydediyoruz.


            collection.updateOne(Filters.eq("_id", objectId), new Document("$set", updateFields));

            return true;
        } catch (Exception e) {
            System.out.println("Error Updating Customer: " + e.getMessage());
            return false;
        }
    };

    public boolean save(Customer customer) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Customers");

            // Yeni müşteri verisini oluştur
            Document customerDoc = new Document()
                    .append("name", customer.getName())
                    .append("phone", customer.getPhone())
                    .append("mail", customer.getMail())
                    .append("address", customer.getAddress())
                    .append("type", customer.getType().name());

            collection.insertOne(customerDoc);

            return true;
        } catch (Exception e) {
            System.out.println("Error Saving Customer: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Customer> findAll() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Customers");

            // Fetch All customer
            FindIterable<Document> customerDocs = collection.find();

            for (Document customerDoc : customerDocs) {
                Customer customer = new Customer();
                customer.setId(customerDoc.getObjectId("_id").toString());
                customer.setName(customerDoc.getString("name"));
                customer.setPhone(customerDoc.getString("phone"));
                customer.setMail(customerDoc.getString("mail"));
                customer.setAddress(customerDoc.getString("address"));
                customer.setType(Customer.ETYPE.valueOf(customerDoc.getString("type")));

                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println("Error Fetching Customers: " + e.getMessage());
        }
        return customers;
    }
}
