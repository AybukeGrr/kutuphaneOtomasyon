/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Sevda
 */
public class Yazar {

    private int yazar_id;
    @NotNull(message = "Yazar ismi bos olmaz.")
    private String ad;
    @NotNull(message = "Yazar ismi bos olmaz.")
    private String soyad;

    public Yazar() {
    }

    public Yazar(int yazar_id, String ad, String soyad) {
        this.yazar_id = yazar_id;
        this.ad = ad;
        this.soyad = soyad;
    }

    public int getYazar_id() {
        return yazar_id;
    }

    public void setYazar_id(int yazar_id) {
        this.yazar_id = yazar_id;
    }

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

}
