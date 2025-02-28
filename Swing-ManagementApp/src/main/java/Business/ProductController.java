package Business;

import DAO.CustomerDao;
import DAO.ProductDao;
import Entity.Customer;
import Entity.Product;

import javax.swing.*;
import java.util.ArrayList;

public class ProductController {

    private final ProductDao productDao = new ProductDao();

    public Product findById(String id) {
        return this.productDao.findById(id);
    }


    public ArrayList<Product> findAll() {
        return this.productDao.findAll();
    }

    public boolean save(Product product) {
        return this.productDao.save(product);
    }


    public boolean delete(Product product) {
        return this.productDao.delete(product);
    }
/*
    public ArrayList<Customer> filter(String name ,String type) {
        return this.customerDao.filter(name,type);
    }
 */
    public boolean update(Product product) {
        if(product.getId() == null) {
            JOptionPane.showMessageDialog(null, "Product Not Exist!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return this.productDao.update(product);
    }


}
