package service;

import database.ConnectDB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;

public class HistoryKeyService {

    public static void insertKey(String publickey,String idUser) {
        PreparedStatement ps = null;
        try {
            String sql = "insert into `history_key`values (?,?,?,?)";
            ps = ConnectDB.connect(sql);
            Random rd = new Random();
            int id = rd.nextInt(1000000000) + rd.nextInt(1000000);
            ps.setInt(1, id);
            ps.setString(2, publickey);
            ps.setString(3, idUser);
            ps.setDate(4, Date.valueOf(java.time.LocalDate.now()));
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

    }
    public static boolean updateExpireDate(int id) {
        PreparedStatement preSta = null;
        Random rd = new Random();
        try {
            String sql = "UPDATE `public_key` set createAt=? where id = ?";
            preSta = ConnectDB.connect(sql);
            preSta.setDate(1, Date.valueOf(LocalDate.now()));
            preSta.setInt(2, id);
           int rs = preSta.executeUpdate();
            preSta.close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
//        insertKey("aldsfblasdf");
//        updateExpireDate(625831059);
    }

}
