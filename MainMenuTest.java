package com.example.demo3;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

class MainMenuTest {

    /**
     * this function tests by adding team names to that already have been added to the com.example.demo3.Team ArrayList
     */
    @Test
    void AddingTeamsAlreadyAdded() {
        ArrayList<Team> allTeams = new ArrayList<Team>();
        Team x = new Team("Barcelona");
        Team y = new Team("Liverpool");
        allTeams.add(x);
        allTeams.add(y);

        int count = 0;
        Team obj = new Team("Barcelona");

        if (allTeams.isEmpty()) {
            allTeams.add(obj);
        } else {
            for (int i = 0; i < allTeams.size(); i++) {
                if (allTeams.get(i).equals(obj)) {
                    count += 1;

                }
            }
            if (count >= 1) {
                System.out.println("This team has already been added!");
            } else {
                allTeams.add(obj);
            }

        }
        System.out.println(allTeams);
    }

    /**
     * this function tests by adding new teams to com.example.demo3.Team ArrayList with already existing objects.
     */
    @Test
    void AddingNewTeams() {
        ArrayList<Team> allTeams = new ArrayList<Team>();
        Team x = new Team("Barcelona");
        Team y = new Team("Liverpool");
        allTeams.add(x);
        allTeams.add(y);

        int count = 0;
        Team obj = new Team("Bayern Munich");

        if (allTeams.isEmpty()) {
            allTeams.add(obj);
        } else {
            for (int i = 0; i < allTeams.size(); i++) { //loops through each element in the team array
                if (allTeams.get(i).equals(obj)) {
                    count += 1;

                }
            }
            if (count >= 1) {
                System.out.println("This team has already been added!");
            } else {
                allTeams.add(obj);
            }

        }
        System.out.println(allTeams);
    }

    /**
     * this function tests by creating new player objects and adding it to player stats HashMap
     */
    @Test
    void AddingNewPlayers() {
        ArrayList<Players> allPlayers = new ArrayList<Players>();
        HashMap<String, Double> allPlayerStats = new HashMap<String, Double>();

        Team playerTeam = new Team("Paris Saint-Germain");
        String playerName = "Neymar";
        String playerNationality = "Brazilian";
        int playerAge = 26;
        String playerPlaystyle = "Passive";
        int playerNumber = 10;
        double KDARatio = 30.56;

        Players newPlayer = new Players(playerTeam, playerName, playerNationality, playerAge, playerPlaystyle, playerNumber);

        allPlayerStats.put(playerName + " " + playerTeam + " " + playerNumber, KDARatio);

        allPlayers.add(newPlayer);

        System.out.println(allPlayerStats);
        System.out.println(allPlayers.get(0).allToString());
    }

    /**
     * this function tests by looping each element in Player ArrayList
     */
    @Test
    void LoopingThroughPlayerObjects() {
        ArrayList<Players> allPlayers = new ArrayList<Players>();
        Team teamName = new Team("Real Madrid");

        Players p1 = new Players(teamName, "Benzema", "French", 33, "Agressive", 19);
        Players p2 = new Players(teamName, "Luka Modric", "Croatian", 35, "Passive", 10);

        allPlayers.add(p1);
        allPlayers.add(p2);

        for (int x = 0; x < allPlayers.size(); x++) {
            System.out.println(allPlayers.get(x).getPlayerName());
        }
    }

    /**
     * this function tests by looping each element in TeamArrayList
     */
    @Test
    void LoopingThroughTeams() {
        ArrayList<Team> team;
        team = new ArrayList<Team>();
        Team t1 = new Team("Barcelona");
        Team t2 = new Team("Real Madrid");
        Team t3 = new Team("Liverpool");

        team.add(t1);
        team.add(t2);
        team.add(t3);

        int i;
        for (i = 0; i < team.size(); i++) {
            System.out.println(team.get(i));
        }
    }

    /**
     * this function tests by finding a player and printing info on player (from Players ArrayList)
     * on a specific playstyle.
     */
    @Test
    void FindPlayStyle(){
        ArrayList<Players> allPlayers = new ArrayList<Players>();
        Team teamName = new Team("Real Madrid");
        Players p1 = new Players(teamName, "Benzema", "French", 33, "Agressive", 19);
        Players p2 = new Players(teamName, "Luka Modric", "Croatian", 35, "Passive", 10);

        allPlayers.add(p1);
        allPlayers.add(p2);

        String fullPlaystyle = "Passive";

        for (int x = 0; x < allPlayers.size(); x++) {
            if(allPlayers.get(x).getPlayerStyle().equals(fullPlaystyle)) {
                System.out.println("The player [" + allPlayers.get(x).getPlayerName() + " " + allPlayers.get(x).playerIdentity() + "] plays for [" + allPlayers.get(x).getTeamName() + "] and has the playstyle [" + fullPlaystyle + "]");
            }
        }
    }

    /**
     * this function tests by comparing two players with different KDA ratio, and printing the one that
     * is greater than the other.
     */
    @Test
    void TopKDA(){
        HashMap<String, Double> allPlayerStats = new HashMap<String, Double>();
        Team t1 = new Team("Paris Saint-Germain");
        Team t2 = new Team("Manchester United");

        allPlayerStats.put("Messi" + " " + t1 + " " + "56" , 6.7);
        allPlayerStats.put("Cristiano Ronaldo" + " " + t2 + " " + "7" , 12.67);

        double highest = 0;

        String playerName = "";

        System.out.println("The player with the highest KDA is");
        for (Map.Entry<String, Double> entry : allPlayerStats.entrySet()) {
            if(entry.getValue() > highest) {
                playerName = entry.getKey();
                highest = entry.getValue();
            }
        }
        System.out.println("[" + playerName + "] with a KDA of " + highest);
    }

    /**
     * this function tests by printing the player whose age is above a specified age.
     */
    @Test
    void AboveAgeOf(){
        ArrayList<Players> allPlayers = new ArrayList<Players>();
        Team teamName = new Team("Real Madrid");
        Players p1 = new Players(teamName, "Benzema", "French", 33, "Agressive", 19);
        Players p2 = new Players(teamName, "Luka Modric", "Croatian", 35, "Passive", 10);

        allPlayers.add(p1);
        allPlayers.add(p2);

        int inputAge = 34;

        for (int x = 0; x < allPlayers.size(); x++) {
            int agesOfPlayer = allPlayers.get(x).getAge();
            if (agesOfPlayer >= inputAge) {
                System.out.println(allPlayers.get(x).getPlayerName() + " is above the age of " + inputAge);
            }
        }
    }

    /**
     * this function tests by printing the full output of a player that contains the player info.
     */
    @Test
    void FullOutput(){
        ArrayList<Players> allPlayers = new ArrayList<Players>();
        Team teamName = new Team("Real Madrid");
        Players p1 = new Players(teamName, "Benzema", "French", 33, "Agressive", 19);
        Players p2 = new Players(teamName, "Luka Modric", "Croatian", 35, "Passive", 10);

        allPlayers.add(p1);
        allPlayers.add(p2);

        for (int x = 0; x < allPlayers.size(); x++) {
            System.out.println(allPlayers.get(x).allToString());
        }
    }
}
