package service;

import bean.Order;
import bean.OrderDetail;
import bean.Product;
import bean.User;
import controller.UpdateOrder;
import database.ConnectDB;
import tool.DSA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderDetailService {
    public static List<OrderDetail> getDetailOrder(String id) {
        PreparedStatement s = null;
        try {
            String sql = "SELECT o.id_product,o.id_order,p.`name`,p.price-p.price*(p.sale/100),o.quantity,o.totalPrice\n" +
                    "                    FROM products p join order_detail o on p.id=o.id_product\n" +
                    "                    WHERE o.id_order=?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();
            List<OrderDetail> listDetailOrders = new LinkedList<>();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6));
                listDetailOrders.add(orderDetail);
            }
            rs.close();
            s.close();
            return listDetailOrders;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }
    }

    public static List<OrderDetail> historyBuy(String id) {
        PreparedStatement s = null;
        try {
            String sql = "SELECT o.id_product,o.id_order,p.`name`,p.price-p.price*(p.sale/100),o.quantity,o.totalPrice\n" +
                    "FROM products p join order_detail o on p.id=o.id_product JOIN `order` d on o.id_order=d.id \n" +
                    "WHERE d.id_user=?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();
            List<OrderDetail> listOrder = new LinkedList<>();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6));
                listOrder.add(orderDetail);
            }
            rs.close();
            s.close();
            return listOrder;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return new LinkedList<>();
        }
    }

    public static void updateStatus(String id) {
        PreparedStatement s = null;
        try {
            String sql = "update `order` set status = 1 where id = ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            int rs = s.executeUpdate();
            s.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void cancelOrder(String id) {
        PreparedStatement s = null;
        try {
            String sql = "update `order` set status = 2 where id = ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            int rs = s.executeUpdate();
            s.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public static String getIdOrder() {
        PreparedStatement ps = null;
        try {
            String sql = "select * from `order` ";
            ps = ConnectDB.connect(sql);
            ResultSet rs = ps.executeQuery();
            rs.last();
            String id = rs.getString(1);
            rs.close();
            ps.close();
            return id;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    public static void insertOrderDetail(List<Product> p, String idOrder) {
        PreparedStatement ps = null;
        try {
            String sql = "insert into order_detail values (?,?,?,?)";
            ps = ConnectDB.connect(sql);

            for (int i = 0; i < p.size(); i++) {
                Product product = p.get(i);
                ps.setString(1, product.getProductID());
                ps.setString(2, idOrder);
                ps.setInt(3, product.getQuantityCart());
                ps.setInt(4, ((int) (product.getPriceAfterSale() * product.getQuantityCart())));
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    public static void deleteOrderDetail(String id) {
        PreparedStatement s = null;
        try {
            String sql = "DELETE  from order_detail where id_order = ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            int rs = s.executeUpdate();
            s.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteHistory(String id) {
        PreparedStatement s = null;
        try {
            String sql = "DELETE  from order_detail where id_product = ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            int rs = s.executeUpdate();
            s.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
//
        DSA dsa = new DSA();
//        List<Order> list= OrderService.getAllOrder();
//        for (Order o: list){
//            o.setOrderDetails(getDetailOrder(o.getOrderID()));
//        }
//        for (Order o : list){
//            System.out.println(o.toString());
//        }
        Order order = OrderService.getOrder("order450988267697304");
//        User user = UserService.getByIdUser("user40906798262");
        order.setOrderDetails(getDetailOrder("order450988267697304"));
        System.out.println(order.getDataToSign());
//        order.setSignature(dsa.encodeToBase64(dsa.signData(order.getDataToSign(), dsa.stringToPrivateKey("MIIBSwIBADCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoEFgIUHG17oxZ/PqtBe5KIihzX4VuUtLs="))));
//        System.out.println(order.getSignature());
        System.out.println(dsa.verifySignature(order.getDataToSign(), dsa.decodeFromBase64(order.getSignature()), dsa.stringToPublicKey("MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYQAAoGAA5627DRZhlH7rnoNDpzGJjDl8HQTT12j0TsRfi0bpKA0T6IzBnQYzPYVQz2KAnXDSMYQqR8pLOPyLCrOjtd6mc+etbPeLKnlDoYQIYxCme8QmlLVoEwb6t9FjRFU3sX3cEeCd/6JoADAkM8eor1qpeqDgWBc2QSeVnbu3Xa5qGk=")));   //order105426654396020user92041998898binhduong1848000981722033quanghuy0029a@gmail.comnullnullsp009G?ch th? TA0312M1848001184800
        //order5307477933771user92041998898adsfasd240000+84981722033quanghuy0029a@gmail.comnullnullsp003Baked brick2400001240000
    }
}
