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
    
   private int page=1;
   private int pageSize=5;
   private int pageCount;

    public void next(){
        if(this.page==this.getPageCount())
            this.page=1;
        else
        this.page++;
    }
    public void previous(){
        if(this.page==1)
            this.page=this.getPageCount();
        else
        this.page--;
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount=(int) Math.ceil(this.getEtkinlikDao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
   

    public void updateForm(Etkinlik etk){
        this.etkinlik=etk;
        
   }
    
     public void update(){
        this.getEtkinlikDao().update(this.etkinlik);
        this.etkinlik=new Etkinlik();
        
        
    }
    public void clearForm(){
        this.etkinlik=new Etkinlik();
       
          } 
    
    public String deleteConfirm(Etkinlik etk){
        this.etkinlik=etk;
        return "etkinlik_delete";
    }
  
    public String delete(){
        this.getEtkinlikDao().delete(this.etkinlik);
        this.etkinlik=new Etkinlik();
        return "etkinlik";
    }
    
    public void create(){
        this.getEtkinlikDao().insert(this.etkinlik);
        this.etkinlik=new Etkinlik();
      

    }

    
    public EtkinlikController() {
        this.etkinlikList=new ArrayList();
        etkinlikDao=new EtkinlikDao();
    }

    public List<Etkinlik> getEtkinlikList() {
        this.etkinlikList=this.getEtkinlikDao().findAll(page, pageSize);
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
