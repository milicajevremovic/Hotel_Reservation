/*NOTE: 
Here, on this problem, I preffered writing in Java NBeans because I had some problems testing C# solution 
with Unit Testing in .NET enviroment. Hence, please check out my C# written solution, attached on my github,
just to let you know that I am interested and also code in C#.NET.
*/
package tests;

import domain.Hotel;
import domain.Reservation;
import domain.Status;
import org.junit.Test;
import static org.junit.Assert.*;


public class HotelTest {
    
    @Test
    public void requestOutsidePlaningPeriod(){
        Reservation reservation1=new Reservation(-4, 2);
        Reservation reservation2=new Reservation(200,400);
        Hotel hotel=new Hotel(1);
        
        hotel.bookReservation(reservation1);
        hotel.bookReservation(reservation2);
        
        assertEquals("Reservation status must be declined for start date "+reservation1.getStart()+" and end date "+reservation1.getEnd()+" because it is outside our planing period"
                , Status.Declined, reservation1.getStatus());
        assertEquals("Reservation status must be declined for start date "+reservation2.getStart()+" and end date "+reservation2.getEnd()+" because it is outside our planing period"
                , Status.Declined, reservation2.getStatus());
    }
    
    @Test
    public void acceptedRequests(){
        Hotel hotel=new Hotel(3);
        
        Reservation reservation1=new Reservation(0, 5);
        Reservation reservation2=new Reservation(7, 13);
        Reservation reservation3=new Reservation(3, 9);
        Reservation reservation4=new Reservation(5, 7);
        Reservation reservation5=new Reservation(6, 6);
        Reservation reservation6=new Reservation(0, 4);
        
        hotel.bookReservation(reservation1);
        hotel.bookReservation(reservation2);
        hotel.bookReservation(reservation3);
        hotel.bookReservation(reservation4);
        hotel.bookReservation(reservation5);
        hotel.bookReservation(reservation6);
        
        
        assertEquals("All requests in this test must be accepted",Status.Accepted, reservation1.getStatus());
        assertEquals("All requests in this test must be accepted",Status.Accepted, reservation2.getStatus());
        assertEquals("All requests in this test must be accepted",Status.Accepted, reservation3.getStatus());
        assertEquals("All requests in this test must be accepted",Status.Accepted, reservation4.getStatus());
        assertEquals("All requests in this test must be accepted",Status.Accepted, reservation5.getStatus());
        assertEquals("All requests in this test must be accepted",Status.Accepted, reservation6.getStatus());
    }
    
    @Test
    public void requestDeclined(){
        Hotel hotel=new Hotel(3);
        
        Reservation reservation1=new Reservation(1, 3);
        Reservation reservation2=new Reservation(2, 5);
        Reservation reservation3=new Reservation(1, 9);
        Reservation reservation4=new Reservation(0, 15);
        
        hotel.bookReservation(reservation1);
        hotel.bookReservation(reservation2);
        hotel.bookReservation(reservation3);
        hotel.bookReservation(reservation4);
        
        
        assertEquals("First reservation in this test must be accepted",Status.Accepted, reservation1.getStatus());
        assertEquals("Second reservation in this test must be accepted",Status.Accepted, reservation2.getStatus());
        assertEquals("Third reservation in this test must be accepted",Status.Accepted, reservation3.getStatus());
        assertEquals("Fourth reservation in this test must be declined",Status.Declined, reservation4.getStatus());
        
    }
    
    @Test
    public void requestAcceptedAfterDecline(){
        Hotel hotel=new Hotel(3);
        
        Reservation reservation1=new Reservation(1, 3);
        Reservation reservation2=new Reservation(0, 15);
        Reservation reservation3=new Reservation(1, 9);
        Reservation reservation4=new Reservation(2, 5);
        Reservation reservation5=new Reservation(4, 9);
        
        hotel.bookReservation(reservation1);
        hotel.bookReservation(reservation2);
        hotel.bookReservation(reservation3);
        hotel.bookReservation(reservation4);
        hotel.bookReservation(reservation5);
        
        assertEquals("First reservation in this test must be accepted",Status.Accepted, reservation1.getStatus());
        assertEquals("Second reservation in this test must be accepted",Status.Accepted, reservation2.getStatus());
        assertEquals("Third reservation in this test must be accepted",Status.Accepted, reservation3.getStatus());
        assertEquals("Fourth reservation in this test must be declined",Status.Declined, reservation4.getStatus());
        assertEquals("Fifth reservation in this test must be accepted",Status.Accepted, reservation5.getStatus());

    }
    
    @Test
    public void complexRequest(){
        Hotel hotel=new Hotel(2);
        
        Reservation reservation1=new Reservation(1, 3);
        Reservation reservation2=new Reservation(0, 4);
        Reservation reservation3=new Reservation(2, 3);
        Reservation reservation4=new Reservation(5, 5);
        Reservation reservation5=new Reservation(4, 10);
        Reservation reservation6=new Reservation(10,10);
        Reservation reservation7=new Reservation(6, 7);
        Reservation reservation8=new Reservation(8, 10);
        Reservation reservation9=new Reservation(8, 9);
        
        hotel.bookReservation(reservation1);
        hotel.bookReservation(reservation2);
        hotel.bookReservation(reservation3);
        hotel.bookReservation(reservation4);
        hotel.bookReservation(reservation5);
        hotel.bookReservation(reservation6);
        hotel.bookReservation(reservation7);
        hotel.bookReservation(reservation8);
        hotel.bookReservation(reservation9);
        
        assertEquals("First reservation in this test must be accepted",Status.Accepted, reservation1.getStatus());
        assertEquals("Second reservation in this test must be accepted",Status.Accepted, reservation2.getStatus());
        assertEquals("Third reservation in this test must be declined",Status.Declined, reservation3.getStatus());
        assertEquals("Fourth reservation in this test must be accepted",Status.Accepted, reservation4.getStatus());
        assertEquals("Fifth reservation in this test must be accepted",Status.Declined, reservation5.getStatus());
        assertEquals("Sixth reservation in this test must be accepted",Status.Accepted, reservation6.getStatus());
        assertEquals("Seventh reservation in this test must be accepted",Status.Accepted, reservation7.getStatus());
        assertEquals("Eighth reservation in this test must be accepted",Status.Accepted, reservation8.getStatus());
        assertEquals("Ninth reservation in this test must be accepted",Status.Accepted, reservation9.getStatus());
    
    }
}
