/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KategoriDAO;
import entity.Kategori;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;


/**
 *
 * @author Sevda
 */
@Named(value = "kategoriController")
@SessionScoped
public class KategoriBean implements Serializable {

    private Kategori entity;
    private KategoriDAO dao;
    private List<Kategori> list;
    
     private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) this.pageSize);

        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    
    public KategoriBean() {
    }
    
    public String getTitle(int id){
        Kategori c = this.getDao().findById(id);
        return null;
    }
    
    public void create() {
        this.getDao().create(entity);  
         entity = new Kategori();
    }
    public void clear() {
        this.entity = new Kategori();
    }

    public void delete(Kategori kategori) {
        this.getDao().delete(kategori);
        entity = new Kategori();
    }
      public void entityUpdate(Kategori k) {
        this.entity = k;
    }
    public void update() {
        this.getDao().update(entity);
        entity = new Kategori();
    }

    public Kategori getEntity() {
        if (entity == null) {
            entity = new Kategori();
        }
        return entity;
    }

    public void setEntity(Kategori entity) {
        this.entity = entity;
    }

    public KategoriDAO getDao() {
        if (dao == null) {
            dao = new KategoriDAO();
        }
        return dao;
    }

    public void setDao(KategoriDAO dao) {
        this.dao = dao;
    }

    public List<Kategori> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kategori> list) {
        this.list = list;
    }
    
    
}