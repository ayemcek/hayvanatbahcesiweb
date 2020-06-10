/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import entity.Haber;
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
public class HaberDao {
    private Connector connector;
    private Connection connection;
   
    private EtkinlikDao etkinlikDao;
    
    public List<Haber> findAll(int page, int pageSize){
        List<Haber>haberList=new ArrayList<>();
        
         int start=(page-1)*pageSize;
      //  limit"+start+","+pageSize
         try {
            PreparedStatement pst=this.getConnection().prepareStatement("Select * from haber order by haber_id desc limit "+start+","+pageSize);
             ResultSet rs=  pst.executeQuery();
           while(rs.next()){
               Haber h=new Haber();
               h.setHaber_id(rs.getLong("haber_id"));
               h.setAciklama(rs.getString("aciklama"));
               h.setTarih(rs.getString("tarih"));
               h.setEtkinlik(this.getEtkinlikDao().find(rs.getLong("etkinlik_id")));
               haberList.add(h);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return haberList;
    }
    
     public int count(){
       int count=0;
         
        try {
            PreparedStatement pst=this.getConnection().prepareStatement("select count(haber_id) as haber_count from haber");
             ResultSet rs=  pst.executeQuery();
             rs.next();
             count=rs.getInt("haber_count");
             
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return count;
    }

     public void create(Haber haber) {
       try{
           
          
           PreparedStatement pst=this.getConnection().prepareStatement("insert into haber(aciklama,tarih,etkinlik_id) values(?,?,?)");
          pst.setString(1,haber.getAciklama());
          pst.setString(2,haber.getTarih() );
           pst.setLong(3,haber.getEtkinlik().getEtkinlik_id());
           pst.executeUpdate();
            
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }
     
     
     public void edit(Haber haber) {
       try{
           
       
        PreparedStatement pst=this.getConnection().prepareStatement("update haber set aciklama=? ,tarih=?, etkinlik_id=? where haber_id=?");
           pst.setString(1, haber.getAciklama());
           pst.setString(2,haber.getTarih() );
           pst.setLong(3,haber.getEtkinlik().getEtkinlik_id());
           pst.setLong(4,haber.getHaber_id());
           pst.executeUpdate();
            
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }

     public void remove(Haber haber) {
      try{
          PreparedStatement pst=this.getConnection().prepareStatement("delete from haber where haber_id=?");
          pst.setLong(1, haber.getHaber_id());
          pst.executeUpdate();
          
      }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }
    }
     
    public EtkinlikDao getEtkinlikDao() {
        if(this.etkinlikDao==null){
            this.etkinlikDao=new EtkinlikDao();
        }
        return etkinlikDao;
    }
    

    public Connector getConnector() {
        if(this.connector==null){
            this.connector=new Connector();
        }
        return connector;
    }

    public Connection getConnection() {
        if(this.connection==null){
            this.connection=this.getConnector().connect();
            
        }
        return connection;
    }

    

    

  
    
}
