package dao;

import entity.Hayvan;
import entity.Personel;
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
 * @author VolkanKNC
 */
public class HayvanDAO {

    Connector connector;
    Connection connection;

    PersonelDAO personelDAO;

    public List<Hayvan> findAll() {
        List<Hayvan> hayvanlist = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from hayvan");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {   //Bir sonraki olduğu sürece listeyi yaz 
                Hayvan tmp = new Hayvan();
                tmp.setHayvan_id(rs.getLong("hayvan_id"));
                tmp.setTur(rs.getString("tur"));
                tmp.setCinsi(rs.getString("cinsi"));
                tmp.setAciklama(rs.getString("aciklama"));

                tmp.setHayvanCategories(this.getPersonelDAO().gethayvanCategories(tmp.getHayvan_id()));
                hayvanlist.add(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return hayvanlist;
    }

    public void create(Hayvan hayvan) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into hayvan (tur,cinsi,aciklama) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, hayvan.getTur());
            pst.setString(2, hayvan.getCinsi());
            pst.setString(3, hayvan.getAciklama());

            pst.executeUpdate();

            Long hayvan_id = null;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                hayvan_id = gk.getLong(1);
            }

            for (Personel p : hayvan.getHayvanCategories()) {
                pst = this.getConnection().prepareStatement("insert into hayvan_personel (hayvan_id, personel_id) values(?,?)");
                pst.setLong(1, hayvan_id);
                pst.setLong(2, p.getPersonel_id());
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Hayvan hayvan) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from hayvan_personel where hayvan_id=?");
            pst.setLong(1, hayvan.getHayvan_id());
            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from hayvan where hayvan_id=?");
            pst.setLong(1, hayvan.getHayvan_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Hayvan hayvan) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update hayvan set tur=?, cinsi=?, aciklama=? where hayvan_id=? ");
            pst.setString(1, hayvan.getTur());
            pst.setString(2, hayvan.getCinsi());
            pst.setString(3, hayvan.getAciklama());
            pst.setLong(4, hayvan.getHayvan_id());

            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from hayvan_personel where hayvan_id=?");
            pst.setLong(1, hayvan.getHayvan_id());
            pst.executeUpdate();

            for (Personel p : hayvan.getHayvanCategories()) {
                pst = this.getConnection().prepareStatement("insert into hayvan_personel (hayvan_id, personel_id) values(?,?)");
                pst.setLong(1, hayvan.getHayvan_id());
                pst.setLong(2, p.getPersonel_id());
                pst.executeUpdate();
            }

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

    public PersonelDAO getPersonelDAO() {
        if (this.personelDAO == null) {
            this.personelDAO = new PersonelDAO();
        }
        return personelDAO;
    }
}
