/*NOTE: 
Here, on this problem, I preffered writing in Java NBeans because I had some problems testing C# solution 
with Unit Testing in .NET enviroment. Hence, please check out my C# written solution, attached on my github,
just to let you know that I am interested and also code in C#.NET.
*/
package domain;

public class Reservation {
    private int start;
    private int end;
    private Status status;

    public Reservation() {
    }

    public Reservation(int start, int end) {
        this.start = start;
        this.end = end;
        this.status = status;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Start date: "+start+"| End date: "+end+"| Status: "+status.toString();
    }
    
    
}
