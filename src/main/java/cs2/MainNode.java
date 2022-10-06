package cs2;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainNode extends VBox {
    public MainNode(){
        setAlignment(Pos.CENTER);
        setStyle("");
        Label Title = new Label("This is the Main Title Screen.\nPlease select from " +
                "the options menu.");

        getChildren().add(Title);
    }
}
