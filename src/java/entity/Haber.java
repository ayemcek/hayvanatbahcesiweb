/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Enes
 */
public class Haber {
    private Long haber_id;
    private String aciklama;
    private String tarih;
    private Etkinlik etkinlik;

    public Long getHaber_id() {
        return haber_id;
    }

    public void setHaber_id(Long haber_id) {
        this.haber_id = haber_id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

   

    public Etkinlik getEtkinlik() {
        return etkinlik;
    }

    public void setEtkinlik(Etkinlik etkinlik) {
        this.etkinlik = etkinlik;
    }

     
    
    
}
