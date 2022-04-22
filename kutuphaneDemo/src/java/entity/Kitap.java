/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author Sevda
 */
public class Kitap {

    private int kitap_id;
    private String ad;
    private int sayfaSayisi;
    private Kategori kategori;
    private String kitapKapagi;

    private List<Yazar> yazarlar;

    public Kitap(int kitap_id, String ad, int sayfaSayisi, Kategori kategori, String kitapKapagi, List<Yazar> yazarlar) {
        this.kitap_id = kitap_id;
        this.ad = ad;
        this.sayfaSayisi = sayfaSayisi;
        this.kategori = kategori;
        this.kitapKapagi = kitapKapagi;
        this.yazarlar = yazarlar;
    }

    public Kitap() {
    }

    public List<Yazar> getYazarlar() {
        return yazarlar;
    }

    public void setYazarlar(List<Yazar> yazarlar) {
        this.yazarlar = yazarlar;
    }

    public int getKitap_id() {
        return kitap_id;
    }

    public void setKitap_id(int kitap_id) {
        this.kitap_id = kitap_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getKitapKapagi() {
        return kitapKapagi;
    }

    public void setKitapKapagi(String kitapKapagi) {
        this.kitapKapagi = kitapKapagi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.kitap_id;
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
        final Kitap other = (Kitap) obj;
        return this.kitap_id == other.kitap_id;
    }

}
