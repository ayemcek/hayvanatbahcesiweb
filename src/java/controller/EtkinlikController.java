/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EtkinlikDao;
import entity.Etkinlik;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Enes
 */
@Named
@SessionScoped
public class EtkinlikController implements Serializable{
    
    private List<Etkinlik> etkinlikList;
    private EtkinlikDao etkinlikDao;
    private Etkinlik etkinlik;
    
    public String updateForm(Etkinlik etk){
        this.etkinlik=etk;
        return"etkinlik";
   }
    
     public String update(){
        this.getEtkinlikDao().update(this.etkinlik);
        this.etkinlik=new Etkinlik();
        return "etkinlik";
        
    }
    public String clearForm(){
        this.etkinlik=new Etkinlik();
        return "etkinlik";
    } 
    
    public String deleteConfirm(Etkinlik etk){
        this.etkinlik=etk;
        return "confirm_etkinlik";
    }
  
    public String delete(){
        this.getEtkinlikDao().delete(this.etkinlik);
        this.etkinlik=new Etkinlik();
        return "etkinlik";
    }
    
    public String create(){
        this.getEtkinlikDao().insert(this.etkinlik);
        this.etkinlik=new Etkinlik();
        return"etkinlik";
    }
    
    public EtkinlikController() {
        this.etkinlikList=new ArrayList();
        etkinlikDao=new EtkinlikDao();
    }

    public List<Etkinlik> getEtkinlikList() {
        this.etkinlikList=this.getEtkinlikDao().findAll();
        return etkinlikList;
    }

    public void setEtkinlikList(List<Etkinlik> etkinlikList) {
        this.etkinlikList = etkinlikList;
    }

    public EtkinlikDao getEtkinlikDao() {
        if(this.etkinlikDao==null){
            this.etkinlikDao=new EtkinlikDao();
        }
        return etkinlikDao;
    }

    public void setEtkinlikDao(EtkinlikDao etkinlikDao) {
        this.etkinlikDao = etkinlikDao;
    }

  /* public Etkinlik getEtkinlik() {
        return etkinlik;
    }*/

   

   public Etkinlik getEtkinlik() {
    
         if(this.etkinlik==null){
           this.etkinlik=new Etkinlik(); 
       }
        return etkinlik;
    }

    public void setEtkinlik(Etkinlik etkinlik) {
        this.etkinlik = etkinlik;
    }
    
}
