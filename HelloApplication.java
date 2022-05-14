package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Partner 1: Efren Garcia
 * Partner 2: Hera Naeem
 * T08
 */

public class HelloApplication extends Application {

    private static String[] savedArgs; //Weird way to do command line arguments, pretty much saves it as a variable.
    public static String[] getArgs() { // This was the way I got the command line arguments
        return savedArgs;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setMinWidth(480);
        stage.setMinHeight(580);
        stage.setTitle("E-Sports Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        savedArgs = args;
        launch();
    }
}