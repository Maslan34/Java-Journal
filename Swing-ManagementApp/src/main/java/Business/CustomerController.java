package Business;

import DAO.CustomerDao;
import Entity.Customer;

import java.util.ArrayList;


public class CustomerController {
    private final CustomerDao customerDao = new CustomerDao();

    public Customer findById(int id) {
        return this.customerDao.findById(id);
    }

    public ArrayList<Customer> findAll() {
        return this.customerDao.findAll();
    }
}