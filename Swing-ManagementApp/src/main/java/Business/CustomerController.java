package Business;

import Core.Helper;
import DAO.CustomerDao;
import Entity.Customer;
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

    public boolean delete(Customer customer) {
        return this.customerDao.delete(customer);
    }

    public ArrayList<Customer> filter(String name, String type) {
        return this.customerDao.filter(name, type);
    }

    public boolean update(Customer customer) {
        if (customer.getId() == null) {
            Helper.showMessage("CUSTOMER_NOT_FOUND");
            return false;
        }
        return this.customerDao.update(customer);
    }


}