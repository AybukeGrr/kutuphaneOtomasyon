/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entity.Kullanici;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

/**
 *
 * @author 90553
 */
@Named(value = "writerManagedBean")
@RequestScoped
public class WriterManagedBean {

    @NotNull(message = "please enter User Name. It cant be null.")
    private String ad;

    @NotNull(message = "please enter User Name. It cant be null.")
    private String soyad;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    /**
     * Creates a new instance of UserManagedBean
     */
    public WriterManagedBean() {
    }

}