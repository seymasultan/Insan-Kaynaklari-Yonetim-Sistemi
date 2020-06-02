package com.seymasultan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;

@Repository
@Transactional
public class HumanResourcesDAO {


    public void hrSave(HumanResources humanResources) {
        Connection con = OracleBaglanti.getInstance().getCon();

        try {

            PreparedStatement preparedStatement = null;

            String sorgu = "Insert Into humanresources(isim,mail,sifre,sirket) VALUES(?,?,?,?)";

            try {
                preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

                preparedStatement.setString(1,humanResources.getHrAd());
                preparedStatement.setString(2, humanResources.getHrMail());
                preparedStatement.setString(3, humanResources.getHrSifre());
                preparedStatement.setString(4, humanResources.getSirket());

                preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean hrLogin(HumanResources humanResources){
        ResultSet resultSet = null;
        String sql="SELECT id FROM humanresources WHERE mail='" + humanResources.getHrMail() + "' AND sifre='" + humanResources.getHrSifre()+"'";
        try {
            int id=-1;
            Connection connection = OracleBaglanti.getInstance().getCon();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id=resultSet.getInt("id");
                System.out.println("id"+id);
            }

            if(id != -1){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public int hrId(HumanResources humanResources) throws SQLException {
        ResultSet resultSet = null;
        String sql="SELECT id FROM humanresources WHERE mail='" + humanResources.getHrMail() + "' AND sifre='" + humanResources.getHrSifre()+"'";
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()) {
            id=resultSet.getInt("id");
            System.out.println("KULLANICI ID : " + id);
        }

        return id;
    }
    public HumanResources hrGet(int id) throws SQLException {
        ResultSet resultSet=null;
        String sql = "SELECT* FROM humanresources WHERE id ="+id;
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        HumanResources humanResources = null;
        while (resultSet.next()){
            String ad=resultSet.getString("isim");
            String mail=resultSet.getString("mail");
            String sifre=resultSet.getString("sifre");
            String şirket=resultSet.getString("sirket");

            humanResources=new HumanResources(id,ad,mail,sifre,şirket);

        }
        System.out.println("**********"+humanResources.getHrAd());
        return  humanResources;

    }
    public HumanResources hrGet() throws SQLException {
        ResultSet resultSet=null;
        String sql = "SELECT* FROM humanresources";
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        HumanResources humanResources = null;
        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String ad=resultSet.getString("isim");
            String mail=resultSet.getString("mail");
            String sifre=resultSet.getString("sifre");
            String şirket=resultSet.getString("sirket");

            humanResources=new HumanResources(id,ad,mail,sifre,şirket);

        }
        System.out.println("**********"+humanResources.getHrAd());
        return  humanResources;

    }

    public void hrAdvertSave(Advert advert,int hrId) {
        Connection con = OracleBaglanti.getInstance().getCon();

        try {

            PreparedStatement preparedStatement = null;

            String sorgu = "Insert Into advert(hrid,title,jobdescription,summary,personalInfo,professionalInfo,activationTime,disableTime)"+
                    "VALUES(?,?,?,?,?,?,?,?)";

            try {
                preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

                preparedStatement.setInt(1,hrId);
                preparedStatement.setString(2, advert.getTitle());
                preparedStatement.setString(3, advert.getJobDescription());
                preparedStatement.setString(4, advert.getSummary());
                preparedStatement.setString(5, advert.getPersonalInfo());
                preparedStatement.setString(6, advert.getProfessionalInfo());
                preparedStatement.setString(7, advert.getActivationTimeString());
                preparedStatement.setString(8, advert.getDisableTimeString());

                preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
