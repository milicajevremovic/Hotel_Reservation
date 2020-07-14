/*NOTE: 
Here, on this problem, I preffered writing in Java NBeans because I had some problems testing C# solution 
with Unit Testing in .NET enviroment. Hence, please check out my C# written solution, attached on my github,
just to let you know that I am interested and also code in C#.NET.
*/
package domain;

import java.util.LinkedList;
import java.util.List;

public class Hotel {
    
    private List<Reservation> reservationList;
    private boolean[][] bookedRooms;
    private int size;

    public Hotel(int size) {
        this.size=size;
        bookedRooms=new boolean [size][365];
        reservationList=new LinkedList<>();
    }
    
    public void bookReservation(Reservation reservation){
        if(reservation.getStart()<0 || reservation.getStart()>364 || reservation.getEnd()<0 || reservation.getEnd()>364 || reservation.getStart()>reservation.getEnd())
            reservation.setStatus(Status.Declined);
        else{
            for(int room=0;room<size;room++){
                boolean freeRoom=true;
                for(int day=reservation.getStart();day<=reservation.getEnd();day++){
                    if(bookedRooms[room][day]==true)
                        freeRoom=false;
                }
                if(freeRoom){
                    bookRoom(room,reservation);
                    return;
                }
            }
            reservation.setStatus(Status.Declined);
        }
    }

    private void bookRoom(int room, Reservation reservation) {
        for(int day=reservation.getStart();day<=reservation.getEnd();day++)
            bookedRooms[room][day]=true;
        reservation.setStatus(Status.Accepted);
        reservationList.add(reservation);
    }
    
    
}
