/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Enes
 */
public class Etkinlik {
    private Long etkinlik_id;
    private String aciklama;
    private int ucret;

    public Etkinlik() {
    }

    public Etkinlik(Long etkinlik_id, String aciklama, int ucret) {
        this.etkinlik_id = etkinlik_id;
        this.aciklama = aciklama;
        this.ucret = ucret;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.etkinlik_id);
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
        final Etkinlik other = (Etkinlik) obj;
        if (!Objects.equals(this.etkinlik_id, other.etkinlik_id)) {
            return false;
        }
        return true;
    }

    public Long getEtkinlik_id() {
        return etkinlik_id;
    }

    public void setEtkinlik_id(Long etkinlik_id) {
        this.etkinlik_id = etkinlik_id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public int getUcret() {
        return ucret;
    }

    public void setUcret(int ucret) {
        this.ucret = ucret;
    }

    @Override
    public String toString() {
        return aciklama;
    }

    
    
    
   
    
}
