package com.seymasultan;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
@Transactional
public class UsersDAO {

    Users user;

    public void userSave(Users user) {
        Connection con = OracleBaglanti.getInstance().getCon();

        try {

            PreparedStatement preparedStatement = null;

            String sorgu = "Insert Into users(id,isim,mail,profil) VALUES(?,?,?,?)";

            try {
                preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

                preparedStatement.setString(1,user.getId());
                preparedStatement.setString(2, user.getIsim());
                preparedStatement.setString(3, user.getMail());
                preparedStatement.setString(4, user.getProfil());

                preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


     public String id(Users user) throws SQLException {
         ResultSet resultSet = null;
         String sql="SELECT id FROM users WHERE id='" + user.getId() +"'";
         Connection connection = OracleBaglanti.getInstance().getCon();
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         resultSet = preparedStatement.executeQuery();
         String id = "";
         while (resultSet.next()) {
             id=resultSet.getString("id");
             System.out.println("KULLANICI ID : " + id);
         }

         return id;
     }

    public Users userGet(String id) throws SQLException {
        ResultSet resultSet=null;
        String sql = "SELECT* FROM users WHERE id ='"+id+"'";
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        Users user = null;
        while (resultSet.next()){
            String isim=resultSet.getString("isim");
            String mail=resultSet.getString("mail");
            String profil=resultSet.getString("profil");

            user=new Users(id,isim,mail,profil);

        }

        System.out.println("**********"+user.getIsim());

        return  user;

    }

    public Users userCek() throws SQLException {
        ResultSet resultSet=null;
        String sql = "SELECT* FROM users";
        Connection connection = OracleBaglanti.getInstance().getCon();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        Users user = null;
        while (resultSet.next()){
            String id=resultSet.getString("id");
            String isim=resultSet.getString("isim");
            String mail=resultSet.getString("mail");
            String profil=resultSet.getString("profil");

            user=new Users(id,isim,mail,profil);

        }

        System.out.println("**********"+user.getIsim());

        return  user;

    }

}

