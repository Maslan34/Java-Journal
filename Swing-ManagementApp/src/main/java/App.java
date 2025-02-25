import Business.UserController;
import Core.Helper;
import Core.MongoDBConnection;
import Entity.User;
import View.DashboardUI;
import View.LoginUI;

public class App {
    public static void main(String[] args) {

        MongoDBConnection mongoDBConnection = MongoDBConnection.getInstance();
        //mongoDBConnection.getAllUsers();
        Helper.setTheme();
    /*
        try {
            LoginUI loginUI = new LoginUI();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


     */
        UserController userController = new UserController();
        User user = userController.findByLogin("muharrem", "12345");
        DashboardUI dashboardUI = new DashboardUI(user);

    }

}