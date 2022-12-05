/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.util.ArrayList;
import java.sql.SQLException;
/**
 *
 * @author toshi
 */
public class Seats {
    public int seatID;
    public int vacant;
    public String showroomLocation;
    public Seats(int seatId, int vacant,String showroomLocation){
        seatID = seatId;
        this.vacant = vacant;
    }
    public boolean isVacantFresh()throws SQLException{        
        DBConnection connection = new DBConnection("jdbc:mysql://localhost/MovieTheater","root","Shark.Killer572908");   
        connection.initializeConnection();
        ArrayList<Integer> state = connection.getTableInt(showroomLocation, 2);
        connection.close();
        vacant = state.get(seatID-1);
        if(vacant == 1){
            return true;
        }
        return false;
    }
    public void changeVacancy()throws SQLException{
        DBConnection connection = new DBConnection("jdbc:mysql://localhost/MovieTheater","root","Shark.Killer572908");   
        connection.initializeConnection();
        connection.deleteUser(showroomLocation);
        connection.close();
        
    }

}