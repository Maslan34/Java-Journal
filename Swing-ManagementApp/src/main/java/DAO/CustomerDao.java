package DAO;

import Core.MongoDBConnection;
import Entity.Customer;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import com.mongodb.client.MongoCollection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private MongoDBConnection mongoDBConnection;

    public CustomerDao (){
        this.mongoDBConnection = MongoDBConnection.getInstance();
    }


    public Customer findById(int id) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Customers");

            // Search Customer by ID
            Document customerDoc = collection.find(Filters.eq("id", id)).first();

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
        //System.out.println(customers);
        return customers;
    }
}
