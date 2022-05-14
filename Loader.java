package com.example.demo3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

/**
 * This takes a string and the data and uses the string to find a file and reads the file and stores it into the data.
 */


public class Loader {
    public static void loadFile(File fileName, ArrayList<Team> Teams, HashMap<String, Double> PlayerStats, ArrayList<Players> Players)
    {
        try {
            FileReader fileToLoad = new FileReader(fileName);
            BufferedReader buffered_reader = new BufferedReader(fileToLoad); //allows file to be read
            String line = buffered_reader.readLine(); //reads first line
            while (line != null) { //until its whitespace
                String[] splitLine = line.split(","); //splits data based on commas
                if (splitLine.length == 1) //team objects
                {
                    int count = 0;
                    Team newTeam = new Team(splitLine[0]); //takes the string and makes it into an object
                    for (int i = 0; i < Teams.size(); i++) { //checks for duplicates
                        if(Teams.get(i).equals(newTeam))
                        {
                            count += 1;

                        }
                    }
                    if (count >= 1)
                    {

                    }
                    else
                    {
                        Teams.add(newTeam);
                    }
                }
                else if (splitLine.length == 6) //checks player objects
                {
                    Team newTeam = new Team(splitLine[0]);
                    Players newPlayer = new Players(newTeam, splitLine[1], splitLine[2], Integer.parseInt(splitLine[3]), splitLine[4], Integer.parseInt(splitLine[5])); //makes a player object
                    Players.add(newPlayer);
                }

                else if (splitLine.length == 2) //checks HashMap KDA
                {
                    PlayerStats.put(splitLine[0], Double.parseDouble(splitLine[1]));
                }
                line = buffered_reader.readLine(); //checks next line
            }
            buffered_reader.close();
        }
        catch (IOException e) {
            System.err.println("Cannot access file to load! Going back to main menu.");
            System.exit(2);
        }

    }
}

