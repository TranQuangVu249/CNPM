package main.service;

import main.db.ConnectMysqlExample;
import main.main.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class userService {
    public static userService instance;

    public userService() {

    }

    private List<User> alluser;

    public static userService getInstance() {
        if (instance == null) {
            instance = new userService();
        }
        return instance;
    }

    public User getIF(String Uid) {
        User user = new User();
        {
            try {
                Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
                PreparedStatement a = conn.prepareStatement(
                        "SELECT ID_USer, Age , USER_NAME ,Gioi_Tinh,HEIGHT,WEIGHT FROM User WHERE ID_USer = ?");
                a.setString(1,Uid);
                ResultSet rs = a.executeQuery();
                while (rs.next()) {
                    user.setId(rs.getString(1));
                    user.setAge(rs.getInt(2));
                    user.setUserName(rs.getString(3));
                    user.setGioiTinh(rs.getInt(4));
                    user.setHeight(rs.getInt(5));
                    user.setWeight(rs.getInt(6));
                }
                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        return user;
    }
    public String  updateIF(String uid, String userName, String email, int height, int weight,int Age) {
        String rs="";
        try {
            Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
            PreparedStatement stmt = conn.prepareStatement("UPDATE User SET userName = ? , height= ? , height =?, email = ?,age=? WHERE id = ?");
            stmt.setString(1, userName);
            stmt.setInt(2, weight);
            stmt.setInt(3, height);
            stmt.setString(4, email);
            stmt.setInt(5, Age);
            stmt.setString(6, uid);
            stmt.execute();
            conn.close();
            rs="Chinh sua thanh cong";
        } catch (Exception e) {
            e.printStackTrace();
        }return rs;
    }
    public User  checkLogin(String username, String password) {
        User use = null;
        try {
            Connection conn = ConnectMysqlExample.getConnection(ConnectMysqlExample.getDbUrl(), ConnectMysqlExample.getUserName(), ConnectMysqlExample.getPASSWORD());
            // crate statement

            String query = "select acc.id_users, us.userName, us.height, us.weight,us.age ,us.role, us.gioiTinh, us.email ,us.avt ,us.registerDate FROM accounts  acc  join users us on us.id=acc.id_users WHERE acc.usename=? and acc.`password`=?";
            PreparedStatement a = conn.prepareStatement(query);
            a.setString(1, username);
            a.setString(2, password);
            ResultSet rs = a.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String userName = rs.getString(2);
                int height = rs.getInt(3);
                int weight = rs.getInt(4);
                int age = rs.getInt(5);
                int role = rs.getInt(6);
                int gioiTinh = rs.getInt(7);
                String email = rs.getString(8);
                String atv = rs.getString(9);

                use = new User(id, userName, height, weight, age, role, gioiTinh, email,atv);
                return use;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return use;
    }

    public static void main(String[] args) {
        User user = userService.getInstance().checkLogin("QuangVu", "123456");
        System.out.println(user.getAge());
    }
}
