/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author VolkanKNC
 */
public class Personel {
    private Long personel_id;
    private String ad_soyad;
    private String gorev;

    public Personel() {
    }

    public Long getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(Long personel_id) {
        this.personel_id = personel_id;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }

    @Override
    public String toString() {
        return "Personel{" + "personel_id=" + personel_id + ", ad_soyad=" + ad_soyad + ", gorev=" + gorev + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.personel_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personel other = (Personel) obj;
        if (!Objects.equals(this.personel_id, other.personel_id)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
