package Business;

import DAO.UserDao;
import Entity.User;

public class UserController {
    private final UserDao userDao = new UserDao();

    public User findByLogin(String username, String password){
        return this.userDao.findByLogin(username,password);
    }
}
