/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Sevda
 */
public class Kitap {

    private int kitap_id;
    private String ad;
    private int sayfaSayisi;
    private int kategori_id;
    private String kitapKapagi;

    public Kitap(int kitap_id, String ad, int sayfaSayisi, int kategori_id, String kitapKapagi) {
        this.kitap_id = kitap_id;
        this.ad = ad;
        this.sayfaSayisi = sayfaSayisi;
        this.kategori_id = kategori_id;
        this.kitapKapagi = kitapKapagi;
    }

    public Kitap() {
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

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getKitapKapagi() {
        return kitapKapagi;
    }

    public void setKitapKapagi(String kitapKapagi) {
        this.kitapKapagi = kitapKapagi;
    }
}
