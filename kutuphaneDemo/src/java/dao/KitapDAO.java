/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategori;
import entity.Kitap;
import entity.Yazar;
import util.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

/**
 *
 * @author Sevda
 */
public class KitapDAO extends DBConnection {

    private KategoriDAO kategoriDao;

    public void create(Kitap kitap) {

      
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into kitaplar(kategori_id,ad,sayfaSayisi,kitapKapagi)values('" + kitap.getKategori().getKategori_id() + "','" + kitap.getAd() + "','" + kitap.getSayfaSayisi() + "','" + kitap.getKitapKapagi() + "')";
            st.executeUpdate(query);

            ResultSet rs = st.executeQuery("select max(kitap_id) as mid from kitaplar");
            rs.next();

            int kitap_id = rs.getInt("mid");

            for (Yazar yazar : kitap.getYazarlar()) {
                query = "insert into yazarlar_kitaplar (yazar_id,kitap_id) values (" + yazar.getYazar_id() + " , " + kitap_id + ")";
                st.executeUpdate(query);
               
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Kitap kitap) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update kitaplar set kategori_id='" + kitap.getKategori().getKategori_id() + "',ad='" + kitap.getAd() + "',sayfasayisi='" + kitap.getSayfaSayisi() + "',kitapKapagi='" + kitap.getKitapKapagi() + "' where kitap_id=" + kitap.getKitap_id();
            st.executeUpdate(query);

            st.executeUpdate("delete from yazarlar_kitaplar where kitap_id=" + kitap.getKitap_id());

            for (Yazar yazar : kitap.getYazarlar()) {
                query = "insert into yazarlar_kitaplar (yazar_id,kitap_id) values (" + yazar.getYazar_id() + " , " + kitap.getKitap_id() + ")";
                st.executeUpdate(query);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kitap kitap) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "delete from kitaplar where kitap_id=" + kitap.getKitap_id();
            st.executeUpdate(query);

            st.executeUpdate("delete from yazarlar_kitaplar where kitap_id=" + kitap.getKitap_id());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Kitap> getList(int page, int pageSize, int siralama) {
        List<Kitap> kitapList = new ArrayList<>();

        String s = (siralama == 1) ? "asc" : "desc";
        int start = (page - 1) * pageSize;

        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from kitaplar order by kitap_id " + s + " limit " + pageSize + " OFFSET " + start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Kategori k = this.getKategoriDao().findById(rs.getInt("kategori_id"));
                kitapList.add(new Kitap(rs.getInt("kitap_id"), rs.getString("ad"), rs.getInt("sayfaSayisi"), k, rs.getString("kitapKapagi"), this.getKitapYazar(rs.getInt("kitap_id"))));

            }

        } catch (Exception ex) {
            System.out.println("kitap get list" + ex.getMessage());
        }
        return kitapList;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count(kitap_id) as kitap_count from kitaplar");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("kitap_count");
           

        } catch (Exception ex) {
            System.out.println("kitap get list" + ex.getMessage());
        }
        return count;
    }

    public List<Yazar> getKitapYazar(int kitap_id) {
        List<Yazar> yazarList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();

            String query = "Select * from yazarlar where yazar_id in(select yazar_id from yazarlar_kitaplar where kitap_id=" + kitap_id + ")";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                yazarList.add(new Yazar(rs.getInt("yazar_id"), rs.getString("ad"), rs.getString("soyad")));
            }

        } catch (Exception ex) {
            System.out.println("Kitap get yazar" + ex.getMessage());
        }
        return yazarList;
    }

    public Kitap findById(int id) {
        Kitap c = null;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kitaplar where kitap_id=" + id;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Kategori k = this.getKategoriDao().findById(rs.getInt("kategori_id"));

                c = new Kitap(rs.getInt("kitap_id"), rs.getString("ad"), rs.getInt("sayfaSayisi"), k, rs.getString("kitapKapagi"), this.getKitapYazar(rs.getInt("kitap_id")));
            }

        } catch (Exception e) {
            System.out.println("kitap findbyId" + e.getMessage());
        }
        return c;
    }

    public KategoriDAO getKategoriDao() {
        if (kategoriDao == null) {
            this.kategoriDao = new KategoriDAO();
        }
        return kategoriDao;
    }

    public void setKategoriDao(KategoriDAO kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

}
