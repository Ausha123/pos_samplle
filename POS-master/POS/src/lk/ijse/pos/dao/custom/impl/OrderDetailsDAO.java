package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.SuperDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface OrderDetailsDAO extends SuperDAO<OrderDetails,String> {


}
