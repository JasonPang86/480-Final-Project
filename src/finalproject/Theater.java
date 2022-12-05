/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

/**
 *
 * @author toshi
 */
import java.util.*;
import java.sql.SQLException;
public class Theater {
    static private Theater onlyInstance;
    
    ArrayList<Movie> movies;
    public static Theater getInstance()throws SQLException{
        if(onlyInstance == null){
            onlyInstance = new Theater();
        }
        return onlyInstance;
    }
    private Theater()throws SQLException{
        DBConnection connection = new DBConnection("jdbc:mysql://localhost/MovieTheater","root","Shark.Killer572908");   
        connection.initializeConnection();
        ArrayList<String> names = connection.getTable("Theater",1);
        ArrayList<Integer> Showtimes = connection.getTableInt("Theater", 2);
        connection.close();
        movies = new ArrayList<Movie>();
        for(int i = 0; i< names.size();i++){
            movies.add(new Movie(names.get(i),Showtimes.get(i)));
        }
    }
    public ArrayList<Movie> getMovies(){
        return movies;
    }
}