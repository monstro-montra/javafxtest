package cs2;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.LocalTime;

class NodeOne extends VBox {
    public NodeOne(){
        setAlignment(Pos.CENTER); //position vbox to the center
        LocalDate currentDate = LocalDate.now(); //get local date
        LocalTime currentTime = LocalTime.now(); //get local time
        Label showDateAndTime; //create label
        showDateAndTime = new Label("Current Date: " + currentDate + "\n" + "Current Time: " + currentTime); //implement date and time to label
        getChildren().add(showDateAndTime); //add showDateAndTime to vbox
    }
}