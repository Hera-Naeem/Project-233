package com.example.demo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

class PlayersTest {

    private Team playerTeam;
    private String playerName;
    private String playerNationality;
    private int playerAge;
    private String playerPlaystyle;
    private int playerNumber;
    Players newPlayer = new Players(playerTeam, playerName, playerNationality, playerAge, playerPlaystyle, playerNumber);

    /**
     * this function test is for printing the name of the team name
     */
    @Test
    void PlayerTeam(){
        String team = "Barcelona";
        Team teamName = new Team(team);
        Players newPlayers = new Players(teamName, "Messi", "Argentina", 33, "Passive", 10);
        System.out.println(newPlayers.getTeamName());
    }

    /**
     * this function test is for printing the player name
     */
    @Test
    void PlayerName() {
        String team = "Barcelona";
        Team teamName = new Team(team);
        String name = "Messi";
        Players newPlayers = new Players(teamName, name, "Argentina", 33, "Passive", 10);
        System.out.println(newPlayers.getPlayerName());
    }

    /**
     * this function test is for printing the player's nationality
     */
    @Test
    void PlayerNationality(){
        String team = "Barcelona";
        Team teamName = new Team(team);
        String name = "Messi";
        String nationality = "Argentina";
        Players newPlayers = new Players(teamName, name, nationality, 33, "Passive", 10);
        System.out.println(newPlayers.getPlayerNationality());
    }

    /**
     * this function test is for printing the player's age
     */
    @Test
    void Age() {
        String team = "Barcelona";
        Team teamName = new Team(team);
        String name = "Messi";
        String nationality = "Argentina";
        int age = 33;
        Players newPlayers = new Players(teamName, name, nationality, age, "Passive", 10);
        System.out.println(newPlayers.getAge());
    }

    /**
     * this function test is for printing the player's play style
     */
    @Test
    void PlayStyle(){
        String team = "Barcelona";
        Team teamName = new Team(team);
        String name = "Messi";
        String nationality = "Argentina";
        int age = 33;
        String style = "Passive";
        Players newPlayers = new Players(teamName, name, nationality, age, style,10);
        System.out.println(newPlayers.getPlayerStyle());
    }

    /**
     * this function test is for printing the player's jersey number
     */
    @Test
    void JerseyNumber(){
        String team = "Barcelona";
        Team teamName = new Team(team);
        String name = "Messi";
        String nationality = "Argentina";
        int age = 33;
        String style = "Passive";
        int js = 10;
        Players newPlayers = new Players(teamName, name, nationality, age, style, js);
        System.out.println(newPlayers.getJerseyNumber());
    }
}
