/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Sevda
 */
import java.util.Date;

public class Mesaj {

    private int mesaj_id;
    private String mesaj;
    private Kullanici kullanici;
    private String atilmaTarihi;

    public Mesaj() {
    }

    public Mesaj(int mesaj_id, String mesaj, Kullanici kullanici, String atilmaTarihi) {
        this.mesaj_id = mesaj_id;
        this.mesaj = mesaj;
        this.kullanici = kullanici;
        this.atilmaTarihi = atilmaTarihi;
    }

    public int getMesaj_id() {
        return mesaj_id;
    }

    public void setMesaj_id(int mesaj_id) {
        this.mesaj_id = mesaj_id;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getAtilmaTarihi() {
        return atilmaTarihi;
    }

    public void setAtilmaTarihi(String atilmaTarihi) {
        this.atilmaTarihi = atilmaTarihi;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

}
