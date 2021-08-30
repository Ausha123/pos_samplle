package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    public boolean addCustomer(Customer customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement( "INSERT INTO Customer VALUES (?,?,?,?)");

        pstm.setObject(1, customer.getcID ());
        pstm.setObject(2, customer.getName ());
        pstm.setObject(3, customer.getAddress ());
        pstm.setObject(4, 0);
        return true;
    }

    public boolean updateCustomer(Customer customer) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setObject(1, customer.getcID ());
        pstm.setObject(2, customer.getName ());
        pstm.setObject(3, customer.getAddress ());
        return true;
    }

    public boolean deleteCustomer(String id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setObject(1, id);
        return true;
    }

    public Customer searchCustomer(String id) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery( "SELECT * FROM Customer where id=?");
        return null;
    }

    public ArrayList<Customer> getAllCustomer() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery( "SELECT * FROM Customer");
        ArrayList<Customer> alCustomers = new ArrayList<>();

        while (rst.next()) {

            Customer customer = new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));

            alCustomers.add(customer);

        }
        return alCustomers;
    }
}