package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

public class HelloController {
    //Constants
    public static ArrayList<Team> allTeams = new ArrayList<Team>(); //Team objects ArrayList
    public static HashMap<String, Double> allPlayerStats = new HashMap<String, Double>(); //playerIdentity : KDA
    public static ArrayList<Players> allPlayers = new ArrayList<Players>(); //Player objects ArrayList

    //Add player section
    @FXML
    private TextArea playerTextBox;

    @FXML
    private TextField playerAge;

    @FXML
    private TextField playerJerseyNumber;

    @FXML
    private TextField playerKDA;

    @FXML
    private TextField playerName;

    @FXML
    private TextField playerNationality;

    @FXML
    private TextField playerPlaystyle;

    @FXML
    ChoiceBox<Team> choiceTeamBox = new ChoiceBox<>();

    @FXML
    private Button add_Player;

    //Add Team section
    @FXML
    private TextArea teamTextBox;

    @FXML
    private TextField teamName;

    @FXML
    private Button add_Team;

    //main menu stuff
    @FXML
    private Button main_addPlayer;

    @FXML
    private Button main_addTeam;

    @FXML
    private Button menu_four;

    @FXML
    private Button menu_three;

    @FXML
    private Button menu_two;

    //menu two stuff
    @FXML
    ChoiceBox<String> choiceGetPlayers = new ChoiceBox<>();

    @FXML
    private TextField changedKDA;

    @FXML
    private Button change_KDA;

    @FXML
    private Button printPlayerKDA;

    @FXML
    private TextArea cuztomizePlayerText;

    //menu three section
    @FXML
    private Button output_players;

    @FXML
    private Button output_teams;

    @FXML
    private TextArea outputBox;

    //menu four section
    @FXML
    private Button final_output;

    @FXML
    private Button findHighest_KDA;

    @FXML
    private Button findplaystyle;

    @FXML
    private Button above_age;

    @FXML
    private TextArea specialOutputBox;

    @FXML
    private TextField ageInput;

    //quit
    @FXML
    private MenuItem Quit;


    /**
     * used to get the all the items from the choice boxes
     */
    @FXML
    public void initialize()
    {
        choiceTeamBox.getItems().addAll(allTeams);
        choiceGetPlayers.getItems().addAll(allPlayerStats.keySet());
    }

    /**
     * function used to display information on the project
     * @param event
     */
    @FXML
    void AboutProject(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Message");
        alert.setContentText("""
                Author: Efren Garcia & Hera Naeem
                Version: v1.0
                ~~~~~~~
                This is our world editor for an
                E-Sports Tracker.
                """);
        alert.show();
    }

    //MENU 1: TEAM AND PLAYERS****************************************************
    @FXML
    void MenuOne_AddTeam(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddTeam.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Stage stage = new Stage();
        stage.setMinWidth(600);
        stage.setMinHeight(350);
        stage.setTitle("Add Teams");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void MenuOne_AddPlayer(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddPlayer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Stage stage = new Stage();
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.setTitle("Add Players");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * this function is used to add a team after the button is clicked and the user has entered
     * something into the text field, the team name is displayed in the text area. The team
     * is also added into the Team ArrayList.
     * @param event
     */
    @FXML
    void addTeam(MouseEvent event) {
        if (!teamName.getText().equals("")) {
            int count = 0;
            Team obj = new Team(teamName.getText());

            if (allTeams.isEmpty())
            {
                teamTextBox.setText("The Team " + obj.getName() + " has been added!");
                allTeams.add(obj);
            }
            else {
                for (int i = 0; i < allTeams.size(); i++) { //loops through each element in the Team ArrayList
                    if(allTeams.get(i).equals(obj)) //checks if they are the same by comparing one object to the other object
                    {
                        count += 1;

                    }
                }
                if (count >= 1)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR,"This team has already been added");
                    alert.show();
                }
                else
                {
                    teamTextBox.setText("The Team " + obj.getName() + " has been added!");
                    allTeams.add(obj); //adds the object to the Team objects ArrayList
                }
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,"The text field is empty."); //Just like a loading scrren
            alert.show();
        }
    }


