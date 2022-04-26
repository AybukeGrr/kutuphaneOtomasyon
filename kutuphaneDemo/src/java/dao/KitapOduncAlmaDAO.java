/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kitap;
import entity.KitapOduncAlma;
import entity.Kullanici;
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
public class KitapOduncAlmaDAO extends DBConnection {

    private KullaniciDAO kullaniciDao;
    private KitapDAO kitapDao;

    public void create(KitapOduncAlma odunc) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into KitapOduncAlma(oduncAlanKisi_id,oduncAlinanKitap_id,iadeTarihi,oduncAlmaTarihi)values('" + odunc.getKullanici().getKullanici_id() + "','" + odunc.getKitap().getKitap_id() + "','" + odunc.getIadeTarihi() + "','" + odunc.getOduncAlmaTarihi() + "')";

            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(KitapOduncAlma odunc) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update kitapoduncalma set oduncalankisi_id='" + odunc.getKullanici().getKullanici_id() + "',oduncalinankitap_id='" + odunc.getKitap().getKitap_id() + "',iadetarihi='" + odunc.getIadeTarihi() + "',oduncalmatarihi='" + odunc.getOduncAlmaTarihi() + "' where oduncalma_id=" + odunc.getOduncAlma_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(KitapOduncAlma odunc) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from kitapOduncAlma where oduncalma_id=" + odunc.getOduncAlma_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<KitapOduncAlma> getList() {
        List<KitapOduncAlma> oduncList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();

            String query = "Select * from kitapOduncAlma";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Kullanici kullanici = this.getKullaniciDao().findById(rs.getInt("oduncalankisi_id"));
                Kitap kitap = this.getKitapDao().findById(rs.getInt("oduncalinankitap_id"));

                oduncList.add(new KitapOduncAlma(rs.getInt("oduncalma_id"), kullanici, kitap, rs.getString("iadetarihi"), rs.getString("oduncalmatarihi")));
            }

        } catch (Exception ex) {
            System.out.println("Ödünç Alma" + ex.getMessage());
        }
        return oduncList;
    }

    public KitapOduncAlma findById(int id) {
        KitapOduncAlma c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kitapOduncAlma where oducanAlma_id=" + id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Kullanici k = this.getKullaniciDao().findById(rs.getInt("oduncalankisi_id"));
                Kitap ktp = this.getKitapDao().findById(rs.getInt("oduncalinankitap_id"));

                c = new KitapOduncAlma(rs.getInt("oduncalma_id"), k, ktp, rs.getString("iadetarihi"), rs.getString("oduncalmatarihi"));
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

    public KitapDAO getKitapDao() {
        if (kitapDao == null) {
            this.kitapDao = new KitapDAO();
        }
        return kitapDao;
    }

    public void setKitapDao(KitapDAO kitapDao) {
        this.kitapDao = kitapDao;
    }

}
