/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author 90553
 */
@Named(value = "lc")
@SessionScoped
public class LoginController implements Serializable {

    private Kullanici kullanici;
    private KullaniciDAO kullaniciDAO;

    public LoginController() {

    }

    public String login() {
        Kullanici loginKullanici = this.getKullaniciByMail(this.kullanici.getMail());
        if (loginKullanici != null) {
            if (kullanici.getMail().equals(loginKullanici.getMail()) && kullanici.getSifre().equals(loginKullanici.getSifre())) {
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", loginKullanici);
                return "/admin/index.xhtml?faces-redirect=true";
            }
 
        } else {  
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username or Password is wrong!"));
            
        }
        return "/login.xhtml?faces-redirect=true";
    }

    private Kullanici getKullaniciByMail(String kullaniciMail) {
        Kullanici loginKullanici = this.getKullaniciDAO().findByMail(kullaniciMail);
        if (loginKullanici != null) {
            return loginKullanici;
        }
        return null;
    }

    public Kullanici getKullanici() {
        if (kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici user) {
        this.kullanici = user;
    }

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

}
