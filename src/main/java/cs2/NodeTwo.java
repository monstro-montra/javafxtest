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
        setAlignment(Pos.CENTER);
        Label prompt = new Label("This Menu allows you to write text to a file called log.txt.");
        TextField userTextField = new TextField();
        userTextField.setMaxWidth(300);
        userTextField.setAlignment(Pos.TOP_CENTER);
        Button submit = new Button("Submit");
        submit.setAlignment(Pos.BOTTOM_CENTER);

        userTextField.setOnAction(event -> {
            String userInput = userTextField.getText();
            writeTextArea(userInput);

        });
        submit.setOnAction(event -> {
            String userInput = userTextField.getText();
            writeTextArea(userInput);
        });
        getChildren().addAll(prompt, userTextField, submit);

    }
    public static void writeTextArea(String userInput) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"));
            writer.write(userInput);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}