package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.model.Item;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public boolean addItem(ItemDTO item) throws Exception {
        return itemDAO.add(new Item(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));

    }

    public boolean deleteItem(String code) throws Exception {
        return itemDAO.delete(code);
    }

    public boolean updateItem(ItemDTO item) throws Exception {
        return itemDAO.update(new Item(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
    }

    public ItemDTO searchItem(String code) throws Exception {
        Item search = itemDAO.search(code);
        return new ItemDTO(search.getCode(),search.getDescription(),search.getUnitPrice(),search.getQtyOnHand());
    }

    public ArrayList<ItemDTO> getAllItems() throws Exception {
        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        for (Item item : all) {
            allItems.add(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
        }
        return allItems;
    }



    public boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception {
        return itemDAO.updateItemQtyOnHand(code, qtyOnHand);
    }
}
