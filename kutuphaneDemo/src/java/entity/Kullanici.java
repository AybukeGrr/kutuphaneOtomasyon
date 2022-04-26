/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Sevda
 */
public class Kullanici {

    private String ad;
    private String soyad;
    private String sifre;
    private String mail;
    private int kullanici_id;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public Kullanici(int kullanici_id, String ad, String soyad, String sifre, String mail) {
        this.ad = ad;
        this.soyad = soyad;
        this.sifre = sifre;
        this.mail = mail;
        this.kullanici_id = kullanici_id;
    }

    public Kullanici() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.kullanici_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kullanici other = (Kullanici) obj;
        return this.kullanici_id == other.kullanici_id;
    }

}
