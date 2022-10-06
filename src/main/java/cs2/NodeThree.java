package cs2;

import javafx.scene.layout.VBox;
import java.util.Random;

public class NodeThree extends VBox {

    //this will save the color once the program has already one. to get a new random color, reopen the program.
    int randNum;
    public NodeThree(){

        genRandNum();

        if (randNum == 1){
            setStyle("-fx-background-color: #66ff66"); //CSS for getting bg color
        }
        else if (randNum == 2){
            setStyle("-fx-background-color: #66ff99"); //CSS for getting bg color
        }
        else if (randNum == 3){
            setStyle("-fx-background-color: #003300"); //CSS for getting bg color
        }
        else if (randNum == 4){
            setStyle("-fx-background-color: #669900"); //CSS for getting bg color
        }
        else if (randNum == 5){
            setStyle("-fx-background-color: #339933"); //CSS for getting bg color
        }

    }
    public void genRandNum(){
        Random r = new Random(); //generate new random object
        int low = 1;
        int high = 5;
        randNum = r.nextInt(high - low) + low; //get next int that is (5 - 1) + 1 (from 1 to five.)

    }

}
