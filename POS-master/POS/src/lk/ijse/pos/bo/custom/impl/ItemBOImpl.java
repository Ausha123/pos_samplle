package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.model.Item;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public boolean addItem(Item item) throws Exception {
        return itemDAO.add(item);

    }

    public boolean deleteItem(String code) throws Exception {
        return itemDAO.delete(code);
    }

    public boolean updateItem(Item item) throws Exception {
        return itemDAO.update(item);
    }

    public Item searchItem(String code) throws Exception {
        return itemDAO.search(code);
    }

    public ArrayList<Item> getAllItems() throws Exception {
        return itemDAO.getAll();
    }

    public boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception {
        return itemDAO.updateItemQtyOnHand(code, qtyOnHand);
    }
}
