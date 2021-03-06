package me.icohedron;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFrame extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Text Editor.fxml"));
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("JFX Text Editor by Icohedron");
        primaryStage.show();
    }
}
