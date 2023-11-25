package service;

import bean.Order;
import bean.OrderDetail;
import bean.Product;
import database.ConnectDB;

import java.sql.*;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class OrderService {
    public static List<Order> getAllOrder() {
        List<Order> listOrder = new LinkedList<>();
            PreparedStatement pState = null;
            String sql = "SELECT * FROM `order` ";
        try {
            pState = ConnectDB.connect(sql);
            ResultSet rs = pState.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11));
                listOrder.add(order);
            }
            rs.close();
            pState.close();

        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();

        }
        return listOrder;
    }
    public static Order getOrder(String id) {
         Order order = null;
        PreparedStatement pState = null;
        String sql = "SELECT * FROM `order` where id =? ";
        try {
            pState = ConnectDB.connect(sql);
            pState.setString(1, id);
            ResultSet rs = pState.executeQuery();
            if (rs.next()) {
                 order = new Order(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                         rs.getString(11));
            }
            rs.close();
            pState.close();

        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();

        }
        return order;
    }
    public static List<OrderDetail> getOrderNotDeliver(String id) {
            PreparedStatement s = null;
            try {
                String sql = "SELECT o.id_product,o.id_order,p.`name`,p.price-p.price*(p.sale/100),o.quantity,o.totalPrice FROM products p join order_detail o on p.id=o.id_product JOIN `order` d on o.id_order=d.id WHERE d.id_user=? AND d.`status`=?;";
                s = ConnectDB.connect(sql);
                s.setString(1, id);
                s.setInt(2, 0);
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
    public static String getSignature(String idOder) {
        PreparedStatement s = null;
        String signature ="";
        try {
            String sql = "SELECT signature FROM `order` WHERE id=?;";
            s = ConnectDB.connect(sql);
            s.setString(1, idOder);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                signature = rs.getString(1);

            }
            rs.close();
            s.close();
            return signature;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void insertOrder(Order order){
        PreparedStatement ps = null;
        try{
            String sql = "insert into `order`values (?,?,?,?,?,?,?,?,?,?,?)";
            ps = ConnectDB.connect(sql);
            ps.setString(1, order.getOrderID());
            ps.setString(2, order.getUserID());
            ps.setString(3, order.getFullName());
            ps.setInt(4, order.getTotalPrice());
            ps.setString(5, order.getAddress());
            ps.setString(6, order.getPhone());
            ps.setString(7, order.getEmail());
            ps.setInt(8, order.getStatus());
            ps.setString(9, order.getCreateDate());
            ps.setString(10,order.getUpdateDate());
            ps.setString(11, null);
            ps.executeUpdate();
            ps.close();

        }

        catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

    }


    public static void updateSignature(String id,String signature){
        PreparedStatement s = null;
        try {
            String sql = "update `order` set signature = ? where id = ?";
            s = ConnectDB.connect(sql);


            // Đặt giá trị Blob vào câu lệnh SQL
            s.setString(1, signature);
            s.setString(2, id);
            int rs = s.executeUpdate();
            s.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteOrder(String id){
        PreparedStatement s = null;
        try {
            String sql = "DELETE from `order` WHERE id = ?";
            s = ConnectDB.connect(sql);
            s.setString(1,id);
            int rs = s.executeUpdate();
            s.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static int countOrder() {
        PreparedStatement pre = null;
        int count=0;
        try {
            String sql = "SELECT * FROM `order`";
            pre = ConnectDB.connect(sql);
            ResultSet rs = pre.executeQuery();
            rs.last();
            count = rs.getRow();
            return count;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
//        deleteOrder("1324653113234");
        Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
        String timeRegister = String.valueOf(timestamp);
        Order order = new Order("uidahf","user32915610645","unaghuy",45554545,"binhduong","134910843","@gmail",0,timeRegister,timeRegister);
        insertOrder(order);
//        System.out.println(getOrder("order308026691231982").toString());
//        System.out.println(Base64.getEncoder().encodeToString(getSignature("order308026691231982")));
    }
}
