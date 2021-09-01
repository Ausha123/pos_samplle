package lk.ijse.pos.bo.custom;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO{
    boolean addCustomer(CustomerDTO customer) throws Exception;

    boolean deleteCustomer(String id) throws Exception;

    boolean updateCustomer(CustomerDTO customer) throws Exception;

    CustomerDTO searchCustomer(String id) throws Exception;

    ArrayList<CustomerDTO> getAllCustomer() throws Exception;
}