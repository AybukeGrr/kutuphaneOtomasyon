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
    private int mesajAtanKisi_id;
    private Date atilmaTarihi;

    public Mesaj() {
    }

    public Mesaj(int mesaj_id, String mesaj, int mesajAtanKisi_id, Date atilmaTarihi) {
        this.mesaj_id = mesaj_id;
        this.mesaj = mesaj;
        this.mesajAtanKisi_id = mesajAtanKisi_id;
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

    public int getMesajAtanKisi_id() {
        return mesajAtanKisi_id;
    }

    public void setMesajAtanKisi_id(int mesajAtanKisi_id) {
        this.mesajAtanKisi_id = mesajAtanKisi_id;
    }

    public Date getAtilmaTarihi() {
        return atilmaTarihi;
    }

    public void setAtilmaTarihi(Date atilmaTarihi) {
        this.atilmaTarihi = atilmaTarihi;
    }

}
