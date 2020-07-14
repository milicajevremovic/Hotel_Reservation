using System;
using System.Collections.Generic;
using System.Text;

namespace Room_Reservation_Sys
{
    class Reservation
    {
        int end;
        int start;
        string status;

        public Reservation(int start, int end)
        {
            Start = start;
            End = end;
        }

        public int End { get => end; set => end = value; }
        public int Start { get => start; set => start = value; }
        public string Status { get => status; set => status = value; }

    public override string ToString()
        {
            return "Start Date: "+Start+" | End Date: "+End+" | RESULT STATUS: "+Status;
        }
    }
}
