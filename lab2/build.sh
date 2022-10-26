#!/usr/bin/env bash
javac countdown.java
#user input
echo Enter file you want to send to java program: 
read input
java countdown < $input