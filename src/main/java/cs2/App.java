package cs2;
//import necessary libraries
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicReference;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;

import static java.lang.System.out;


public class App extends Application
{
    //class level variables
    private Stage stage = new Stage();
    private final MenuItem OptionsItem1 = new MenuItem("Date");
    private final MenuItem OptionsItem2 = new MenuItem("Write");
    private final MenuItem OptionsItem3 = new MenuItem("Option 3");
    private final MenuItem OptionsItem4 = new MenuItem("Option 4");
    private final MenuBar menuBar = new MenuBar(); // creates a menu bar at the top of the window
    private final Menu Options = new Menu("Options"); //add new menu called "Options"
    private final Node Node1 = new NodeOne();
    private final Node Node2 = new NodeTwo();
    private BorderPane root;

    VBox vBox;
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("User Interface"); //set the title to "User Interface Test"
        genMenu();

        root = new BorderPane();
        root.setTop(menuBar);

        Scene mainScene = new Scene(root, 600, 600);
        primaryStage.setScene(mainScene);
        primaryStage.show();


    }

    private void genMenu(){
        //add menu items for Options Menu
        Options.getItems().addAll(OptionsItem1, OptionsItem2, OptionsItem3, OptionsItem4);
        //set action event for OptionsItem1
        OptionsItem1.setOnAction(event -> {
            switchView(Node1);

        });
        //set action event for OptionItem2
        OptionsItem2.setOnAction(event -> {
            switchView(Node2);

        });
        OptionsItem3.setOnAction(event -> {
            out.println("bonjour");
        });

        OptionsItem4.setOnAction(event -> {
            out.println("bonjour");
        });

        vBox = new VBox(menuBar);
        menuBar.getMenus().addAll(Options);
    }

    private void genSceneOne(){

    }
    public static void main( String[] args )
    {
        launch(args);
    }




    private void switchView(Node view){
        root.setCenter(view);

    }
}

class NodeOne extends StackPane {
    public NodeOne(){
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        setStyle("-fx-background-color: lightblue; -fx-font-size: 30px;");
        Label showDateAndTime = new Label("Current Date: " + currentDate + "\n" + "Current Time: " + currentTime);
        getChildren().add(showDateAndTime);

    }

}

class NodeTwo extends StackPane {
    public NodeTwo(){
        setStyle("-fx-background-color: red; -fx-font-size: 30px;");
        TextField userTextField = new TextField();

        userTextField.setOnAction(event -> {
            String userInput = userTextField.getText();
            setTextArea(userInput);

        });
        getChildren().add(userTextField);

    }
    public static void setTextArea(String userInput) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"));
            writer.write(userInput);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
