package com.seymasultan;

import java.sql.Connection;

public class OracleBaglanti {
    private static OracleBaglanti instance = null;
    private Connection connection;

    private OracleBaglanti() {
        try{
           Oracle oracle=new Oracle();
            connection = oracle.dataSource().getConnection();

            System.out.println("connection is succesfull");

        }catch(Exception e){ System.out.println(e);}
    }

    public static OracleBaglanti getInstance() {
        if (instance == null)
            instance = new OracleBaglanti();
        return instance;
    }

    public Connection getCon() {
        return connection;
    }
}
