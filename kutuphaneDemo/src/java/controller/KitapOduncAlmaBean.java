/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KitapOduncAlmaDAO;
import entity.KitapOduncAlma;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sevda
 */
@Named(value = "kitapOduncAlmaController")
@SessionScoped
public class KitapOduncAlmaBean implements Serializable {

    private KitapOduncAlma entity;
    private KitapOduncAlmaDAO dao;
    private List<KitapOduncAlma> list;

    public KitapOduncAlmaBean() {
    }

    public String getTitle(int id) {
        KitapOduncAlma c = this.getDao().findById(id);
        return null;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new KitapOduncAlma();
    }

    public void delete(KitapOduncAlma kitapOduncAlma) {
        this.getDao().delete(kitapOduncAlma);
        entity = new KitapOduncAlma();
    }

    public void entityUpdate(KitapOduncAlma k) {
        this.entity = k;
    }

    public void update() {
        this.getDao().update(entity);
        entity = new KitapOduncAlma();
    }

    public KitapOduncAlma getEntity() {
        if (entity == null) {
            entity = new KitapOduncAlma();
        }
        return entity;
    }

    public void setEntity(KitapOduncAlma entity) {
        this.entity = entity;
    }

    public KitapOduncAlmaDAO getDao() {
        if (dao == null) {
            dao = new KitapOduncAlmaDAO();
        }
        return dao;
    }

    public void setDao(KitapOduncAlmaDAO dao) {
        this.dao = dao;
    }

    public List<KitapOduncAlma> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<KitapOduncAlma> list) {
        this.list = list;
    }

}
