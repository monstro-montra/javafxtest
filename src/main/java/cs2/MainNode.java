package cs2;

//import necessary classes
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class MainNode extends VBox { //extends vbox for vertical positioning of leaf nodes
    public MainNode(){
        setAlignment(Pos.CENTER); //set vbox alignment to center
        Label Title = new Label("This is the Main Title Screen.\nPlease select from " +
                "the options menu.");
        Title.setTextAlignment(TextAlignment.CENTER); //set the text alignment to center

        getChildren().add(Title); //add title label to this node
    }
}
