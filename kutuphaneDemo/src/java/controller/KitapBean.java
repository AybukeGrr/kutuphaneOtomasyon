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
import static java.nio.file.Files.size;
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
        this.getDao().create(this.entity);
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
        this.list = this.getDao().getList(page, pageSize, 0);
        return list;
    }

    public void setList(List<Kitap> list) {
        this.list = list;
    }

}
