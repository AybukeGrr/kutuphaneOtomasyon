/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DocumentDAO;
import entity.Document;
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
@Named(value = "documentController")
@SessionScoped
public class DocumentBean implements Serializable{
    
    private Document document;
    private List<Document> documentList;
    private DocumentDAO documentDao;
    
    private Part doc;
    
    private String uploadTo = "/Users/90553/Desktop/upload/";
    
    public void upload(){
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo+doc.getSubmittedFileName());
            Files.copy(input, f.toPath());
            
            document = this.getDocument();
            document.setDosyaYolu(f.getParent());
            document.setDosyaAdi(f.getName());
            document.setDosyaTipi(doc.getContentType());
            
            this.getDocumentDao().insert(document);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Document getDocument() {
        if(this.document == null){
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        this.documentList  = this.getDocumentDao().findAll(); 
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentDAO getDocumentDao() {
        if(this.documentDao == null){
            this.documentDao = new DocumentDAO ();
        }
        return documentDao;
    }

    public void setDocumentDao(DocumentDAO documentDao) {
        this.documentDao = documentDao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
    
    
    
}
