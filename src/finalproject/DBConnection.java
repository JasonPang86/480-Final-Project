/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

/**
 *
 * @author toshi
 */
import java.sql.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
public class DBConnection {
    
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
    private Connection dbConnect;
    private ResultSet results;
    
    public DBConnection(String url, String user, String pw){

        // Database URL
        this.DBURL = url;

        //  Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }
    public void initializeConnection() throws SQLException{
        
        dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);              
    }
    
    String getDburl(){
        return this.DBURL;
    }

    String getUsername(){
        return this.USERNAME;
    }
    
    String getPassword(){
        return this.PASSWORD;
    }
    public ArrayList<String> getTable(String tableName,int coloumn)throws SQLException{
        /***********ADD CODE HERE***********/                
        Statement myStmt = dbConnect.createStatement();
        results = myStmt.executeQuery("SELECT * FROM "+ tableName);
        ArrayList<String> output = new ArrayList<String>();
        int i = 0;
        while (results.next()) {
            output.add(results.getString(coloumn));
            i++;
        }
        myStmt.close();
        results.close();
        return output;
    }
    public void insertSeat(String table, int id, int value)throws SQLException{
        String query = "INSERT INTO " + table + " (seatNumber, vacant) VALUES (?,?)";
        PreparedStatement mystmt =dbConnect.prepareStatement(query);        
        mystmt.setString(1,Integer.toString(value));
        mystmt.setString(2,Integer.toString(value));
        mystmt.executeUpdate();
        mystmt.close();
    }
    public void deleteSeat(String table, int id)throws SQLException{
        String query = "DELET FROM " + table + " WHERE seatNumber = ?";
        PreparedStatement mystmt = dbConnect.prepareStatement(query);
        mystmt.setString(1,Integer.toString(id));
        mystmt.executeUpdate();
        mystmt.close();
        
    }    
    /*  
  firstname       VARCHAR(150) NOT NULL,                # First Name of the Registered User
  lastname        VARCHAR(150) NOT NULL,                # Last Name of the Registered User
  email           VARCHAR(150) NOT NULL,                # Email of the Registered User
  password        VARCHAR(150) NOT NULL,                # Password of the Registered User
  postal          VARCHAR(150) NOT NULL,                   # Postal Code of the Registered User
  cardnumber      VARCHAR(150) NOT NULL,                # Credit Card number of the Registered User
  cvv             VARCHAR(150) NOT NULL,                # Credit Card cvv of the Registered User
  expirationdate  VARCHAR(150) NOT NULL,                          # Credit Card expiration date of the Registered User
  nextpayment     VARCHAR(150) NOT NULL,                      # Next payment date for the Registered User*/
    public void insertUser  (String firstName, String lastName, String email, String password, String postal, 
        String cardNumber,String ccv, String expirationDate, String nextPayment)throws SQLException{
        
        PreparedStatement mystmt = dbConnect.prepareStatement("INSERT INTO RegisteredUser (firstname,lastname, email,password,postal,cardnumber,cvv,expirationdate,nextpayment) VALUES (?,?,?,?,?,?,?,?,?)");
        mystmt.setString(1,firstName);
        mystmt.setString(2,lastName);
        mystmt.setString(3, email);
        mystmt.setString(4, password);
        mystmt.setString(5,postal);
        mystmt.setString(6, cardNumber);
        mystmt.setString(7, ccv);
        mystmt.setString(8, expirationDate);
        mystmt.setString(9, nextPayment);
        mystmt.executeUpdate();
        mystmt.close();
    }   
    public void deleteUser  (String email) throws SQLException{
        
        String query = "DELETE FROM RegisteredUser WHERE EMAIL = ?";
        PreparedStatement mystmt = dbConnect.prepareStatement(query);
        mystmt.setString(1,email);
        mystmt.executeUpdate();
        mystmt.close();
    }
    