    /**
     * This function used to add a player after user enters multiple information regarding the
     * player into separate text fields, but for team there is a choice box that lists the team
     * name or names the user has entered during add teams. Adds all the information into the
     * Players ArrayList.
     * @param event
     */
    @FXML
    void addPlayer(MouseEvent event){
        try {
            String name = playerName.getText();
            String nationality = playerNationality.getText();
            String playStyle = playerPlaystyle.getText();
            int age = Integer.parseInt(playerAge.getText());
            double KDA = Double.parseDouble(playerKDA.getText());
            int jersey = Integer.parseInt(playerJerseyNumber.getText());
            Players newPlayer = new Players(choiceTeamBox.getValue(), name, nationality, age, playStyle, jersey);
            allPlayerStats.put(newPlayer.playerIdentity(), KDA); //adds player identity from the Players ArrayList into the HashMap for player stats along with the KDA
            allPlayers.add(newPlayer);
            playerTextBox.setText("The Player " + newPlayer.getPlayerName() + " has been added!");

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"One of the text fields above is invalid, check on player age, it requires an integer value, Jersey NUmber, it requires and integer value, or KDA which requires a decimal value."); //Just like a loading scrren
            alert.show();
        }

    }
    //****************************************


    //MENU 2: CUSTOMIZATIONS**************************************
    @FXML
    void MenuTwo(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MenuTwo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Stage stage = new Stage();
        stage.setMinWidth(620);
        stage.setMinHeight(440);
        stage.setTitle("Customize/look at player stats");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * used to print the KDA of the player you select from the choice box
     * @param event
     */
    @FXML
    void printPlayerKDA(MouseEvent event)
    {
        String returnedString = "";
        for (Map.Entry<String, Double> entry : allPlayerStats.entrySet()) { //this loops through the HashMap consisting of player stats
            returnedString = returnedString + "\n" + "[" + entry.getKey() + "]" + " has a ratio of "+ entry.getValue() + "\n";
        }
        cuztomizePlayerText.setText(returnedString);
    }

    /**
     * this function is used if the user prefers to change the KDA of the player.
     * It updates the KDA that the user enters in menu one while adding the player.
     * @param event
     */
    @FXML
    void changedKDAButton(MouseEvent event)
    {
        try {
            allPlayerStats.put(choiceGetPlayers.getValue(), Double.parseDouble(changedKDA.getText())); //adds the new KDA value and player whose KDA user wanted to change, into the HashMap.
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"The value " + changedKDA.getText() + " is not of decimal value"); //Just like a loading screen
            alert.show();
        }
    }
    //****************************************


    //MENU 3: LOOP DATA**********************
    @FXML
    void MenuThree(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MenuThree.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Stage stage = new Stage();
        stage.setMinWidth(620);
        stage.setMinHeight(420);
        stage.setTitle("Output Teams and Players");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * this function output the player information consisting of player name, team name, and jersey number.
     * It can output more than one player. Depends on how many the user inputs.
     * @param event
     */
    @FXML
    void outputPlayers(MouseEvent event)
    {
        String printedString = "";
        String oldString = "";
        for (int x = 0; x < allPlayers.size(); x++) { //loops through each element in the players ArrayList
            oldString = printedString;
            printedString = oldString + allPlayers.get(x).getPlayerName() + " from " + allPlayers.get(x).getPlayerNationality() + " plays for " + allPlayers.get(x).getTeamName() + " with Jersey Number " + allPlayers.get(x).getJerseyNumber() + "\n";

        }
        outputBox.setText("The players are" + "\n" + printedString);
    }

    /**
     * this function output the teams.It can output more than one team.
     * Depends on how many the user inputs.
     * @param event
     */
    @FXML
    void outputTeam(MouseEvent event)
    {
        String printedString = "";
        for (int i = 0; i < allTeams.size(); i++) { //loops through each element in the team ArrayList
            printedString = printedString + "\n" + allTeams.get(i).getName() + "\n";
        }
        outputBox.setText("The teams are " + "\n" + printedString);
    }
    //***************************************


    //MENU 4: SPECIAL OUTPUT***********************
    @FXML
    void MenuFour(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MenuFour.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Stage stage = new Stage();
        stage.setMinWidth(870);
        stage.setMinHeight(420);
        stage.setTitle("Special Output");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * this function is used to access the player's playstyle from the Players ArrayList
     * @param event
     */
    @FXML
    void getPlaystyle(MouseEvent event)
    {
        String printedString = "";
        for (int x = 0; x < allPlayers.size(); x++) { //loops through each element in the players ArrayList
            printedString = printedString + "\n" + "[" + allPlayers.get(x).playerIdentity() + "] plays for [" + allPlayers.get(x).getTeamName() + "] and has the playstyle [" + allPlayers.get(x).getPlayerStyle() + "]" + "\n" ;
        }
        specialOutputBox.setText(printedString);
    }

    /**
     * This function is used to get the highest KDA among multiple players (if entered).
     * it prints the name of the player that has the highest KDA.
     * @param event
     */
    @FXML
    void getHighest(MouseEvent event)
    {
        String printedString = "";

        double highest = 0;

        String playerName = "";

        for (Map.Entry<String, Double> entry : allPlayerStats.entrySet()) { //loops through the HashMap consisting of players' stats
            if(entry.getValue() > highest) {
                playerName = entry.getKey(); //obtain the key and stores it in the empty String variable
                highest = entry.getValue(); //obtain the value and update the counter with it
            }
        }
        printedString = "[" + playerName + "] with a KDA of " + highest + "\n";
        specialOutputBox.setText(printedString);
    }


    /**
     * this function is used to check which player is above a certain age that the user specifies in
     * the text field. it is possible to get more than one player as the output.
     * @param event
     */
    @FXML
    void getAgeHigher(MouseEvent event)
    {
        String printedString = "";
        try {
            int inputAge = Integer.parseInt(ageInput.getText());
            for (int x = 0; x < allPlayers.size(); x++) { //loops through each element in the Players ArrayList
                int agesOfPlayer = allPlayers.get(x).getAge();
                if (agesOfPlayer >= inputAge) { //checks if a player's age in the ArrayList is greater than the age entered by the user
                    printedString = printedString + "\n" + allPlayers.get(x).getPlayerName() + " is above the age of " + inputAge + "\n";
                }
            }
            specialOutputBox.setText(printedString);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"The text-field needs to be an integer value"); //Just like a loading scrren
            alert.show();
        }
    }

    /**
     * this function is used to display the final output of the player consisting of
     * all the information related to the player.
     * @param event
     */
    @FXML
    void outputAll(MouseEvent event)
    {
        String printedString = "";
        for (int x = 0; x < allPlayers.size(); x++) { //loops through each element in the Players ArrayList
            printedString = printedString + "\n" + allPlayers.get(x).allToString() + "\n";
        }
        specialOutputBox.setText(printedString);
    }
    //**************************************

    //save and load************
    /**
     * this function is used to save the data that the user enters onto a .txt file (save.txt in our case)
     * @param event
     */
    @FXML
    void saveButton(ActionEvent event)
    {
        String[] args = HelloApplication.getArgs();
        String fileName = args[0];
        File saveFile = new File(fileName);
        Reader.saveFile(saveFile, allTeams, allPlayerStats, allPlayers);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved Successfully!");
        alert.show();
    }

    /**
     * this function is used to load the data that the user enters onto a .txt file (load.txt in our case)
     * @param event
     */
    @FXML
    void loadButton(ActionEvent event)
    {
        String[] args = HelloApplication.getArgs();
        String fileName = args[0];
        File loadFile = new File(fileName);
        Loader.loadFile(loadFile, allTeams, allPlayerStats, allPlayers);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Loaded Successfully!");
        alert.show();
    }

    /**
     * Closes the program once the user clicks on Quit in the File Menu
     * @param event
     */
    @FXML
    void quitProgram(ActionEvent event){
        System.exit(1);
    }
}