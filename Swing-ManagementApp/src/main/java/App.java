import Business.UserController;
import Core.Helper;
import Core.MongoDBConnection;
import Entity.User;
import View.DashboardUI;
import View.LoginUI;

public class App {
    public static void main(String[] args) {

        // Initialize MongoDB connection using Singleton pattern
        MongoDBConnection mongoDBConnection = MongoDBConnection.getInstance();

        // Fetch and print all users (for debug or initialization purposes)
        mongoDBConnection.getAllUsers();

        // Setting the application theme
        Helper.setTheme();

        // Launch the login UI and catch any exceptions during initialization
        try {
            LoginUI loginUI = new LoginUI();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
        // Authenticate user with given credentials
        UserController userController = new UserController();
        User user = userController.findByLogin("muharrem", "12345");

        // Open the main dashboard UI with the authenticated user
        DashboardUI dashboardUI = new DashboardUI(user);

         */
    }

}