using System;
using System.Collections.Generic;
using System.Text;

namespace Room_Reservation_Sys
{
    class Program
    {
        public List<Reservation> ReservationList;
        public bool[,] bookedRooms;
        public int size;
        public void Lets_Book(Reservation res)
        {
            if (res.Start < 0 || res.End > 364 || res.End < 0 || res.End > 364 || res.Start > res.End)
            {
                res.Status = "Declined";
                return; 
            }
            for (int room = 0; room < size; room++)
            {
                bool freeRoom = true;
                for (int day = res.Start; day <= res.End; day++)
                {
                    if (bookedRooms[room, day] == true)
                        freeRoom = false;
                }
                if (freeRoom)
                {
                    Book_This_Room(room, res);
                    return; 
                }
            }
            res.Status = "Declined";
           
        }

        public void Book_This_Room(int room, Reservation res)
        {
            for (int day = res.Start; day <= res.End; day++)
                bookedRooms[room, day] = true;
            res.Status = "Accepted";
        }


        public void ShowReservations(List<Reservation> reservationList)
        {
            int bookingNo = 0;
            foreach (Reservation r in reservationList)
            {
                Lets_Book(r);
                bookingNo++;
                Console.WriteLine("Booking: {0} | {1}", bookingNo, r.ToString());
            }
        }

        static void Main(string[] args)
        {
            Console.WriteLine("\n\nNOTE:\n I have also submitted this C# solution because it is your prefered language. My final project is written in Java, which is fully autotested and works fine, so this .NET solution is just my code work, I preffered writing in Java programming language because I had some issues testing C# solution with Unit Testing in .NET enviroment. \n\n");
           
        }
    }
}
