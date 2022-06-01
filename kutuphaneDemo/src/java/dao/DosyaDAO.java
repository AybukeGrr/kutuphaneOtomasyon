/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Dosya;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 90553
 */
public class DosyaDAO extends DBConnection {
    
    public List<Dosya> findAll() {
        List<Dosya> dList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from document");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Dosya d = new Dosya();
                d.setId(rs.getInt("id"));
                d.setDosyaYolu(rs.getString("yol"));
                d.setDosyaAdi(rs.getString("ad"));
                d.setDosyaTipi(rs.getString("tip"));
                dList.add(d);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }

    public void insert(Dosya d) {
        String query = "insert into document (yol,ad,tip) values(?,?,?)";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getDosyaYolu());
            pst.setString(2, d.getDosyaAdi());
            pst.setString(3, d.getDosyaTipi());
            pst.executeUpdate();

        } catch (SQLException e) {

        }

    }
    
}
