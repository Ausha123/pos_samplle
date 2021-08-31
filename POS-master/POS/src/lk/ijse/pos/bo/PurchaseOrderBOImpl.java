package lk.ijse.pos.bo;

import lk.ijse.pos.controller.OrderFormController;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.dao.custom.impl.OrderDAOImpl;
import lk.ijse.pos.dao.custom.impl.OrderDetailsDAOImpl;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Item;
import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseOrderBOImpl {
   // private final CustomerDAO customerDAO = new CustomerDAOImpl();
    private final ItemDAO itemDAO = new ItemDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();

    public boolean purchaseOrder(Orders order, ArrayList<OrderDetails> orderDetails) throws Exception {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean b1 = orderDAO.add(order);
            if (!b1) {
                connection.rollback();
                return false;
            }

            for (OrderDetails orderDetail : orderDetails) {
                boolean b2 = orderDetailsDAO.add(orderDetail);
                if (!b2) {
                    connection.rollback();
                    return false;
                }


                int qtyOnHand = 0;

                Item item = itemDAO.search(orderDetail.getItemCode());

                if (item != null) {
                    qtyOnHand = ((Item) item).getQtyOnHand();
                }

                boolean b = itemDAO.updateItemQtyOnHand(orderDetail.getItemCode(), qtyOnHand - orderDetail.getQty());

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