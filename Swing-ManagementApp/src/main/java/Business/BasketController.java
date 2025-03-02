package Business;

import DAO.BasketDao;
import Entity.Basket;
import Entity.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class BasketController {
    private final BasketDao basketDao = new BasketDao();
/*
    public Customer findById(String id) {
        return this.customerDao.findById(id);
    }

 */
    public ArrayList<Product> findBasket(String basketID) {
        return this.basketDao.findBasket(basketID);
    }


    public String save(Basket basket) {
        return this.basketDao.save(basket);
    }
/*
    public boolean delete(Customer customer) {
        return this.customerDao.delete(customer);
    }

    public ArrayList<Customer> filter(String name ,String type) {
        return this.customerDao.filter(name,type);
    }

    public boolean update(Customer customer) {
        if(customer.getId() == null) {
            JOptionPane.showMessageDialog(null, "Customer Not Exist!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return this.customerDao.update(customer);
    }

 */
}
