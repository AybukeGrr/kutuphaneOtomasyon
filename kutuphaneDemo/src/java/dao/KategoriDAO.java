/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategori;
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
public class KategoriDAO extends DBConnection {

    public void create(Kategori kategori) {
        try {
            Statement st = this.connect().createStatement();

            String query = "insert into kategoriler(ad)values('" + kategori.getAd() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Kategori kategori) {
        try {
            Statement st = this.connect().createStatement();

            String query = "update kategoriler set('" + kategori.getAd() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Kategori kategori) {
        try {
            Statement st = this.connect().createStatement();

            String query = "delete from kategoriler where id='" + kategori.getKategori_id() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Kategori> getList() {
        List<Kategori> kategoriList = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();

            String query = "Select * from kategoriler";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                kategoriList.add(new Kategori(rs.getInt("id"), rs.getString("ad")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return kategoriList;
    }
}
