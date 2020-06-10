package controller;

import dao.HayvanDAO;
import entity.Hayvan;
import entity.Personel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author VolkanKNC
 */
@Named
@SessionScoped
public class HayvanController implements Serializable {

    private List<Hayvan> hayvanlist;
    private HayvanDAO hayvandao;
    private Hayvan hayvan;
    
    @Inject
    private PersonelController personelController;
    
    public void updateForm(Hayvan hayvan){
        this.hayvan = hayvan;
    }
    
    public void update(){
        this.getHayvandao().update(this.hayvan);
        this.clearForm();
    }
    
    public void delete(){
        this.getHayvandao().delete(this.hayvan);
        this.clearForm();
    }
    
    public void create(){
        this.getHayvandao().create(this.hayvan);
        this.clearForm();
    }
    
    public void clearForm(){
        this.hayvan = new Hayvan();
    }

    public List<Hayvan> getHayvanlist() {
        this.hayvanlist = this.getHayvandao().findAll();
        return hayvanlist;
    }

    public void setHayvanlist(List<Hayvan> hayvanlist) {
        this.hayvanlist = hayvanlist;
    }

    public HayvanDAO getHayvandao() {
        if (this.hayvandao == null)
            this.hayvandao = new HayvanDAO();
        return hayvandao;
    }

    public void setHayvandao(HayvanDAO hayvandao) {
        this.hayvandao = hayvandao;
    }

    public Hayvan getHayvan() {
        if (this.hayvan == null)
            this.hayvan = new Hayvan();
        return hayvan;
    }

    public void setHayvan(Hayvan hayvan) {
        this.hayvan = hayvan;
    }

    public PersonelController getPersonelController() {
        return personelController;
    }

    public void setPersonelController(PersonelController personelController) {
        this.personelController = personelController;
    }

    
}
