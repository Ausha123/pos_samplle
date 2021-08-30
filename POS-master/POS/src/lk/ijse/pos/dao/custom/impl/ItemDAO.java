package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.SuperDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public interface ItemDAO extends SuperDAO<Item,String> {
    boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception;
}
