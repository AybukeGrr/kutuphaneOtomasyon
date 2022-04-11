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
    private int oduncAlanKisi_id;
    private int oduncAlinanKitap_id;
    private String iadeTarihi;
    private String oduncAlmaTarihi;

    public KitapOduncAlma(int oduncAlma_id, int oduncAlanKisi_id, int oduncAlinanKitap_id, String iadeTarihi, String oduncAlmaTarihi) {
        this.oduncAlma_id = oduncAlma_id;
        this.oduncAlanKisi_id = oduncAlanKisi_id;
        this.oduncAlinanKitap_id = oduncAlinanKitap_id;
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

    public int getOduncAlanKisi_id() {
        return oduncAlanKisi_id;
    }

    public void setOduncAlanKisi_id(int oduncAlanKisi_id) {
        this.oduncAlanKisi_id = oduncAlanKisi_id;
    }

    public int getOduncAlinanKitap_id() {
        return oduncAlinanKitap_id;
    }

    public void setOduncAlinanKitap_id(int oduncAlinanKitap_id) {
        this.oduncAlinanKitap_id = oduncAlinanKitap_id;
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
