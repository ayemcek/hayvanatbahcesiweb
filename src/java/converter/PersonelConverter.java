/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.PersonelDAO;
import entity.Personel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author VolkanKNC
 */
@FacesConverter(value = "personelConverter")
public class PersonelConverter implements Converter {
    
    private PersonelDAO personelDAO;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getPersonelDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Personel p = (Personel) value;
        return p.getPersonel_id().toString();
    }

    public PersonelDAO getPersonelDAO() {
        if(this.personelDAO == null)
            this.personelDAO = new PersonelDAO();
        return personelDAO;
    }

    
}
