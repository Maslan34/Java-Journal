package DAO;

import Core.MongoDBConnection;
import Entity.User;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import com.mongodb.client.MongoCollection;

public class UserDao {
    private MongoDBConnection mongoDBConnection;

    public UserDao() {
        this.mongoDBConnection = MongoDBConnection.getInstance();
    }

    public User findByLogin(String username, String password) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Users");

            // Find the user by username and password
            Document userDoc = collection.find(
                    Filters.and(
                            Filters.eq("username", username),
                            Filters.eq("password", password)
                    )
            ).first();

            if (userDoc != null) {
                return new User(
                        userDoc.getObjectId("_id").toString(),
                        userDoc.getString("username"),
                        userDoc.getString("mail"),
                        userDoc.getString("password") // In a real application, the password must be encrypted
                );
            }
        } catch (Exception e) {
            System.out.println("Error Finding User: " + e.getMessage());
        }
        return null; // Return null if the user is not found
    }
}

