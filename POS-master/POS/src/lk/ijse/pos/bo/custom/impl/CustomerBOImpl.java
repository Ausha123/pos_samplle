package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public boolean addCustomer(Customer customer) throws Exception {
        return customerDAO.add(customer);

    }

    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    public boolean updateCustomer(Customer customer) throws Exception {
        return customerDAO.update(customer);

    }

    public Customer searchCustomer(String id) throws Exception {
        return customerDAO.search(id);

    }

    public ArrayList<Customer> getAllCustomer() throws Exception {
        return customerDAO.getAll();
    }
}
