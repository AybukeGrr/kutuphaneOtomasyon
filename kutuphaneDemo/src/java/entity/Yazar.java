/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.validation.constraints.NotNull;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.yazar_id;
        hash = 89 * hash + Objects.hashCode(this.ad);
        hash = 89 * hash + Objects.hashCode(this.soyad);
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
        final Yazar other = (Yazar) obj;
        if (this.yazar_id != other.yazar_id) {
            return false;
        }
        if (!Objects.equals(this.ad, other.ad)) {
            return false;
        }
        return Objects.equals(this.soyad, other.soyad);
    }
    
    

}
