/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KategoriDAO;
import entity.Kategori;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author 90553
 */
@FacesConverter("kategoriConverter")
public class KategoriConverter implements Converter {

    private KategoriDAO kategoriDao;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
        int id = Integer.valueOf(string);
        Kategori k = this.getKategoriDao().findById(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object t) {
        Kategori k = (Kategori) t;
        return String.valueOf(k.getKategori_id());
    }

    public KategoriDAO getKategoriDao() {
        if (kategoriDao == null) {
            this.kategoriDao = new KategoriDAO();
        }
        return kategoriDao;
    }

    public void setKategoriDao(KategoriDAO kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

}
