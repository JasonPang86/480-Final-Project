/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.time.*;
/**
 *
 * @author toshi
 */
public class Showtimes {
    //delcare variables and constructors
    private String showtimeId;
    private LocalDate date;
    private LocalTime time;
    private ShowRoom rooms;
    public Showtimes(LocalDate date,LocalTime time,String id, int seatLocations, int showroom){
        this.showtimeId = showtimeId;
        this.date = date;
        this.time = time;
        this.rooms = new ShowRoom(id,showroom, seatLocations);
    }
    public ShowRoom getShowRoom(){
        return rooms;
    }
    public LocalDate getShowDate(){
        return date;
    }
    public LocalTime getShowTime(){
        return time;
    }
    public String getID(){
        return showtimeId;
    }
}