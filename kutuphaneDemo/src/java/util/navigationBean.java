/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named(value = "navigationBean")
@RequestScoped
public class navigationBean implements Serializable {

    public String page(String p) {
        return "/admin/module/" + p + "/" + p + "?faces-redirect=true";

    }

    public String subPage(String page, String sub) {
        return "/admin/module/" + page + "/" + sub + "/" + sub + ".xhtml?faces-redirect=true";

    }
}
