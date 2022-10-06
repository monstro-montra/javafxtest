package cs2;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.LocalTime;

class NodeOne extends VBox {

    public NodeOne(){
        setAlignment(Pos.CENTER);
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        Label showDateAndTime;
        showDateAndTime = new Label("Current Date: " + currentDate + "\n" + "Current Time: " + currentTime);
        getChildren().add(showDateAndTime);
    }
}