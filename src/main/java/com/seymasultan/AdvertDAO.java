package com.seymasultan;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
@Transactional
public class AdvertDAO {

    public ArrayList<Advert> advertList(int hrId) throws SQLException {

        ResultSet resultSet=null;
        String sql = "SELECT id,title,summary FROM advert WHERE hrid ="+hrId;
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        Advert advert;
        ArrayList<Advert> advertList = new ArrayList<>();
        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String title=resultSet.getString("title");
            String summary=resultSet.getString("summary");

            advert=new Advert(id,title,summary);
            advertList.add(advert);
        }
        return  advertList;
    }
    public ArrayList<Advert> advertList(String userID) throws SQLException {

        ResultSet resultSet=null;
        String sql = "SELECT advertid FROM basvuranlar WHERE userid ='"+userID+"'";
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        Advert advert;
        ArrayList<Advert> advertList = new ArrayList<>();

        while (resultSet.next()){

            int advertId=resultSet.getInt("advertid");

            ResultSet resultSet2;
            String sql2="Select id,title,summary FROM advert WHERE id="+advertId;
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            resultSet2 = preparedStatement2.executeQuery();

            while(resultSet2.next()){

                int id=resultSet2.getInt("id");
                String title=resultSet2.getString("title");
                String summary=resultSet2.getString("summary");

                advert=new Advert(id,title,summary);
                advertList.add(advert);
            }

        }
        return  advertList;
    }

    public ArrayList<Advert> allAdvertList() throws SQLException {

        ResultSet resultSet=null;
        String sql = "SELECT id,title,summary FROM advert";
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        Advert advert;
        ArrayList<Advert> allAdvertList = new ArrayList<>();
        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String title=resultSet.getString("title");
            String summary=resultSet.getString("summary");

            advert=new Advert(id,title,summary);
            allAdvertList.add(advert);
        }
        return  allAdvertList;
    }

    public Advert getAdvert(int advertId) throws SQLException {

        ResultSet resultSet=null;
        String sql = "SELECT* FROM advert WHERE id ="+advertId;
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        Advert advert=null;

        while (resultSet.next()){

            int hrId=resultSet.getInt("hrid");
            String title=resultSet.getString("title");
            String jobdescription=resultSet.getString("jobdescription");
            String summary=resultSet.getString("summary");
            String personalinfo=resultSet.getString("personalinfo");
            String professionalinfo=resultSet.getString("professionalinfo");
            String activationtime=resultSet.getString("activationtime");
            String disabletime=resultSet.getString("disabletime");

            advert=new Advert(advertId,hrId,title,jobdescription,summary,personalinfo,professionalinfo,activationtime,disabletime);

        }
        return advert;
    }

    public void updateAdvert(Advert advert,int advertId){
        Connection con = OracleBaglanti.getInstance().getCon();
        try {
            PreparedStatement preparedStatement = null;
            String sorgu = "UPDATE advert SET title=?,jobdescription=?,summary=?,personalinfo=?,professionalinfo=?" +
                    ",activationtime=?,disabletime=? WHERE id="+advertId;
            System.out.println(advertId);
            try {
                preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

                preparedStatement.setString(1,advert.getTitle());
                preparedStatement.setString(2, advert.getJobDescription());
                preparedStatement.setString(3, advert.getSummary());
                preparedStatement.setString(4, advert.getPersonalInfo());
                preparedStatement.setString(5,advert.getProfessionalInfo());
                preparedStatement.setString(6, advert.getActivationTimeString());
                preparedStatement.setString(7, advert.getDisableTimeString());


                preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void deleteAdvert(int advertId){
        Connection con = OracleBaglanti.getInstance().getCon();
        try {
            PreparedStatement preparedStatement = null;
            String sorgu = "DELETE advert Where id="+advertId;
            try {
                preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

                preparedStatement.executeQuery();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void basvuru(int advertId,String userId,int activeHrId) {
        Connection con = OracleBaglanti.getInstance().getCon();

        try {

            PreparedStatement preparedStatement = null;

            String sorgu = "Insert Into basvuranlar(userid,hrid,advertid) VALUES(?,?,?)";

            try {
                preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

                preparedStatement.setString(1,userId);
                preparedStatement.setInt(2, activeHrId);
                preparedStatement.setInt(3,advertId);


                preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean basvuruKontrol(String userId,int advertId) throws SQLException {

        ResultSet resultSet=null;
        String sql = "SELECT userid FROM basvuranlar WHERE userid ='"+userId +"' AND advertid="+advertId;
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){

            return true;

        }
        return false;
    }

    public void deleteUserApply(String userID,int advertId){
        Connection con = OracleBaglanti.getInstance().getCon();
        try {
            PreparedStatement preparedStatement = null;
            String sorgu = "DELETE basvuranlar WHERE userid ='"+userID +"' AND advertid="+advertId;
            try {
                preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

                preparedStatement.executeQuery();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Users> ilanaBasvuranKisiler(int advertId) throws SQLException {

        ResultSet resultSet=null;
        String sql = "SELECT userid FROM basvuranlar WHERE advertid ="+advertId;
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        Users user;
        ArrayList<Users> userList = new ArrayList<>();
        while (resultSet.next()){

            String userID=resultSet.getString("userid");

            ResultSet resultSet2;
            String sql2="Select isim,mail,profil FROM users WHERE id='"+userID+"'";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            resultSet2 = preparedStatement2.executeQuery();

            while(resultSet2.next()){

                String isim=resultSet2.getString("isim");
                String mail=resultSet2.getString("mail");
                String profil=resultSet2.getString("profil");

                user=new Users(userID,isim,mail,profil);
                userList.add(user);
            }

        }
        return userList;
    }
    public ArrayList<Users> ilanaBasvuranKisilerArama(int advertId,String basvuranisim) throws SQLException {

        ResultSet resultSet=null;
        String sql = "SELECT userid FROM basvuranlar WHERE advertid ="+advertId;
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        Users user;
        ArrayList<Users> userList = new ArrayList<>();
        while (resultSet.next()){

            String userID=resultSet.getString("userid");

            ResultSet resultSet2;
            String sql2="Select isim,mail,profil FROM users WHERE id='"+userID+"'";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            resultSet2 = preparedStatement2.executeQuery();

            while(resultSet2.next()){

                String isim=resultSet2.getString("isim");
                String mail=resultSet2.getString("mail");
                String profil=resultSet2.getString("profil");

                user=new Users(userID,isim,mail,profil);
                if(user.getIsim().contains(basvuranisim))
                    userList.add(user);
            }

        }
        return userList;
    }
}
