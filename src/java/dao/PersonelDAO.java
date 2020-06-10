package dao;

import entity.Personel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Connector;

/**
 *
 * @author VolkanKNC
 */
public class PersonelDAO {

    Connector connector;
    Connection connection;
    
    public List<Personel> findAll() {
        List<Personel> personellist = new ArrayList<>();
        
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from personel");
            
            while (rs.next()) {                
                Personel tmp = new Personel();
                tmp.setPersonel_id(rs.getLong("personel_id"));
                tmp.setAd_soyad(rs.getString("ad_soyad"));
                tmp.setGorev(rs.getString("gorev"));
                personellist.add(tmp);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return personellist;
    }
    
    public List<Personel> gethayvanCategories(Long hayvan_id) {
        List<Personel> hayvanCategories = new ArrayList<>();
        
        try{
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from hayvan_personel where hayvan_id="+hayvan_id);
            
            while (rs.next()) {                
                hayvanCategories.add(this.find(rs.getLong("personel_id")));
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(PersonelDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return hayvanCategories;
    }
    
    public Personel find(Long id){
        Personel p = null;
        
        try{
            PreparedStatement pst = this.getConnection().prepareStatement("select * from personel where personel_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            
            rs.next();
            
            p= new Personel();
            p.setPersonel_id(rs.getLong("personel_id"));
            p.setAd_soyad(rs.getString("ad_soyad"));
            p.setGorev(rs.getString("gorev"));
            
        }catch (SQLException ex) {
            Logger.getLogger(PersonelDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return p;
    }

    public Connector getConnector() {
        if (this.connector == null)
            this.connector = new Connector();
        return connector;
    }
    public Connection getConnection() {
        if (this.connection == null)
            this.connection = this.getConnector().connect();
        return connection;
    }

    public void insert(Personel personel) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into personel (ad_soyad,gorev) values('" + personel.getAd_soyad() + "','" + personel.getGorev() + "')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void delete(Personel personel) {
        try {
            
            PreparedStatement pst = this.getConnection().prepareStatement("delete from hayvan_personel where personel_id=?");
            pst.setLong(1, personel.getPersonel_id());
            pst.executeUpdate();
            
            pst = this.getConnection().prepareStatement("delete from personel where personel_id=?");
            pst.setLong(1, personel.getPersonel_id());
            pst.executeUpdate();
            
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Personel personel) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update personel set ad_soyad='"+personel.getAd_soyad()+"' , gorev='"+personel.getGorev()+"' where personel_id= "+personel.getPersonel_id());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
