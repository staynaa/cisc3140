#!/usr/bin/env bash
#used repl.it to run this script because mac was not able to
Current=$(date +%s) #current date
echo Today is $Current 
echo -e "---------\nWelcome to Countdown, this program calculates the difference between days.\nPick an option:"
echo -e "A)Labs\nB)Quizzes\nC)Final Exam\nD)Manual Date\nE)Exit Program"
echo "Your Choice--> "
read Choice
clear
#all date variables:
#labs
Lab1=$(( ($(date -d "2022-9-28" +%s) - $(date +%s) )/(60*60*24) )) 
Lab2=$(( ($(date -d "2022-10-26" +%s) - $(date +%s) )/(60*60*24) )) 
Lab3=$(( ($(date -d "2022-11-23" +%s) - $(date +%s) )/(60*60*24) )) 
Lab4=$(( ($(date -d "2022-12-7" +%s) - $(date +%s) )/(60*60*24) )) 
#quiz
Q1=$(( ($(date -d "2022-9-14" +%s) - $(date +%s) )/(60*60*24) )) 
Q2=$(( ($(date -d "2022-9-28" +%s) - $(date +%s) )/(60*60*24) )) 
Q3=$(( ($(date -d "2022-10-26" +%s) - $(date +%s) )/(60*60*24) )) 
Q4=$(( ($(date -d "2022-11-16" +%s) - $(date +%s) )/(60*60*24) )) 
Q5=$(( ($(date -d "2022-12-7" +%s) - $(date +%s) )/(60*60*24) )) 
#final
final=$(( ($(date -d "2022-12-19" +%s) - $(date +%s) )/(60*60*24) ))
#function to calculate date difference/ like inBtw in the java program
dateDiff () {
    day=$1
    if ((day > 0))
      then
        day=$((day+1))
        echo $day days left "until" $2
    elif ((day < 0))
      then 
        echo $2 has passed
    elif ((day == 0))
      then 
        echo $2 is "in" less than 24 hours
    fi
}

while [[ $Choice != 'E' && $Choice != 'e' ]]
do 
    echo You picked option $Choice
    if [[ $Choice == 'A' || $Choice == 'a' ]] 
    then 
      echo LABS
      dateDiff $Lab1 "Lab 1"
      dateDiff $Lab2 "Lab 2"
      dateDiff $Lab3 "Lab 3"
      dateDiff $Lab4 "Lab 4"
    elif [[ $Choice == 'B' || $Choice == 'b' ]] 
      then 
        echo QUIZZES
        dateDiff $Q1 "Quiz 1"
        dateDiff $Q2 "Quiz 2"
        dateDiff $Q3 "Quiz 3"
        dateDiff $Q4 "Quiz 4"
        dateDiff $Q5 "Quiz 5"
    elif [[ $Choice == 'C' || $Choice == 'c' ]] 
      then 
        echo "FINAL"
        dateDiff $final "the Final Exam"
    elif [[ $Choice == 'D' || $Choice == 'd' ]] 
      then 
        echo Manual Date
        echo Enter Date: YYYY-MM-DD
        read date1
        var=$(( ($(date -d $date1 +%s) - $(date +%s) )/(60*60*24) ))
        dateDiff $var "Date entered"
    else
      echo "ERROR: Did not choose from the options (A B C D or E) Try Again"
    fi
    echo -e "\nA)Labs\nB)Quizzes\nC)Final Exam\nD)Manual Date\nE)Exit Program"
    echo -e "\nYour Choice--> "
    read Choice 
    clear
done
echo -e "Program Exited\n---------\nGoodbye"