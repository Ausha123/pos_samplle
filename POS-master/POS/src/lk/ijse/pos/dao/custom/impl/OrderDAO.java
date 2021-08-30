package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.SuperDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public interface OrderDAO extends SuperDAO<Orders,String> {

}
