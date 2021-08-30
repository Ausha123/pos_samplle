package lk.ijse.pos.dao.custom;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public interface OrderDAO {
    public boolean addOrder(Orders orders) throws Exception;


    public boolean deleteOrder() throws Exception;



    public boolean updateOrder() throws Exception;



    public Orders searchOrder() throws Exception;



    public ArrayList<Orders> getAllOrders() throws Exception;

}
