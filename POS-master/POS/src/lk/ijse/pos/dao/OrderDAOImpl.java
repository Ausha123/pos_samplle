package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl {

    public boolean addOrder(Orders orders) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Orders VALUES (?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, orders.getId());
        pstm.setObject(2, orders.getDate());
        pstm.setObject(3, orders.getCustomerId());
        return (pstm.executeUpdate() > 0);
    }

    public boolean deleteOrder() {
        throw new UnsupportedOperationException("This feature is not supported yet");
    }

    public boolean updateOrder() {
        throw new UnsupportedOperationException("This feature is not supported yet");
    }

    public Orders searchOrder() {
        throw new UnsupportedOperationException("This feature is not supported yet");
    }

    public ArrayList<Orders> getAllOrders() {
        throw new UnsupportedOperationException("This feature is not supported yet");
    }
}
