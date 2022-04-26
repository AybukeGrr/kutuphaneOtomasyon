/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Users;
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
     private Users user;

    public LoginController() {
        
        
    }

    public void login(){
        if(user.getUsername().equals("test") && user.getPasword().equals("123")){ // bu durumda izin verilir yani oturuma eklenir.
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", user);
        }else{ //bu durumda izin verilmez
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Username or Password is wrong!"));
        }
    }

    public Users getUser() {
          if(user==null){
            this.user=new Users();
        }
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
