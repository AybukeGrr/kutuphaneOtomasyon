/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanici;
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
public class KullaniciDAO extends DBConnection {

    public void create(Kullanici kullanici) {
        try {
            Statement st = this.connect().createStatement();

            String query = "insert into kullanicilar(ad,soyad,sifre,mail)values('" + kullanici.getAd() + "','" + kullanici.getSoyad() + "','" + kullanici.getSifre() + "','" + kullanici.getMail() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Kullanici kullanici) {
        try {
            Statement st = this.connect().createStatement();

            String query = "update kullanicilar set ad='" + kullanici.getAd() + ",soyad='" + kullanici.getSoyad() + "',sifre='" + kullanici.getSifre() + "',mail='" + kullanici.getMail() + "'where id=" + kullanici.getKullanici_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kullanici kullanici) {
        try {
            Statement st = this.connect().createStatement();

            String query = "delete from kullanicilar where id=" + kullanici.getKullanici_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Kullanici> getList() {
        List<Kullanici> kullaniciList = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();

            String query = "Select * from kullanicilar";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                kullaniciList.add(new Kullanici(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("sifre"), rs.getString("mail")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kullaniciList;
    }

    public Kullanici findById(int id) {
        Kullanici c = null;
        try {
            Statement st = this.connect().createStatement();
            String query = "select * from kullanicilar where id=" + id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = new Kullanici(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("sifre"), rs.getString("mail"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
