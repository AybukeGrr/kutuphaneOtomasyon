/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Yazar;
import util.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sevda
 */
public class YazarDAO extends DBConnection {

    public void create(Yazar yazar) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into yazarlar(ad,soyad)values('" + yazar.getAd() + "','" + yazar.getSoyad() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Yazar yazar) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update yazarlar set ad='" + yazar.getAd() + "',soyad='" + yazar.getSoyad() + "' where yazar_id=" + yazar.getYazar_id();
            st.executeUpdate(query);
           

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Yazar yazar) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from yazarlar where yazar_id=" + yazar.getYazar_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Yazar> getList() {
        List<Yazar> yazarList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();

            String query = "Select * from yazarlar";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                yazarList.add(new Yazar(rs.getInt("yazar_id"), rs.getString("ad"), rs.getString("soyad")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return yazarList;
    }
    public Yazar findById(int id){
        Yazar c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from yazarlar where yazar_id="+id;
            
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                c = new Yazar(rs.getInt("yazar_id"), rs.getString("ad"), rs.getString("soyad"));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
