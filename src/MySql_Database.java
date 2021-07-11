import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class MySql_Database  {
        String name;
        String password;
        boolean regestriert = false;
        String cname;
        String cpassword;
        boolean angemeldet = false;
        double credit;

    public void setData(String name, String password ) throws SQLException {
        this.name = name;
        this.password = password;


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playerdata", "root", "virtuspro");
                // Verbindung herstellen mit URL + Username + Passwort
            System.out.println("Erfolgreich mit Datenbank verbunden");

            Statement statement = con.createStatement();
                // Notwendig um ein Query befehl von java in MySQL Workebench auszuführen

            statement.execute("insert into R_user (username, credit, r_password) values " +
                    "('"+this.name+"',100000,'"+this.password+"');");
                // Query befehl in Klammern wird ausgeführt
            statement.close();

            regestriert = true;

            System.out.println("Account erstellt !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkData(String name, String password){
        this.name = name;
        this.password = password;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playerdata", "root", "virtuspro");
            // Verbindung herstellen mit URL + Username + Passwort
            System.out.println("Erfolgreich mit Datenbank verbunden");

            Statement statement = con.createStatement();


                ResultSet rs = statement.executeQuery("select * from R_user");


                while(rs.next()) {
                    cname = rs.getString("username");
                    cpassword = rs.getString("r_password");
                    System.out.println(cname +" "+ cpassword);
                    if (this.name.equals(cname) && this.password.equals(cpassword)) {
                        angemeldet = true;
                        System.out.println("Anmeldung Erfolgreich!");
                        break;

                    }
                    System.out.println("============== ");
                }


        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void changeCredit(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playerdata", "root", "virtuspro");
            // Verbindung herstellen mit URL + Username + Passwort
            System.out.println("Erfolgreich mit Datenbank verbunden");

            Statement statement = con.createStatement();

            statement.execute("Update R_user set credit =" +credit+ "where username ="+name);



        } catch (Exception e){
            e.printStackTrace();
        }
    }



}





