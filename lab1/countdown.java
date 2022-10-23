//lab2 part 1.2
import java.util.Calendar;
import java.util.*;
import java.util.Scanner;

public class countdown {
    Calendar cur;
    Calendar lab;
    Calendar day;

    countdown() { // for current day
        cur = Calendar.getInstance();
    }

    countdown(int year, int month, int date, int hour, int min, int sec) { // for anyday
        cur = Calendar.getInstance();
        day = Calendar.getInstance();
        day.set(year, month, date, hour, min, sec);
    }
/*
    countdown(int year, int month, int date) { // for labs
        cur = Calendar.getInstance();
        lab = Calendar.getInstance();
        lab.set(year, month, date, 15, 30, 00); // 3:30:00pm
    }
*/
    public void setCur(){

    }
    public Calendar getCur() {
        return cur;
    }

    public int inBtw(Date current, Date due) { // difference between current date and due date
        return (int) ((due.getTime() - current.getTime()) / (1000 * 60 * 60 * 24)); // milliseconds in a day: 86400000
    }

    public String toString(String item) {
        int days = inBtw(cur.getTime(), day.getTime());
        if (days > 1)
            return "There are " + days + " days until " + item +" on --> " + day.getTime() + ".";
        else if (days == 1)
            return "One more day until " + item + " on --> " + day.getTime() + ".";
        else if (days == 0)
            return item + " will happen in less than 24 hours. ";
        else
            return item + " has passed. ";
    }

    // toString made for 1.1
    public String toString(Date d2) { // d2 is the future date
        Date first = day.getTime(); // store objects' date in two variables
        Date second = d2;
        int days = inBtw(second, first);
        if (days >= 0)
            return "There are " + days + " days between " + first + " and " + second;
        return "No days left between the two dates";
    }

    // Main
    public static void main(String args[]) {
        // inBtw function from lab1 already takes two dates and returns an int of the
        // days between them
        /*
         * plan 1.1:
         * make two countdown objects
         * then call the toString, send 2nd object as parameter
         * have to string call inbtw
         * reminder** months go from 0-11 instead of 1-12
         */
        // countdown date1= new countdown(2023, 9, 30, 0, 0, 0); //10/30/22
        // countdown date2= new countdown(2023, 5, 13, 0, 0, 0);
        // System.out.println(date1.toString(date2));
        Calendar current = Calendar.getInstance(); // today
        //LABS
        countdown lab1 = new countdown(2022, 8, 28, 15, 30, 0); // lab 1 9/28
        countdown lab2 = new countdown(2022, 9, 28, 15, 30, 0); // lab 2 10/28
        countdown lab3 = new countdown(2022, 10, 23, 15, 30, 0); // lab 3 11/23
        countdown lab4 = new countdown(2022, 11, 7, 15, 30, 0); // lab 4 12/7
        //QUIZ
        countdown quiz1 = new countdown(2022, 8, 14, 14, 15, 0); // q1 9/14
        countdown quiz2 = new countdown(2022, 8, 28, 14, 15, 0); // q2 9/28
        countdown quiz3 = new countdown(2022, 9, 26, 14, 15, 0); // q3 10/26
        countdown quiz4 = new countdown(2022, 10, 16, 14, 15, 0); // q4 11/16
        countdown quiz5 = new countdown(2022, 11, 7, 2, 15, 0); // q5 12/7
        //FINAL
        countdown finalExam = new countdown(2022,11,19,13,0,0); //final 12/19
        //Random date
        countdown date1;
        int mon, day, year;

        /* Plan 1.2
        ask user to choose A B C D or E
        change the first toString in the class to accept a string parameter instead
        only use one constuctor 
        */

        System.out.println("---------\nNow it is: " + current.getTime());
        System.out.println(
                "Welcome to Countdown, this program calculates the difference between days.\nPick an option: ");
        System.out
                .println("A) Lab Dates\nB) Quiz Dates\nC) Final Exam Date\nD) Manually Enter Date\nType 'E' to exit.");
        Scanner input = new Scanner(System.in);
        char choice = input.next().charAt(0); // read in user input which is a character
        if (choice == 'A' || choice == 'a') { // Labs
            System.out.println(lab1.toString("Lab 1"));
            System.out.println(lab2.toString("Lab 2"));
            System.out.println(lab3.toString("Lab 3"));
            System.out.println(lab4.toString("Lab 4"));
        } else if (choice == 'B' || choice == 'b') { // Quiz
            System.out.println(quiz1.toString("Quiz 1"));
            System.out.println(quiz2.toString("Quiz 2"));
            System.out.println(quiz3.toString("Quiz 3"));
            System.out.println(quiz4.toString("Quiz 4"));
            System.out.println(quiz5.toString("Quiz 5"));
        } else if (choice == 'C' || choice == 'c') { // Final
            System.out.println(finalExam.toString("the Final"));
        } else if (choice == 'D' || choice == 'd') { // Own Date
            System.out.println("Enter Month (ex 1 for Jan): ");
            mon= input.nextInt() - 1;
            System.out.println("Enter Day: ");
            day= input.nextInt();
            System.out.println("Enter Year: ");
            year= input.nextInt();
            date1= new countdown(year,mon,day,0,0,0);
            System.out.println("Date entered--> "+ date1.day.getTime());
            System.out.println(date1.toString(date1.cur.getTime()));

        } else if (!(choice == 'E') || !(choice == 'e')) {
            System.out.println("Goodbye");
        }
        input.close();
    }
}
