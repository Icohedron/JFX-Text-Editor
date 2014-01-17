package me.icohedron;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javax.swing.JOptionPane;

public class MainController {
    
    @FXML
    AnchorPane anchorPane;
    @FXML
    MenuItem miNew;
    @FXML
    MenuItem miOpen;
    @FXML
    MenuItem miSave;
    @FXML
    MenuItem miSaveAs;
    @FXML
    MenuItem miAbout;

    @FXML
    TextArea textArea;

    File file;
    
    public void newFile() {
        textArea.setText("");
        this.file = null;
    }

    public void openFile() {

        FileChooser fileC = new FileChooser();
        fileC.setTitle("Choose a file to open");
        this.file = fileC.showOpenDialog(null);
        fileC = null;

        if (file != null) {
            try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bw.readLine()) != null) {
                    textArea.appendText(line + "\n");
                }

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File not found!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to open file!");
            }
        }
    }

    public void saveFile() {

        if (file != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (String line : textArea.getText().split("\n")) {
                    bw.write(line);
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(null, "File saved!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to save!");
            }
        } else {
            FileChooser fileC = new FileChooser();
            fileC.setTitle("Save file as...");
            this.file = fileC.showSaveDialog(null);
            fileC = null;

            if (file != null) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

                    for (String line : textArea.getText().split("\n")) {
                        bw.write(line);
                        bw.newLine();
                    }
                    JOptionPane.showMessageDialog(null, "File saved!");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Unable to save!");
                }
            }
        }

    }

    public void saveAsFile() {
        FileChooser fileC = new FileChooser();
        fileC.setTitle("Save file as...");
        this.file = fileC.showSaveDialog(null);
        fileC = null;

        if (file != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

                for (String line : textArea.getText().split("\n")) {
                    bw.write(line);
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(null, "File saved!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Unable to save!");
            }
        }
    }

    public void aboutTextEditor() {
        JOptionPane.showMessageDialog(null, "A JavaFX Text Editor by Icohedron");
    }
}
