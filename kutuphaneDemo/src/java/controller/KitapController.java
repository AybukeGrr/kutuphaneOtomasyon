/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Sevda
 */
@Named(value = "kitapController")
@SessionScoped
public class KitapController implements Serializable {

    /**
     * Creates a new instance of KitapController
     */
    public KitapController() {
    }
    
}
