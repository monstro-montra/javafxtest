package cs2;

import javafx.scene.layout.VBox;
import java.util.Random;

public class NodeThree extends VBox {

    int randNum;
    public NodeThree(){

        genRandNum();

        if (randNum == 1){
            setStyle("-fx-background-color: #66ff66");
        }
        else if (randNum == 2){
            setStyle("-fx-background-color: #66ff99");
        }
        else if (randNum == 3){
            setStyle("-fx-background-color: #003300");
        }
        else if (randNum == 4){
            setStyle("-fx-background-color: #669900");
        }
        else if (randNum == 5){
            setStyle("-fx-background-color: #339933");
        }

    }
    public void genRandNum(){
        Random r = new Random();
        int low = 1;
        int high = 5;
        randNum = r.nextInt(high - low) + low;

    }

}
