/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DosyaDAO;
import entity.Dosya;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

/**
 *
 * @author 90553 
 */
@Named(value = "dosyaController")
@SessionScoped
public class DosyaBean implements Serializable{
    
    private Dosya dosya;
    private List<Dosya> dosyaList;
    private DosyaDAO dosyaDao;
    
    private Part doc;
    
    private String uploadTo = "C:/Users/Sevda/Desktop/upload/";
    
    public void upload(){
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo+doc.getSubmittedFileName());
            Files.copy(input, f.toPath());
            
            dosya = this.getDosya();
            dosya.setDosyaYolu(f.getParent());
            dosya.setDosyaAdi(f.getName());
            dosya.setDosyaTipi(doc.getContentType());
            
            this.getDosyaDao().create(dosya);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Dosya getDosya() {
        if(this.dosya == null){
            this.dosya = new Dosya();
        }
        return dosya;
    }

    public void setDosya(Dosya dosya) {
        this.dosya = dosya;
    }

    public List<Dosya> getDosyaList() {
        this.dosyaList  = this.getDosyaDao().findAll(); 
        return dosyaList;
    }

    public void setDosyaList(List<Dosya> dosyaList) {
        this.dosyaList = dosyaList;
    }

    public DosyaDAO getDosyaDao() {
        if(this.dosyaDao == null){
            this.dosyaDao = new DosyaDAO ();
        }
        return dosyaDao;
    }

    public void setDosyaDao(DosyaDAO dosyaDao) {
        this.dosyaDao = dosyaDao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    
    
    
}
