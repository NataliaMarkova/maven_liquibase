package ua.rd.natalia_markova.maven_classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","liquibase_test","123");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from roles");
            System.out.println("Is first: " + rs.isFirst());
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            }
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

