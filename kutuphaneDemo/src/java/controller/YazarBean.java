/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.YazarDAO;
import entity.Yazar;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sevda
 */
@Named(value = "yazarController")
@SessionScoped
public class YazarBean implements Serializable {

    private Yazar entity;
    private YazarDAO dao;
    private List<Yazar> list;
    
    public YazarBean() {
    }
    
    public String getTitle(int id){
        Yazar c = this.getDao().findById(id);
        return null;
    }
    
     public void create() {
        this.getDao().create(entity);
        entity = new Yazar();
    }

    public void delete(Yazar yazar) {
        this.getDao().delete(yazar);
        entity = new Yazar();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Yazar();
    }

    public Yazar getEntity() {
        if (entity == null) {
            entity = new Yazar();
        }
        return entity;
    }

    public void setEntity(Yazar entity) {
        this.entity = entity;
    }

    public YazarDAO getDao() {
        if (dao == null) {
            dao = new YazarDAO();
        }
        return dao;
    }

    public void setDao(YazarDAO dao) {
        this.dao = dao;
    }

    public List<Yazar> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Yazar> list) {
        this.list = list;
    }
    
    
}
