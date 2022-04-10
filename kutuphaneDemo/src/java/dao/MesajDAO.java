/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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

    public void create(Mesaj mesaj) {
        try {
            Statement st = this.connect().createStatement();

            String query = "insert into mesajlar(mesajAtanKisi_id,mesaj,atilmaTarihi)values('" + mesaj.getMesajAtanKisi_id()+ "','" + mesaj.getMesaj() + "','" + mesaj.getAtilmaTarihi()+ "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Mesaj mesaj) {
        try {
            Statement st = this.connect().createStatement();

            String query = "update mesajlar set mesajAtanKisi_id='" + mesaj.getMesajAtanKisi_id() + ",mesaj='" + mesaj.getMesaj() + "',atilmaTarihi='" + mesaj.getAtilmaTarihi()  + "'where id=" + mesaj.getMesaj_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Mesaj mesaj) {
        try {
            Statement st = this.connect().createStatement();

            String query = "delete from mesajlar where id=" + mesaj.getMesaj_id();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Mesaj> getList() {
        List<Mesaj> mesajList = new ArrayList<>();

        try {
            Statement st = this.connect().createStatement();

            String query = "Select * from mesajlar";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                mesajList.add(new Mesaj(rs.getInt("mesaj_id"), rs.getString("mesaj"), rs.getInt("mesajAtanKisi_id"), rs.getTimestamp("atilmaTarihi")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mesajList;
    }
}
