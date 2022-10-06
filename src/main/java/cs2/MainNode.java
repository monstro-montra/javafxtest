package cs2;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class MainNode extends VBox { //extends vbox for vertical positioning of
    public MainNode(){
        setAlignment(Pos.CENTER);
        Label Title = new Label("This is the Main Title Screen.\nPlease select from " +
                "the options menu.");
        Title.setTextAlignment(TextAlignment.CENTER);

        getChildren().add(Title);
    }
}
