package Business;

import DAO.CustomerDao;
import Entity.Customer;

import javax.swing.*;
import java.util.ArrayList;


public class CustomerController {
    private final CustomerDao customerDao = new CustomerDao();

    public Customer findById(String id) {
        return this.customerDao.findById(id);
    }

    public ArrayList<Customer> findAll() {
        return this.customerDao.findAll();
    }

    public boolean save(Customer customer) {
        return this.customerDao.save(customer);
    }

    public boolean update(Customer customer) {
        if(customer.getId() == null) {
            JOptionPane.showMessageDialog(null, "Customer Not Exist!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return this.customerDao.update(customer);
    }


}