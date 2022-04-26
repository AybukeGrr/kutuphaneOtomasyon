/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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

@Named(value="lc")
@SessionScoped
public class LoginController implements Serializable{
     private Kullanici kullanici;

    public LoginController() {
        
        
    }

    public void login(){
        if(kullanici.getAd().equals("test") && kullanici.getSifre().equals("123")){ // bu durumda izin verilir yani oturuma eklenir.
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", kullanici);
        }else{ //bu durumda izin verilmez
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Username or Password is wrong!"));
        }
    }

    public Kullanici getKullanici() {
          if(kullanici==null){
            this.kullanici=new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici user) {
        this.kullanici = user;
    }
}
