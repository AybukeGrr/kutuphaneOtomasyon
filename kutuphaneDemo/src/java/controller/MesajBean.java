/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.MesajDAO;
import entity.Mesaj;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Sevda
 */
@Named(value = "mesajController")
@SessionScoped
public class MesajBean implements Serializable {

    private Mesaj entity;
    private MesajDAO dao;
    private List<Mesaj> list;

    public MesajBean() {
    }
    
    public String getTitle(int id){
        Mesaj c = this.getDao().findById(id);
        return null;
    }

    public void create() {
        
        this.getDao().create(entity);
        entity = new Mesaj();
    }

    public void delete(Mesaj mesaj) {
        this.getDao().delete(mesaj);
        entity = new Mesaj();
    }
   public void entityUpdate(Mesaj k) {
        this.entity = k;
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Mesaj();
    }
    
    public Mesaj getEntity() {
        if (entity == null) {
            entity = new Mesaj();
        }
        return entity;
    }

    public void setEntity(Mesaj entity) {
        this.entity = entity;
    }

    public MesajDAO getDao() {
        if (dao == null) {
            dao = new MesajDAO();
        }
        return dao;
    }

    public void setDao(MesajDAO dao) {
        this.dao = dao;
    }

    public List<Mesaj> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Mesaj> list) {
        this.list = list;
    }
    
    

}
