/*
NOTE: 

Here, on this problem, I preffered writing in Java NBeans because I had some problems testing C# solution 
with Unit Testing in .NET enviroment. Hence, please check out my C# written solution, attached on my github,
just to let you know that I am interested and also code in C#.NET.
*/
package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    
    public static void main(String[] args) {
        Result result=JUnitCore.runClasses(HotelTest.class);
        for(Failure failure:result.getFailures())
            System.out.println(failure.toString());
    }
}
