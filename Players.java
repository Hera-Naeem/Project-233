package com.example.demo3;

import java.util.ArrayList;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

/**
 * This creates player objects with different information, and it called to get each information.
 */


public class Players {
    //list of class or instance variables

    private final Team teamName;
    private final String playerName;
    private final String playerNationality;
    private final int playerAge;
    private final String playerStyle;

    private final int playerNumber;

    //constructor of Players class
    Players (Team team, String Name, String Nationality, int Age, String Playstyle, int JerseyNumber){
        this.teamName = team;
        this.playerName = Name;
        this.playerNationality = Nationality;
        this.playerAge = Age;
        this.playerStyle = Playstyle;
        this.playerNumber = JerseyNumber;
    }

    //lines 21-44 are all getter functioncs which are used to retrieve the stuff from the instance variable
    public String getTeamName(){
        return this.teamName.getName();
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public int getAge(){
        return this.playerAge;
    }

    public String getPlayerNationality(){
        return this.playerNationality;
    }

    public String getPlayerStyle(){
        return this.playerStyle;
    }

    public int getJerseyNumber(){
        return this.playerNumber;
    }

    /**
    *this function is the String object output of the player name, team name, and jersey number.
    */
    public String playerIdentity(){

        return String.valueOf(this.playerName + " " + this.teamName + " " + this.playerNumber);
    }

    /**
    *this function is used to print out the for all special output
    */
    public String allToString() {
        return "Player name is " + this.playerName + ", and plays for " + this.teamName.getName();
    }
}
