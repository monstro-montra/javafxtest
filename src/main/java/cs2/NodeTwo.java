package cs2;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class NodeTwo extends VBox {
    public NodeTwo(){
        setAlignment(Pos.CENTER); //set the alignment of vbox to center
        Label prompt = new Label("This Menu allows you to write text to a file called log.txt.");
        TextField userTextField = new TextField(); //generate new textfield
        userTextField.setMaxWidth(300); //set userTextField max width to 300
        Button submit = new Button("Submit");

        userTextField.setOnAction(event -> {
            String userInput = userTextField.getText(); //set userInput to the text found inside the userTextField
            writeTextArea(userInput); //call writeTextArea method

        });

        submit.setOnAction(event -> { // essentially do the same thing as the above action
            String userInput = userTextField.getText();
            writeTextArea(userInput);
        });

        getChildren().addAll(prompt, userTextField, submit); // will add them all to vbox in this order to align them properly

    }
    public static void writeTextArea(String userInput) {

        //write to a userInput into a new file named log.txt
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"));
            writer.write(userInput);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}