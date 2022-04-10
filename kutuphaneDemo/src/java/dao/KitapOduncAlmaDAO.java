/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.KitapOduncAlma;
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

    public void create(KitapOduncAlma odunc) {
        try {
            Statement st = this.connect().createStatement();

            String query = "insert into KitapOduncAlma(oduncAlanKisi_id,oduncAlınanKitap_id,iadeTarihi)values('" + odunc.getOduncAlanKisi_id() + "','" + odunc.getOduncAlınanKitap_id() + "','" + odunc.getIadeTarihi()+ "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(KitapOduncAlma odunc) {
        try {
            Statement st = this.connect().createStatement();

            String query = "update kitapOduncAlma set oduncAlanKisi_id='" + odunc.getOduncAlanKisi_id() + ",oduncAlınanKitap_id='" + odunc.getOduncAlınanKitap_id() + "',iadeTarihi='" + odunc.getIadeTarihi() + "'where id=" + odunc.getOduncAlma_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(KitapOduncAlma odunc) {
        try {
            Statement st = this.connect().createStatement();

            String query = "delete from kitapOduncAlma where id=" + odunc.getOduncAlma_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<KitapOduncAlma> getList() {
        List<KitapOduncAlma> oduncList = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();

            String query = "Select * from kitapOduncAlma";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                oduncList.add(new KitapOduncAlma(rs.getInt("oduncAlma_id "), rs.getInt("oduncAlanKisi_id"), rs.getInt("oduncAlınanKitap_id"),rs.getTimestamp("iadeTarihi")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return oduncList;
    }
}
