/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.security.Timestamp;

/**
 *
 * @author Sevda
 */
public class Kategori {

    private int kategori_id;
    private String ad;

    public Kategori(int kategori_id, String ad) {
        this.kategori_id = kategori_id;
        this.ad = ad;
    }

    public Kategori() {
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Kategori{" + "kategori_id=" + kategori_id + ", ad=" + ad + '}';
    }

    

    
    
    
}
