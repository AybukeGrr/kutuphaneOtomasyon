/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KitapDAO;
import dao.KullaniciDAO;
import entity.Kitap;
import entity.Kullanici;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author 90553
 */
@FacesConverter("oduncAlmaConverter")
public class OduncAlmaConverter implements Converter {

    private KitapDAO kitapDao;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
        int id = Integer.valueOf(string);
        Kitap k = this.getKitapDao().findById(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object t) {
        Kitap k = (Kitap) t;
        return String.valueOf(k.getKitap_id());
    }

    public KitapDAO getKitapDao() {
        if (kitapDao == null) {
            this.kitapDao = new KitapDAO();
        }
        return kitapDao;
    }

    public void setKitapDao(KitapDAO kitapDao) {
        this.kitapDao = kitapDao;
    }

}
