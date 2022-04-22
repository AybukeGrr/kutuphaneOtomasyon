/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Sevda
 *
 */
public class KitapOduncAlma {

    private int oduncAlma_id;
    private Kullanici kullanici;
    private Kitap kitap;
    private String iadeTarihi;
    private String oduncAlmaTarihi;

    public KitapOduncAlma(int oduncAlma_id, Kullanici kullanici, Kitap kitap, String iadeTarihi, String oduncAlmaTarihi) {
        this.oduncAlma_id = oduncAlma_id;
        this.kullanici = kullanici;
        this.kitap = kitap;
        this.iadeTarihi = iadeTarihi;
        this.oduncAlmaTarihi = oduncAlmaTarihi;
    }

    public KitapOduncAlma() {
    }

    public int getOduncAlma_id() {
        return oduncAlma_id;
    }

    public void setOduncAlma_id(int oduncAlma_id) {
        this.oduncAlma_id = oduncAlma_id;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    public String getIadeTarihi() {
        return iadeTarihi;
    }

    public void setIadeTarihi(String iadeTarihi) {
        this.iadeTarihi = iadeTarihi;
    }

    public String getOduncAlmaTarihi() {
        return oduncAlmaTarihi;
    }

    public void setOduncAlmaTarihi(String oduncAlmaTarihi) {
        this.oduncAlmaTarihi = oduncAlmaTarihi;
    }

}
