package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.model.OrderDetails;

import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public boolean add(OrderDetails orderDetails) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO OrderDetails VALUES (?,?,?,?)", orderDetails.getOrderId(), orderDetails.getItemCode(), orderDetails.getQty(), orderDetails.getUnitPrice());
    }

    @Override
    public boolean update(OrderDetails entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public OrderDetails search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws Exception {
        return null;
    }
}
