package com.example.demo3;

import java.util.Objects;
import java.util.Scanner;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

/**
 * This creates a Team object from a string name.
 * Has an equals() method that compares one object to the other.
 */

public class Team {

    private static final Scanner scanner = new Scanner(System.in); //used to get input from the user

    private String teamName; //instance or class variable

    //constructor for Team class
    Team (String name){
        this.teamName = name;
    }

    //getter function that gets the team name from the instance variable
    public String getName(){
        return this.teamName;
    }

    /**
    * this function is used to compare the two string objects based on the content of the two strings
    */
    public boolean equals(Team obj) {
        return Objects.equals(this.teamName, obj.teamName);
    }

    /**
    * this function returns the string representation of team name
    */
    public String toString(){
        return this.teamName;
    }
}
