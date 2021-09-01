package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    private final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.add(new Customer(customer.getId(),customer.getName(),customer.getAddress()));

    }

    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.update(new Customer(customer.getId(), customer.getName(), customer.getAddress()));

    }

    public CustomerDTO searchCustomer(String id) throws Exception {
        Customer search = customerDAO.search(id);
        return  new CustomerDTO(search.getcID(),search.getName(),search.getAddress());
    }

    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        for (Customer customer  : all) {
            allCustomers.add(new CustomerDTO(customer.getcID(),customer.getName(),customer.getAddress()));
        }
        return allCustomers;
    }
}
