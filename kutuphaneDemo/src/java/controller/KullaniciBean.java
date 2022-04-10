/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.enterprise.context.Dependent;

import java.util.List;

/**
 *
 * @author Sevda
 */
@Named(value = "kullaniciController")
@SessionScoped
public class KullaniciBean implements Serializable {

    private Kullanici entity;
    private KullaniciDAO dao;
    private List<Kullanici> list;

    public KullaniciBean() {

    }

    public String getTitle(int id) {
        Kullanici c = this.getDao().findById(id);
        return null;
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Kullanici();
    }

    public void entityUpdate(Kullanici k) {
        this.entity = k;
    }

    public void delete(Kullanici kullanici) {
        this.getDao().delete(kullanici);
        entity = new Kullanici();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kullanici();
    }

    public Kullanici getEntity() {
        if (entity == null) {
            entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
        this.entity = entity;
    }

    public KullaniciDAO getDao() {
        if (this.dao == null) {
            this.dao = new KullaniciDAO();
        }
        return dao;
    }

    public void setDao(KullaniciDAO dao) {
        this.dao = dao;
    }

    public List<Kullanici> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kullanici> list) {
        this.list = list;
    }

}
