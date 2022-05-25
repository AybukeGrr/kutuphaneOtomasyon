 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Dosya;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import util.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 90553
 */
public class DosyaDAO {
    public List <Dosya> findAll(){
        List<Dosya> dList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from dosya");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
            Dosya d = new Dosya();
            d.setId(rs.getLong("id"));
            d.setDosyaAdi(rs.getString("ad"));
            d.setDosyaTipi(rs.getString("tip"));
            d.setDosyaYolu(rs.getString("yol"));
            dList.add(d);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }       
        return dList; 
    }
    
    public void insert(Dosya d) throws SQLException{
        String query = "insert into dosya (ad, tip, yol) values (?,?,?)";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getDosyaAdi());
            pst.setString(2, d.getDosyaTipi());
            pst.setString(3, d.getDosyaYolu());
            pst.executeUpdate();
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    
    }

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


 }
