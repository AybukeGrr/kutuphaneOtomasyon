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
import java.util.Date;

public class KitapOduncAlma {

    private int oduncAlma_id;
    private int oduncAlanKisi_id;
    private int oduncAlınanKitap_id;
    private Date iadeTarihi;

    public KitapOduncAlma(int oduncAlma_id, int oduncAlanKisi_id, int oduncAlınanKitap_id, Date iadeTarihi) {
        this.oduncAlma_id = oduncAlma_id;
        this.oduncAlanKisi_id = oduncAlanKisi_id;
        this.oduncAlınanKitap_id = oduncAlınanKitap_id;
        this.iadeTarihi = iadeTarihi;
    }

    public KitapOduncAlma() {
    }

    public int getOduncAlma_id() {
        return oduncAlma_id;
    }

    public void setOduncAlma_id(int oduncAlma_id) {
        this.oduncAlma_id = oduncAlma_id;
    }

    public int getOduncAlanKisi_id() {
        return oduncAlanKisi_id;
    }

    public void setOduncAlanKisi_id(int oduncAlanKisi_id) {
        this.oduncAlanKisi_id = oduncAlanKisi_id;
    }

    public int getOduncAlınanKitap_id() {
        return oduncAlınanKitap_id;
    }

    public void setOduncAlınanKitap_id(int oduncAlınanKitap_id) {
        this.oduncAlınanKitap_id = oduncAlınanKitap_id;
    }

    public Date getIadeTarihi() {
        return iadeTarihi;
    }

    public void setIadeTarihi(Date iadeTarihi) {
        this.iadeTarihi = iadeTarihi;
    }
    
    
}
