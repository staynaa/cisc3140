//lab2 part 1.6
import java.util.Calendar;
import java.util.*;
import java.util.Scanner;

public class countdown { 
    Calendar cur;
    Calendar day;

    countdown(int year, int month, int date, int hour, int min, int sec) { // for anyday
        cur = Calendar.getInstance();
        day = Calendar.getInstance();
        day.set(year, month, date, hour, min, sec);
    }

    public int inBtw(Date current, Date due) { // difference between current date and due date
        return (int) ((due.getTime() - current.getTime()) / (1000 * 60 * 60 * 24)); // milliseconds in a day: 86400000
    }

    public void setCur(int month, int date, int year) {
        cur.set(year, month, date, 0, 0, 0);
    }

    public Calendar getCur() {
        return cur;
    }

    public void setDay(int year, int month, int date) {
        day.set(year, month, date, 0, 0, 0);
    }

    public Calendar getDay() {
        return day;
    }

    public String toString(String item) {
        int days = inBtw(cur.getTime(), day.getTime());
        if (days > 1) return "There are " + days + " days until " + item + " on --> " + day.getTime() + ".";
        else if (days == 1) return "One more day until " + item + " on --> " + day.getTime() + ".";
        else if (days == 0) return item + " will happen in less than 24 hours. ";
        else return item + " has passed. ";
    }
    // toString made for 1.1
    public String toString(Date d2) { // d2 is the future date
        Date first = day.getTime(); // store objects' date in two variables
        Date second = d2;
        int days = inBtw(second, first);
        if (days >= 0) return "There are " + days + " days between " + first + " and " + second;
        return "No days left between the two dates";
    }
    // Main
    public static void main(String args[]) {
        /*
         * plan 1.1:
         * make two countdown objects
         * then call the toString, send 2nd object as parameter
         * have to string call inbtw
         * reminder** months go from 0-11 instead of 1-12
         */
        Calendar current = Calendar.getInstance(); // today
        // LABS
        countdown lab1 = new countdown(2022, 8, 28, 15, 30, 0); // lab 1 9/28
        countdown lab2 = new countdown(2022, 9, 28, 15, 30, 0); // lab 2 10/28
        countdown lab3 = new countdown(2022, 10, 23, 15, 30, 0); // lab 3 11/23
        countdown lab4 = new countdown(2022, 11, 7, 15, 30, 0); // lab 4 12/7
        // QUIZ
        countdown quiz1 = new countdown(2022, 8, 14, 14, 15, 0); // q1 9/14
        countdown quiz2 = new countdown(2022, 8, 28, 14, 15, 0); // q2 9/28
        countdown quiz3 = new countdown(2022, 9, 26, 14, 15, 0); // q3 10/26
        countdown quiz4 = new countdown(2022, 10, 16, 14, 15, 0); // q4 11/16
        countdown quiz5 = new countdown(2022, 11, 7, 2, 15, 0); // q5 12/7
        // FINAL
        countdown finalExam = new countdown(2022, 11, 19, 13, 0, 0); // final 12/19
        // Random date
        countdown date1 = new countdown(2022, 1, 1, 0, 0, 0);
        int mon, day, year;
        String userDate;
        int[] dateInt;
        char[] dateChar;
        Scanner input = new Scanner(System.in);
        /*comments for 1115 student: Here you can create a file and PrintWriter object:
            File file= new File("<FileName>") 
            PrintWriter out= new PrintWriter(file)
            in the if statements/while loop instead of printing to console(System.out.print),
            write to the out file using :
            out.write(".......") 
            this'll print the results you want onto file
            in the end, close the writer with out.close() like how you close a scanner
        */

        /*
         * Plan 1.2
         * ask user to choose A B C D or E
         * change the first toString in the class to accept a string parameter instead
         * only use one constuctor
         * 
         * Plan 1.3
         * if user chose D, let user know what format to enter the date
         * it'll be taken in as an string and turned into a char array
         * possibly use a for loop to loop through array till end,
         * if next element !="/" or !="-"
         */
        System.out.println("---------\nCurrent Day set to " + current.getTime()
                + "\n---------\nWelcome to Countdown, this program calculates the difference between days.\nPick an option: ");
        System.out.print(
                "Type '1' to change current date\nA) Lab Dates\nB) Quiz Dates\nC) Final Exam Date\nD) Manually Enter Date\nType 'E' to exit.\nYour Choice: ");
        char choice = input.next().charAt(0);
        while (choice != 'E' && choice != 'e') { // while loop to ask user until they exit
            if (choice == '1') {
                System.out.println("Month: ");
                mon = input.nextInt() - 1;
                System.out.println("Day: ");
                day = input.nextInt();
                System.out.println("Year: ");
                year = input.nextInt();

                lab1.setCur(mon, day, year);
                lab2.setCur(mon, day, year);
                lab3.setCur(mon, day, year);
                lab4.setCur(mon, day, year);
                quiz1.setCur(mon, day, year);
                quiz2.setCur(mon, day, year);
                quiz3.setCur(mon, day, year);
                quiz4.setCur(mon, day, year);
                quiz5.setCur(mon, day, year);
                finalExam.setCur(mon, day, year);
                date1.setCur(mon, day, year);
                System.out.println("---------\nYou changed current Day to " + lab1.getCur().getTime());
            }

            if (choice == 'A' || choice == 'a') { // Labs
                System.out.println("---------");
                System.out.println(lab1.toString("Lab 1"));
                System.out.println(lab2.toString("Lab 2"));
                System.out.println(lab3.toString("Lab 3"));
                System.out.println(lab4.toString("Lab 4"));
            } else if (choice == 'B' || choice == 'b') { // Quiz
                System.out.println("---------");
                System.out.println(quiz1.toString("Quiz 1"));
                System.out.println(quiz2.toString("Quiz 2"));
                System.out.println(quiz3.toString("Quiz 3"));
                System.out.println(quiz4.toString("Quiz 4"));
                System.out.println(quiz5.toString("Quiz 5"));
            } else if (choice == 'C' || choice == 'c') { // Final
                System.out.println("---------");
                System.out.println(finalExam.toString("the Final"));
            } else if (choice == 'D' || choice == 'd') { // Own Date
                System.out.println("Enter Date in either format\nMM/DD/YY\tMM/DD");
                userDate = input.next();
                // check format
                while ((!userDate.contains("/")) &&
                        (userDate.length() != 8 || userDate.length() != 4)) {
                    System.out.println("ERROR, wrong format entered...\nTry again:\nMM/DD/YY\tMM/DD");
                    userDate = input.next();
                }
                dateChar = userDate.toCharArray(); // turn to character array

                dateInt = giveDate(dateChar); // send to function that'll get the mon day and year
                // DEBUG if (dateInt.length==3) System.out.println(dateInt[0]+", "+dateInt[1]+
                // ", "+dateInt[2]);
                mon = dateInt[0] - 1;
                day = dateInt[1];
                year = 2000 + dateInt[2];
                date1.setDay(year, mon, day);
                System.out.println("Date entered--> " + date1.getDay().getTime());
                System.out.println("---------");
                System.out.println(date1.toString(date1.cur.getTime()));

            }
            System.out.print(
                    "---------\nType '1' to change current date\nA) Lab Dates\nB) Quiz Dates\nC) Final Exam Date\nD) Manually Enter Date\nType 'E' to exit.\nYour Choice: ");
            choice = input.next().charAt(0);
        }
        System.out.println("---------\nYou have exited the program");
        input.close();
    }

    // array that will contain month date and year in seperate indexes
    public static int[] giveDate(char arr[]) {
        int a[] = new int[3];
        int ind = 0;
        int res;
        for (int i = 0; i < arr.length; i++) {
            res = 0;
            if (arr[i] != '/') {
                res = (res * 10) + (arr[i] - '0');
                res = res * 10 + (arr[i + 1] - '0');
                a[ind] = res;
                i += 1;// skip the element we just stored in a[i+1], if at i=0, this will go to i=1
                ind++;
            }
        }
        if (arr.length != 8) {
            if (a[0] >= 1 && a[0] < 10)
                a[2] = 23;
            else
                a[2] = 22;
        }
        return a;
    }
}