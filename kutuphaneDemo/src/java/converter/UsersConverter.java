/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.LoginDAO;
import entity.Users;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author 90553
 */

@FacesConverter("usersConverter")
public class UsersConverter implements Converter{
    
    private LoginDAO loginDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) { // String nesneye dönüştürülür.
        int id= Integer.valueOf(string);
        Users c=this.getUsersDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) { // nesne Stringe dönüştürülür.
        Users c=(Users)t;
        return String.valueOf(c.getId());
        
    }

    public LoginDAO getUsersDao() {
         if(loginDao==null){
            this.loginDao=new LoginDAO();
        }   
        return loginDao;
    }

    public void setUsersDao(LoginDAO usersDao) {
        this.loginDao = usersDao;
    }
    
}
