/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PersonelDAO;
import entity.Personel;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author VolkanKNC
 */
@Named
@SessionScoped
public class PersonelController implements Serializable {
    
    private Personel personel;
    private List<Personel> personellist;
    private PersonelDAO personeldao;
    
     public void updateForm(Personel personel){
        this.personel = personel;
    }
    
    public void clearForm(){
        this.personel = new Personel();
    }
    
    public String deleteConfirm(Personel personel){
        this.personel = personel;
        return "confirm_delete_1";
    }
    
    public String delete(){
        this.getPersoneldao().delete(this.personel);
        this.personel = new Personel();
        return "personel";
    }
    
    public void update(){
        this.getPersoneldao().update(this.personel);
        this.personel = new Personel(); //BAKILACAK!!!
    }
    
    public void create(){
        this.getPersoneldao().insert(this.personel);
        this.personel = new Personel();
    }

    public Personel getPersonel() {
        if(this.personel == null)
            this.personel = new Personel();
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public List<Personel> getPersonellist() {
        this.personellist = this.getPersoneldao().findAll();
        return personellist;
    }

    public void setPersonellist(List<Personel> personellist) {
        this.personellist = personellist;
    }

    public PersonelDAO getPersoneldao() {
        if(this.personeldao == null)
            this.personeldao = new PersonelDAO();
        return personeldao;
    }

    public void setPersoneldao(PersonelDAO personeldao) {
        this.personeldao = personeldao;
    }
    
    
}
