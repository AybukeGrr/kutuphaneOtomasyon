/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.LoginDAO;
import entity.Users;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 90553
 */
@Named(value = "usersBeans")
@SessionScoped
public class usersBean implements Serializable {

    public usersBean() {

    }
    
    private Users entity;
    private LoginDAO dao;
    private List<Users> list;

    public Users getEntity() {
        if (this.entity == null) {
            this.entity = new Users();
        }
        return entity;
    }

    public void setEntity(Users entity) {
        this.entity = entity;
    }

    public LoginDAO getDao() {
        if (this.dao == null) {
            this.dao = new LoginDAO();
        }
        return dao;
    }

    public void setDao(LoginDAO dao) {
        this.dao = dao;
    }

    public List<Users> getList() {
        this.list = this.getDao().getUsersList();
        return list;
    }

    public void setList(List<Users> list) {
        this.list = list;
    }

    public void createUsers() {

        this.getDao().createUsers(entity);
        this.entity = new Users();

    }

    public void delete(Users c) {
        this.getDao().delete(c);
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new Users();
    }
}
