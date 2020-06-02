package com.seymasultan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);

      /*  Oracle oracle=new Oracle();
        DataSource dataSource;
        try {
            dataSource = oracle.dataSource();
            dataSource.getConnection().prepareStatement("CREATE TABLE Kullanıcı(\n" +
                    "   ISIM   VARCHAR(20) NOT NULL,\n" +
                    "   MAIL VARCHAR(20) NOT NULL,\n" +
                    "   KULLANICIADI VARCHAR(20) NOT NULL,\n" +
                    "   SIFRE VARCHAR(20) NOT NULL\n" +
                    ")").executeQuery();


        }catch (Exception e){
            e.printStackTrace();
        }
*/

    }
}
