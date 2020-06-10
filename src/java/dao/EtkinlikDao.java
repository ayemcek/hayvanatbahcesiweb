/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Etkinlik;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author Enes
 */
public class EtkinlikDao {

    private Connector connector;
    private Connection connection;

    public List<Etkinlik> findAll() {
        List<Etkinlik> etkinlikList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from etkinlik");
            while (rs.next()) {
                Etkinlik e = new Etkinlik();
                e.setEtkinlik_id(rs.getLong("etkinlik_id"));
                e.setAciklama(rs.getString("aciklama"));
                e.setUcret(rs.getInt("ucret"));

                etkinlikList.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return etkinlikList;
    }

    public Etkinlik find(Long id){
        Etkinlik e=null;
        try{
            
            PreparedStatement st=this.getConnection().prepareStatement("select * from etkinlik where etkinlik_id=?");
            st.setLong(1, id);
            ResultSet rs=st.executeQuery();
          /*  Statement st=this.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select * from etkinlik where etkinlik_id="+id);
            */
            rs.next();
            
            e=new Etkinlik();
            e.setEtkinlik_id(rs.getLong("etkinlik_id"));
            e.setAciklama(rs.getString("aciklama"));
            e.setUcret(rs.getInt("ucret"));
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return e;
    }
    
    public void insert(Etkinlik etkinlik) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into etkinlik (aciklama,ucret) values ('" + etkinlik.getAciklama() + "','" + etkinlik.getUcret() + "')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Etkinlik etk) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from etkinlik where etkinlik_id=" + etk.getEtkinlik_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Etkinlik etkinlik) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update etkinlik set aciklama='" + etkinlik.getAciklama() + "',ucret='" + etkinlik.getUcret() + "' where etkinlik_id= " + etkinlik.getEtkinlik_id());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();

        }
        return connection;
    }

}
