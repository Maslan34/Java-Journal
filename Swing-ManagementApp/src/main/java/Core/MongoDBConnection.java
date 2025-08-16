package Core;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {

    // Singelton Design Pattern
    private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "Swing-OrderManagement";

    private static MongoDBConnection instance;
    private MongoClient mongoClient;
    private static MongoDatabase database;


    private MongoDBConnection() {
        try {
            mongoClient = MongoClients.create(URI);
            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("Connection Successful: " + database.getName());
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }


    public static synchronized MongoDBConnection getInstance() {
        if (instance == null) {
            instance = new MongoDBConnection();
        }
        return instance;
    }

    public void getAllUsers() {
        try {
            MongoCollection<Document> collection = database.getCollection("Users");
            FindIterable<Document> users = collection.find();
            System.out.println("All Users -->:");
            for (Document user : users) {
                System.out.println(user.toJson());
            }

        } catch (Exception e) {
            System.out.println("Error Fetching All Users: " + e.getMessage());
        }
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }
}