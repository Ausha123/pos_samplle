package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.PurchaseOrderBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.dto.OrderDetailsDTO;
import lk.ijse.pos.dto.OrdersDTO;
import lk.ijse.pos.model.Item;
import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
   // private final CustomerDAO customerDAO = new CustomerDAOImpl();
//    private final ItemDAO itemDAO = new ItemDAOImpl();
//    private final OrderDAO orderDAO = new OrderDAOImpl();
//    private final OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();


    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);


    public boolean purchaseOrder(OrdersDTO dto) throws Exception {


        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            Orders orders = new Orders(dto.getId(),dto.getDate(),dto.getCustomerId());
            boolean b1 = orderDAO.add(orders);
            if (!b1) {
                connection.rollback();
                return false;
            }

            for (OrderDetailsDTO orderDetails : dto.getOrderDetails()) {

                OrderDetails orDetails = new OrderDetails(orderDetails.getOrderId(),orderDetails.getItemCode(),orderDetails.getQty(),orderDetails.getUnitPrice());
                boolean b2 = orderDetailsDAO.add(orDetails);
                if (!b2) {
                    connection.rollback();
                    return false;
                }


                int qtyOnHand = 0;

                Item item = itemDAO.search(orderDetails.getItemCode());

                if (item != null) {
                    qtyOnHand = ((Item) item).getQtyOnHand();
                }

                boolean b = itemDAO.updateItemQtyOnHand(orderDetails.getItemCode(), qtyOnHand - orderDetails.getQty());

                if (!b) {
                    connection.rollback();
                    return false;
                }
            }

            connection.commit();
            return true;

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
//                Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex1);
                  throw  new Exception(ex1);
            }
            //Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        } catch (Exception e) {
           throw new Exception(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
//                Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
                throw  new Exception(ex);
            }
        }
    }

}