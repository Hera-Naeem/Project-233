package com.example.demo3;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

/**
 * This takes the string name, and finds the file associated it with the name.
 * Saves the data on to that file.
 */

public class Reader {
    public static void saveFile(File fileToSave, ArrayList<Team> Teams, HashMap<String, Double> PlayerStats, ArrayList<Players> Players) {

        if (fileToSave.exists() && fileToSave.isFile() && fileToSave.canWrite()) { //checks for file error
            try
            {
                FileWriter file_writer = new FileWriter(fileToSave); //open up the file
                PrintWriter print_writer = new PrintWriter(file_writer); //allows to write the file
                for (int i = 0; i < Teams.size(); i++) { //loops through Team array and writes it
                    print_writer.println(Teams.get(i).getName());
                }
                for (int i = 0; i < Players.size(); i++) { //loops through Players array and writes it with commas in between data
                    print_writer.println(Players.get(i).getTeamName() + "," + Players.get(i).getPlayerName()+ ","+ Players.get(i).getPlayerNationality() + ","+
                            Players.get(i).getAge() + ","+ Players.get(i).getPlayerStyle()+ "," + Players.get(i).getJerseyNumber());
                }
                for (Map.Entry<String, Double> entry : PlayerStats.entrySet()) { //writes HashMap data separated by a comma
                    print_writer.println(entry.getKey()+ ","+ entry.getValue());
                }
                print_writer.close(); //ALWAYS CLOSE FILE

            } catch (IOException e) {
                System.err.println("An error was found within the file, the file did exist, could be written on and is a file, but some externality closed it. Erroe!");
                System.exit(1);
            }
        }
        else
        {
            System.err.println("Cannot access the file to write it! Please check if the file is in the designated folder or is spelt correctly! Returning to main menu");
            System.exit(1);
        }
    }
}
