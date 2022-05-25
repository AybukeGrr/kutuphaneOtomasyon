/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanici;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author 90553
 */
public class GirisDAO extends DBConnection {
   public Kullanici findByID(int kullanici_id) {
        Kullanici c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from kullanicilar where kullanici_id=" + kullanici_id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = (new Kullanici(rs.getInt("kullanici-id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("sifre"), rs.getString("mail")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;

    }

    public void createUsers(Kullanici c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into kullanicilar(ad,soyad,sifre,mail) values('" + c.getAd()+ "', '" + c.getSoyad()+ "', '" + c.getSifre()+ "', '" + c.getMail() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Kullanici c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from kullanicilar where kullanici_id=" + c.getKullanici_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Kullanici c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update kullanicilar set ad='" + c.getAd()+ "',soyad='" + c.getSoyad()+ "',sifre='" + c.getSifre()+ "',mail='" + c.getMail()+ "' where kullanci_id=" + c.getKullanici_id();
            int r = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Kullanici> getUsersList() {
        List<Kullanici> kullaniciList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from kullanicilar";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                kullaniciList.add(new Kullanici(rs.getInt("kullanici_id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("sifre"), rs.getString("mail")));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kullaniciList;
    }
}
