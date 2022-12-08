/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.util.*;
import java.sql.SQLException;
import java.time.*;
/**
 *
 * @author toshi
 */
public class Movie {
    
    //delcare variables, constructors and getters
    private String movieName;
    private ArrayList<Showtimes> showtimes; 
    public String getMovieName(){
        return movieName;
    };
    public ArrayList<Showtimes> getShowtimes(){
        return showtimes;
    };
    public Movie(String name,int showtimes)throws SQLException{
        movieName = name;
        DBConnection connection = new DBConnection("jdbc:mysql://localhost/MovieTheater","root","password");   
        connection.initializeConnection();
        ArrayList<String> dates = connection.getTable("Showtimes" + Integer.toString(showtimes),1);
        ArrayList<String> times = connection.getTable("Showtimes"+ Integer.toString(showtimes), 2);
        ArrayList<String> Showrooms = connection.getTable("Showtimes"+ Integer.toString(showtimes), 3);
        ArrayList<Integer> showtimesIdentifier = connection.getTableInt("Showtimes"+ Integer.toString(showtimes),4);
        ArrayList<Integer> seatLocation = connection.getTableInt("Showtimes"+ Integer.toString(showtimes), 5);
        this.showtimes = new ArrayList<Showtimes>();
        for(int i = 0; i< dates.size();i++){
            this.showtimes.add(new Showtimes(LocalDate.parse(dates.get(i)),LocalTime.parse(times.get(i)),
            Showrooms.get(i),(int)showtimesIdentifier.get(i),(int)seatLocation.get(i)));
        }
        connection.close();
        
    }
}