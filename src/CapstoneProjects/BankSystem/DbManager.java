package CapstoneProjects.BankSystem;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class DbManager {
    private final Gson gson = new Gson();

    public void append(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        Gson gson = new Gson();
        Path dbPath = Paths.get("PATH-TO-YOUR-DB.JSON");

        List<User> users = new ArrayList<>();

        // 2. Reading Exists Users
        if (Files.exists(dbPath)) {
            try {
                String jsonString = Files.readString(dbPath, StandardCharsets.UTF_8);
                if (!jsonString.isBlank()) {
                    // Convert to List
                    User[] userArray = gson.fromJson(jsonString, User[].class);
                    users = new ArrayList<>(Arrays.asList(userArray));
                }
            } catch (IOException e) {
                throw new RuntimeException("Data reading error", e);
            }
        }

        // 3. Adding new user
        users.add(user);

        // 4. Updating file
        update(users);
    }


    public void update(List<User> users) {
        if (users == null) {
            throw new IllegalArgumentException("Users cannot be null");
        }

        // 2. Converting Json via Gson lib
        Gson gson = new Gson();
        String jsonString = gson.toJson(users);

        // 3. Temporary file path
        Path tempPath = Paths.get("PATH-TO-YOUR-DB.JSON");
        Path finalPath = Paths.get("PATH-TO-YOUR-DB.JSON");

        try {
            // 4. Write to temporary file
            Files.writeString(tempPath, jsonString,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);

            // 5. Check spelling for accuracy
            String writtenJson = Files.readString(tempPath);
            if (!jsonString.equals(writtenJson)) {
                throw new IOException("The written data does not match the original data");
            }

            Files.move(tempPath, finalPath,
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.ATOMIC_MOVE);

            System.out.println("Data updated successfully!");

        } catch (IOException e) {
            // 7. Cleaning in case of error
            try {
                Files.deleteIfExists(tempPath);
            } catch (IOException cleanupEx) {
                e.addSuppressed(cleanupEx);
            }
            throw new RuntimeException("File update error", e);
        }
    }

    public List<User> read() {
        Gson gson = new Gson();

        try (FileInputStream fis = new FileInputStream("src/CapstoneProjects/BankSystem/db.json");
             InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.UTF_8)) {

            // JSON --> List<User>
            List<User> users = gson.fromJson(reader, new TypeToken<List<User>>() {
            }.getType());

            // Null Check
            return users != null ? users : Collections.emptyList();

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return Collections.emptyList();
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
            return Collections.emptyList();
        } catch (JsonSyntaxException e) {
            System.err.println("Invalid JSON format: " + e.getMessage());
            return Collections.emptyList();
        }
    }



}