    public String checkUserEmail  (String email) throws SQLException {
        String query = "SELECT * FROM RegisteredUser WHERE email = ?";
        PreparedStatement mystmt = dbConnect.prepareStatement(query);
        mystmt.setString(1, email);
        ResultSet x = mystmt.executeQuery();
        if (x.next() == false) {
            return "NONE";
        }
        String result = x.getString("EMAIL");
        mystmt.close();
        return result;
    }
    
    public String checkUser  (String email, String password) throws SQLException {
        String query = "SELECT * FROM RegisteredUser WHERE email = ? AND password = ?";
        PreparedStatement mystmt = dbConnect.prepareStatement(query);
        mystmt.setString(1, email);
        mystmt.setString(2, password);
        ResultSet x = mystmt.executeQuery();
        if (x.next() == false) {
            return "NONE";
        }
        String result = x.getString("EMAIL");
        mystmt.close();
        return result;
    }
    
    public String getUserPass (String email) throws SQLException {
        String query = "SELECT * FROM RegisteredUser WHERE email = ?";
        PreparedStatement mystmt = dbConnect.prepareStatement(query);
        mystmt.setString(1, email);
        ResultSet x = mystmt.executeQuery();
        if (x.next() == false) {
            return "NONE";
        }
        String result = x.getString("password");
        mystmt.close();
        return result;
    }
    
    public void changeUserEmail (String email, String newEmail, String password) throws SQLException {
        String query = "UPDATE RegisteredUser SET EMAIL = ? WHERE EMAIL = ? AND password = ?";
        PreparedStatement mystmt = dbConnect.prepareStatement(query);
        mystmt.setString(1, newEmail);
        mystmt.setString(2, email);
        mystmt.setString(3, password);
        mystmt.executeUpdate();
        mystmt.close();
    }
    
    public void changeUserNames (String email, String newFirstName, String newLastName) throws SQLException {
        String query = "UPDATE RegisteredUser SET firstName = ? WHERE EMAIL = ?";
        PreparedStatement mystmt = dbConnect.prepareStatement(query);
        mystmt.setString(1, newFirstName);
        mystmt.setString(2, email);
        mystmt.executeUpdate();
        mystmt.close();
        
        String input = "UPDATE RegisteredUser SET lastName = ? WHERE EMAIL = ?";
        mystmt = dbConnect.prepareStatement(input);
        mystmt.setString(1, newLastName);
        mystmt.setString(2, email);
        mystmt.executeUpdate();
        mystmt.close();
    }
    
    public String getUsersFirstName (String email) throws SQLException {
        String query = "SELECT * FROM RegisteredUser WHERE email = ?";
        PreparedStatement mystmt = dbConnect.prepareStatement(query);
        mystmt.setString(1, email);
        ResultSet x = mystmt.executeQuery();
        if (x.next() == false) {
            return "NONE";
        }
        String result = x.getString("firstName");
        mystmt.close();
        return result;     
    }
    
    public String getUsersLastName (String email) throws SQLException {
        String query = "SELECT * FROM RegisteredUser WHERE email = ?";
        PreparedStatement mystmt = dbConnect.prepareStatement(query);
        mystmt.setString(1, email);
        ResultSet x = mystmt.executeQuery();
        if (x.next() == false) {
            return "NONE";
        }
        String result = x.getString("lastName");
        mystmt.close();
        return result; 
    }
    
    
    
    public ArrayList<Integer> getTableInt(String tableName,int coloumn)throws SQLException{
        /***********ADD CODE HERE***********/                
        Statement myStmt = dbConnect.createStatement();
        results = myStmt.executeQuery("SELECT * FROM "+ tableName);
        ArrayList<Integer> output = new ArrayList<Integer>();
        int i = 0;
       while (results.next()) {
            output.add(results.getInt(coloumn));
            i++;
        }
        myStmt.close();
        results.close();
        return output;
    }
        
    public void close() {
        try {
            dbConnect.close();
            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
