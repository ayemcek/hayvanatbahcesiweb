package entity;

import java.util.List;

/**
 *
 * @author VolkanKNC
 */
public class Hayvan {

    private Long hayvan_id;
    private String tur;
    private String cinsi;
    private String aciklama;
    
    private List<Personel> hayvanCategories;

    public Hayvan() {
    }

    public Hayvan(Long hayvan_id, String tur, String cinsi, String aciklama) {
        this.hayvan_id = hayvan_id;
        this.tur = tur;
        this.cinsi = cinsi;
        this.aciklama = aciklama;
    }

    public Long getHayvan_id() {
        return hayvan_id;
    }

    public void setHayvan_id(Long hayvan_id) {
        this.hayvan_id = hayvan_id;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getCinsi() {
        return cinsi;
    }

    public void setCinsi(String cinsi) {
        this.cinsi = cinsi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public List<Personel> getHayvanCategories() {
        return hayvanCategories;
    }

    public void setHayvanCategories(List<Personel> hayvanCategories) {
        this.hayvanCategories = hayvanCategories;
    }    

    @Override
    public String toString() {
        return "hayvan{" + hayvan_id + ", " + tur + ", " + cinsi + ", " + aciklama + '}';
    }

}
