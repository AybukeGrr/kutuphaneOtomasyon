/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KitapDAO;
import entity.Kitap;
import entity.Yazar;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sevda
 */
@Named(value = "kitapController")
@SessionScoped
public class KitapBean implements Serializable {

    private Kitap entity;
    private KitapDAO dao;
    private List<Kitap> list;

    public KitapBean() {
    }

    public String getTitle(int id) {
        Kitap c = this.getDao().findById(id);
        return null;
    }

    public void clear() {
        this.entity = new Kitap();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Kitap();
    }

    public void delete(Kitap kitap) {
        this.getDao().delete(kitap);
        entity = new Kitap();
    }

    public void entityUpdate(Kitap k) {
        this.entity = k;
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kitap();
    }

    public Kitap getEntity() {
        if (entity == null) {
            entity = new Kitap();
        }
        return entity;
    }

    public void setEntity(Kitap entity) {
        this.entity = entity;
    }

    public KitapDAO getDao() {
        if (dao == null) {
            dao = new KitapDAO();
        }
        return dao;
    }

    public void setDao(KitapDAO dao) {
        this.dao = dao;
    }

    public List<Kitap> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kitap> list) {
        this.list = list;
    }

}
