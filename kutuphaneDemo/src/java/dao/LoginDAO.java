/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Users;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author 90553
 */
public class LoginDAO extends DBConnection {
   public Users findByID(int id) {
        Users c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from users where id=" + id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = (new Users(rs.getInt("id"), rs.getString("username"), rs.getString("paswords")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;

    }

    public void createUsers(Users c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into users(username,pasword) values('" + c.getUsername() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Users c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from users where id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Users c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update users set username='" + c.getUsername()+ "',pasword='" + c.getPasword()+ "' where id=" + c.getId();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Users> getUsersList() {
        List<Users> usersList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from users";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                usersList.add(new Users(rs.getInt("id"), rs.getString("username"), rs.getString("pasword")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usersList;
    }
}
