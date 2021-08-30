package lk.ijse.pos.dao.custom;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public interface ItemDAO {
    public boolean addItem(Item item) throws Exception;

    public boolean updateItem(Item item) throws Exception;


    public boolean updateItemQtyOnHand(String code,int qtyOnHand) throws Exception;


    public boolean deleteItem(String code) throws Exception;



    public Item searchItem(String code) throws Exception;



    public ArrayList<Item> getAllItems() throws Exception;

}
