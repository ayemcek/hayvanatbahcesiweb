 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EtkinlikDao;
import dao.HaberDao;
import entity.Etkinlik;
import entity.Haber;
import entity.Haber;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Enes
 */
@Named
@SessionScoped
public class HaberController implements Serializable {
    private Haber haber;
    private List<Haber> haberList;
    private HaberDao haberDao;
    
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
        this.pageCount=(int) Math.ceil(this.getHaberDao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
   
    private List<Etkinlik> etkinlikList;
    private EtkinlikDao etkinlikDao;
   
     
     
     public void delete(){
         this.getHaberDao().remove(this.haber);
        this.clearForm();
     }
     
     public void clearForm(){
         this.haber=new Haber();
     }
     public void update(){
          this.getHaberDao().edit(this.haber);
           this.clearForm();
     }
     
     public void updateForm(Haber h){
         this.haber=h;
        
     }
     
     public void create(){
         this.getHaberDao().create(this.haber);
          this.clearForm();
     }
     
    public Haber getHaber() {
        if(this.haber==null){
            this.haber=new Haber();
        }
        return haber;
    }

    public void setHaber(Haber haber) {
        this.haber = haber;
    }

    public List<Haber> getHaberList() {
        this.haberList=this.getHaberDao().findAll(page, pageSize);
        return haberList;
    }

    public void setHaberList(List<Haber> haberList) {
        this.haberList = haberList;
    }

    public HaberDao getHaberDao() {
        if(this.haberDao==null){
            this.haberDao=new HaberDao();
        }
        return haberDao;
    }

    public void setHaberDao(HaberDao haberDao) {
        this.haberDao = haberDao;
    }

   

    public EtkinlikDao getEtkinlikDao() {
        if(this.etkinlikDao==null){
            this.etkinlikDao= new EtkinlikDao();
        }
        return etkinlikDao;
    }

    public List<Etkinlik> getEtkinlikList() {
        this.etkinlikList=this.getEtkinlikDao().findAll(page,pageSize);
        return etkinlikList;
    }

    public void setEtkinlikList(List<Etkinlik> etkinlikList) {
        this.etkinlikList = etkinlikList;
    }
    
    
}
