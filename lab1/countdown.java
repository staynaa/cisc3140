import java.util.Calendar;
import java.util.*;

public class countdown {
    Calendar cur;
    Calendar lab;
    countdown(){
        cur= Calendar.getInstance();
    }
    countdown(int year, int month, int date){
        cur= Calendar.getInstance();
        lab= Calendar.getInstance();
        lab.set(year, month, date, 15, 30, 00); //3:30:00pm
    }
    public Calendar getCur() {
        return cur;
    }
    public int inBtw(Date current, Date due){ //difference between current date and due date
        return (int)( (due.getTime() - current.getTime()) / (1000 * 60 * 60 * 24));
    }
    public String toString(int labNum){
        int days= inBtw(cur.getTime(),lab.getTime());
        if(days>1) return "Lab " + labNum + " is due in " + days +" days on "+ lab.getTime();
        else if (days==1) return "Lab " + labNum + " is due in " + days +" day on "+ lab.getTime();
        else if(days==0) return "Lab "+ labNum + " is due in less than 24 hours";
        else return "Lab " + labNum + " is past due";
    }
    //Main
    public static void main(String args[]){
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
    }
}
