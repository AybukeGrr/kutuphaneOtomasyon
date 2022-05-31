/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.YazarDAO;
import entity.Yazar;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.util.List;

/**
 *
 * @author 90553
 */
@FacesConverter("yazarConverter")
public class YazarConverter implements Converter {

    private YazarDAO yazarDao;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
        int id = Integer.valueOf(string);
        Yazar yazar = this.getYazarDao().findById(id);
        return yazar;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object t) {
        Yazar yazarlar = (Yazar) t;
        return String.valueOf(yazarlar.getYazar_id());
    }

    public YazarDAO getYazarDao() {
        if (yazarDao == null) {
            this.yazarDao = new YazarDAO();
        }
        return yazarDao;
    }

    public void setYazarDao(YazarDAO yazarDao) {
        this.yazarDao = yazarDao;
    }

}
