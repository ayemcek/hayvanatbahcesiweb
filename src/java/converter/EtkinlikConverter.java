/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.EtkinlikDao;
import entity.Etkinlik;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Enes
 */
@FacesConverter(value="etkinlikConverter")
public class EtkinlikConverter implements Converter {
    
    private EtkinlikDao etkinlikDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return this.getEtkinlikDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Etkinlik e=(Etkinlik) arg2;
        return e.getEtkinlik_id().toString();
    }

    public EtkinlikDao getEtkinlikDao() {
        if(this.etkinlikDao==null){
            this.etkinlikDao=new EtkinlikDao();
        }
        return etkinlikDao;
    }
    
    
}
