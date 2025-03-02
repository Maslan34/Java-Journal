package DAO;

import Core.MongoDBConnection;
import Entity.Basket;
import Entity.Customer;
import Entity.Product;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BasketDao {

    private MongoDBConnection mongoDBConnection;
    private ProductDao productDao = new ProductDao();

    public BasketDao (){
        this.mongoDBConnection = MongoDBConnection.getInstance();
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
                    .append("type", customer.getType().name()); // Saving the Enum as a String.


            collection.updateOne(Filters.eq("_id", objectId), new Document("$set", updateFields));

            return true;
        } catch (Exception e) {
            System.out.println("Error Updating Customer: " + e.getMessage());
            return false;
        }
    };



    public String save(Basket basket) {
        try {
            MongoCollection<Document> collection = MongoDBConnection.getCollection("Baskets");



            if (basket.get_id() != null) {
                // Eğer basket ID varsa, mevcut basketi bul ve güncelle
                ObjectId objectId = new ObjectId(basket.get_id());
                Document existingBasket = collection.find(Filters.eq("_id", objectId)).first();

                if (existingBasket != null) {

                    UpdateResult updateResult = collection.updateOne(
                            Filters.eq("_id", objectId),
                            Updates.push("products", basket.getProduct().getId()) // Ürünü diziye ekler
                    );

                    if (updateResult.getModifiedCount() > 0) {
                        System.out.println("Basket updated: " + basket.getProduct().getId());
                        return basket.get_id(); // Mevcut basketin ID'sini döndür
                    }
                }
            }

            // Eğer basket ID yoksa veya mevcut basket bulunamadıysa, yeni bir basket oluştur
            Document basketDoc = new Document()
                    .append("products", Arrays.asList(basket.getProduct().getId())); // İlk ürünü array olarak ekle

            collection.insertOne(basketDoc);

            ObjectId insertedId = basketDoc.getObjectId("_id");
            return insertedId.toHexString(); // Yeni oluşturulan basketin ID'sini döndür
        } catch (Exception e) {
            System.out.println("Error Saving Basket: " + e.getMessage());
            return null;
        }
    }


    public ArrayList<Product> findBasket(String basketID) {
        ArrayList<Product> products = new ArrayList<>();
        Basket basket = new Basket();
        try {

            MongoCollection<Document> collection = MongoDBConnection.getCollection("Baskets");


            Document basketDoc = collection.find(Filters.eq("_id", new ObjectId(basketID))).first();

            if (basketDoc != null) {
                // Basket ID'yi ata
                String basketId = basketDoc.getObjectId("_id").toHexString();

                // "products" dizisini al
                if (basketDoc.containsKey("products") && basketDoc.get("products") != null) {
                    List<String> productIds = basketDoc.getList("products", String.class);

                    for (String productId : productIds) {
                        Product product = productDao.findById(productId); // ID ile ürünü bul
                        if (product != null) {
                            products.add(product);
                        }
                    }
                }
            } else {
                System.out.println("Basket not found with ID: " + basketID);
            }
        } catch (Exception e) {
            System.out.println("Error Fetching Basket: " + e.getMessage());
        }

        return products;
    }








}
