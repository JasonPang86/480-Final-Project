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
public class ShowRoom {
    ArrayList<Integer> seats;
    String showtimeId;
    int showroomId;
    int SeatLocations;
    ShowRoom(String ShowtimeId,int ShowroomId, int seatLocation){
        this.showtimeId = ShowtimeId;
        this.showroomId = ShowroomId;
        this.SeatLocations = seatLocation;
    }
    public ArrayList<Seats> getSeats()throws SQLException{
        DBConnection connection = new DBConnection("jdbc:mysql://localhost/MovieTheater","root","Shark.Killer572908");   
        connection.initializeConnection();
        ArrayList<Integer> seat = connection.getTableInt("SEATMAP"+showtimeId+"_"+Integer.toString(showroomId),1);
        ArrayList<Integer> state = connection.getTableInt("SEATMAP"+showtimeId+"_"+Integer.toString(showroomId), 2);
        connection.close();
        ArrayList<Seats> seats = new ArrayList<Seats>();
        for(int i = 0;i<seat.size();i++){
            seats.add(new Seats((int)seat.get(i),(int)state.get(i),"SEATMAP"+showtimeId+"_"+Integer.toString(showroomId)));
        }
        return seats;
    }
}