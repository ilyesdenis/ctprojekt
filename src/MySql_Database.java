import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class MySql_Database  {
    String name;
    private String password;
    boolean regestriert = false;
    private String cname;
    private String cpassword;
    boolean angemeldet = false;
    public int credit;
    private String username;
    private int chips;
    boolean check = false;


//--------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Regestrierungsdaten werden mit den vorhandenen Daten verglichen ob usernamen schon exestieren und anschließend in die Datenbank gespeichert

    public void setData(String name, String password ) throws SQLException {
        this.name = name;
        this.password = password;


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playerdata", "root", "virtuspro");
            // Verbindung herstellen mit URL + Username + Passwort
            System.out.println("Erfolgreich mit Datenbank verbunden");

            Statement statement = con.createStatement();
            // Notwendig um ein Query befehl von java in MySQL Workebench auszuführen

            ResultSet rs = statement.executeQuery("select username from R_user");
            while(rs.next()) {
                if (this.name.equals(rs.getString("username"))) {
                    regestriert = false;
                    break;
                }
                else {
                    regestriert = true;
                }
            }
            if(regestriert == true) {
                statement.execute("insert into R_user (username, credit, r_password) values " +
                        "('" + this.name + "',100000,'" + this.password + "');");
                // Query befehl in Klammern wird ausgeführt

                statement.execute("Update R_user set s_username = '" + this.name + "' where id =1");
                statement.close();


                System.out.println("Account erstellt !");
            }
            else{
                System.out.println("Regestrierung fehlgeschlagen, username exestiert bereits!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------
    // Eingegebene Anmeldedaten (Username,passwort) werden abgeglichen

    public void checkData(String name, String password) throws SQLException{
        this.name = name;
        this.password = password;

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playerdata", "root", "virtuspro");

            System.out.println("Erfolgreich mit Datenbank verbunden");

            Statement statement = con.createStatement();


            ResultSet rs = statement.executeQuery("select username, r_password from R_user");


            while(rs.next()) {
                cname = rs.getString("username");
                cpassword = rs.getString("r_password");
                System.out.println(cname +" "+ cpassword);
                if (this.name.equals(cname) && this.password.equals(cpassword)) {
                    angemeldet = true;
                    System.out.println("Anmeldung Erfolgreich!");

                    statement.execute("Update R_user set s_username = '"+this.name+"' where id = 1");
                    statement.close();
                    rs.close();
                    break;

                }
                System.out.println("============== ");
            }


        } catch (Exception e){
            e.printStackTrace();
        }

    }
//----------------------------------------------------------------------------------------------------------------------------------------------------------
    // Wenn Chips gesetzt werden, werden sie von Guthaben abgezogen

    public void setChips(int chips) throws SQLException{
        try{
            this.chips = chips;
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playerdata", "root", "virtuspro");

            System.out.println("Erfolgreich mit Datenbank verbunden");

            Statement statement = con.createStatement();


            ResultSet rs = statement.executeQuery("select s_username from R_user where id = 1");

            while (rs.next()) {
                name = rs.getString("s_username");
            }
            ResultSet rst = statement.executeQuery("select credit from R_user where username = '"+name+"'");

            while(rst.next()) {
                credit = rst.getInt("credit");
            }
            if(credit >= this.chips) {
                credit = credit - this.chips;
                statement.execute("update R_user set credit =" + credit + " where username = '" + name + "'");
                System.out.println("Ihr Guthaben beträgt nun : " + credit);
                rst.close();
                statement.close();
            }
            else{
                System.out.println("Ihr momentanes Guthaben ist zu niedrig");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
// nachdem spin wheel gedrückt wurde, wird der Gewinn zum auktuellen Guthaben dazu gerechnet

    public void changeCredit(int win) throws SQLException{
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playerdata", "root", "virtuspro");

            System.out.println("Erfolgreich mit Datenbank verbunden");

            Statement statement = con.createStatement();


            ResultSet rs = statement.executeQuery("select s_username from R_user where id = 1");

            while (rs.next()) {
                name = rs.getString("s_username");
            }
            ResultSet rst = statement.executeQuery("select credit from R_user where username = '"+name+"'");

            while(rst.next()) {
                credit = rst.getInt("credit");
            }

            credit = credit + win;

            statement.execute("update R_user set credit ="+credit+" where username = '"+name+"'");
            System.out.println("Ihr Guthaben beträgt nun : "+credit);
            rst.close();
            statement.close();



        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
// Aktuelles guthaben wird mit dem Einsatz verglichen und wenn es zu niedrig ist wird nichts gemacht
    public boolean checkGuthaben(int chips){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playerdata", "root", "virtuspro");

            System.out.println("Erfolgreich mit Datenbank verbunden");

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select s_username from R_user where id = 1");

            while (rs.next()) {
                name = rs.getString("s_username");
            }
            ResultSet rst = statement.executeQuery("select credit from R_user where username = '"+name+"'");

            while(rst.next()) {
                credit = rst.getInt("credit");
            }
            if (credit >= chips){
                check = true;
            }
            else{
                check = false;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(check);
        return check;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------
// Aktuelles guthaben wird zurückegeben
    public int getGuthaben(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playerdata", "root", "virtuspro");

            System.out.println("Erfolgreich mit Datenbank verbunden");

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select s_username from R_user where id = 1");

            while (rs.next()) {
                name = rs.getString("s_username");
            }
            ResultSet rst = statement.executeQuery("select credit from R_user where username = '"+name+"'");

            while(rst.next()) {
                credit = rst.getInt("credit");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return credit;
    }



}
