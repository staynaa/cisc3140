//lab2 part 1.1
import java.util.Calendar;
import java.util.*;

public class countdown {
    Calendar cur;
    Calendar lab;
    Calendar day;
    countdown(){ //for current day
        cur= Calendar.getInstance();
    }
    countdown(int year,int month, int date,int hour, int min, int sec){ // for anyday
        day= Calendar.getInstance();
        day.set(year,month,date,hour,min,sec);
    }
    countdown(int year, int month, int date){ //for labs
        cur= Calendar.getInstance();
        lab= Calendar.getInstance();
        lab.set(year, month, date, 15, 30, 00); //3:30:00pm
    }
    public Calendar getCur() {
        return cur;
    }
    public int inBtw(Date current, Date due){ //difference between current date and due date
        return (int)( (due.getTime() - current.getTime()) / (1000 * 60 * 60 * 24)); //milliseconds in a day: 86400000
    }
    public String toString(int labNum){
        int days= inBtw(cur.getTime(),lab.getTime());
        if(days>1) return "Lab " + labNum + " is due in " + days +" days on "+ lab.getTime();
        else if (days==1) return "Lab " + labNum + " is due in " + days +" day on "+ lab.getTime();
        else if(days==0) return "Lab "+ labNum + " is due in less than 24 hours";
        else return "Lab " + labNum + " is past due";
    }
    //toString made for 1.1
    public String toString(countdown d2){ //d2 is the future date
        Date first= day.getTime(); //store objects' date in two variables 
        Date second= d2.day.getTime();
        int days= inBtw(first,second);
        if (days>=0) return "There are "+ days +" days between "+ first +" and "+ second;
        return "No days left between the two dates";
    }

    //Main
    public static void main(String args[]){
//inBtw function from lab1 already takes two dates and returns an int of the days between them
        /*plan 1.1:
            make two countdown objects
            then call the toString, send 2nd object as parameter
            have to string call inbtw 
            reminder** months go from 0-11 instead of 1-12
        */
        countdown date1= new countdown(2023, 9, 30, 0, 0, 0); //10/30/22
        countdown date2= new countdown(2023, 5, 13, 0, 0, 0); 
        System.out.println(date1.toString(date2));






/* LAB1:

        Calendar current= Calendar.getInstance(); //today
        countdown lab1= new countdown(2022, 8, 28); //lab 1 9/28
        countdown lab2= new countdown(2022, 9, 28); //lab 2 10/28
        countdown lab3= new countdown(2022, 10, 23); //lab 3 11/23
        countdown lab4= new countdown(2022, 11, 7); //lab 4 12/7
        System.out.println("Now it is: " + current.getTime());
        System.out.println(lab1.toString(1));
        System.out.println(lab2.toString(2));
        System.out.println(lab3.toString(3));
        System.out.println(lab4.toString(4));

*/
    }
}
