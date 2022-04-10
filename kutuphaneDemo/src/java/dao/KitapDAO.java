/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kitap;
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
public class KitapDAO extends DBConnection {

    public void create(Kitap kitap) {
        try {
            Statement st = this.connect().createStatement();

            String query = "insert into kitaplar(kategori_id,ad,sayfaSayisi,kitapKapagi)values('" +kitap.getKategori_id() + "','" + kitap.getAd() + "','" + kitap.getSayfaSayisi() + "','" + kitap.getKitapKapagi() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Kitap kitap) {
        try {
            Statement st = this.connect().createStatement();

            String query = "update kitaplar set kategori_id='" +kitap.getKategori_id()+",ad='"+ kitap.getAd() + "',sayfasayisi='" + kitap.getSayfaSayisi()+"',kitapKapagi='"+ kitap.getKitapKapagi() +  "'where id=" + kitap.getKitap_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kitap kitap) {
        try {
            Statement st = this.connect().createStatement();

            String query = "delete from kitaplar where id=" + kitap.getKitap_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Kitap> getList() {
        List<Kitap> kitapList = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();

            String query = "Select * from kitaplar";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                kitapList.add(new Kitap(rs.getInt("id"), rs.getString("ad"), rs.getInt("sayfaSayisi"), rs.getInt("kategori_id"), rs.getString("kitapKapagi")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kitapList;
    }
}
