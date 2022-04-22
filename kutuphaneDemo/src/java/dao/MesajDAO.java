/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanici;
import entity.Mesaj;
import util.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 *
 * @author Sevda
 */
public class MesajDAO extends DBConnection {

    private KullaniciDAO kullaniciDao;

    public void create(Mesaj mesaj) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into mesajlar(mesajAtanKisi_id,mesaj,atilmaTarihi)values('" + mesaj.getKullanici().getKullanici_id() + "','" + mesaj.getMesaj() + "','" + mesaj.getAtilmaTarihi() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Mesaj mesaj) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update mesajlar set mesajAtanKisi_id='" + mesaj.getKullanici().getKullanici_id() + ",mesaj='" + mesaj.getMesaj() + "',atilmaTarihi='" + mesaj.getAtilmaTarihi() + "' where mesaj_id=" + mesaj.getMesaj_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Mesaj mesaj) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from mesajlar where mesaj_id=" + mesaj.getMesaj_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Mesaj> getList() {
        List<Mesaj> mesajList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();

            String query = "Select * from mesajlar";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                Kullanici k = this.getKullaniciDao().findById(rs.getInt("mesajAtanKisi_id"));

                mesajList.add(new Mesaj(rs.getInt("mesaj_id"), rs.getString("mesaj"),
                        k, rs.getString("atilmaTarihi")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mesajList;
    }

    public Mesaj findById(int id) {
        Mesaj c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from mesajlar where mesaj_id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Kullanici k = this.getKullaniciDao().findById(rs.getInt("mesajAtanKisi_id"));

                c = new Mesaj(rs.getInt("mesaj_id"), rs.getString("mesaj"),
                        k, rs.getString("atilmaTarihi"));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public KullaniciDAO getKullaniciDao() {
        if (kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

}
