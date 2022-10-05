package cs2;
//import necessary libraries
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicReference;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
    private BorderPane borderPane;

    GridPane view1 = new GridPane();
    GridPane view2 = new GridPane();
    GridPane view3 = new GridPane();
    GridPane view4 = new GridPane();
    VBox menuVBox;
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("User Interface"); //set the title to "User Interface Test"
        genMenu();
        genPaneOne();
        genPaneTwo();

        borderPane = new BorderPane();
        borderPane.setTop(menuBar);


        Scene mainScene = new Scene(borderPane, 600, 600);
        primaryStage.setScene(mainScene);
        primaryStage.show();


    }

    private void genMenu(){
        //add menu items for Options Menu
        Options.getItems().addAll(OptionsItem1, OptionsItem2, OptionsItem3, OptionsItem4);
        //set action event for OptionsItem1
        OptionsItem1.setOnAction(event -> {
            switchPane(view1);

        });
        //set action event for OptionItem2
        OptionsItem2.setOnAction(event -> {
            switchPane(view2);

        });
        OptionsItem3.setOnAction(event -> {
            out.println("bonjour");
        });

        OptionsItem4.setOnAction(event -> {
            out.println("bonjour");
        });

        menuVBox = new VBox(menuBar);
        menuBar.getMenus().addAll(Options);
    }

    private GridPane genPaneOne(){
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        Label showDateAndTime;
        showDateAndTime = new Label("Current Date: " + currentDate + "\n" + "Current Time: " + currentTime);

        view1.getChildren().addAll(showDateAndTime);
        view1.setStyle("-fx-border-color:red; -fx-border-width: 600 600 2 2");
        view1.setRowIndex(showDateAndTime, 1);
        view1.setAlignment(Pos.TOP_CENTER);


        return view1;
    }

    private GridPane genPaneTwo(){
        TextField userTextField = new TextField();
        userTextField.setMaxWidth(300);

        Button submit = new Button("Submit");
        view2.getChildren().addAll(userTextField, submit);

        view2.setHalignment(userTextField, HPos.CENTER);
        view2.setHalignment(submit, HPos.RIGHT);
        view2.setStyle("-fx-background-color: blue");

        return view2;
    }
    public static void main( String[] args )
    {
        launch(args);
    }




    private void switchPane(Pane pane){
        borderPane.setCenter(pane);

    }

    public static void setTextArea(String userInput) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"));
            writer.write(userInput);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



/*
class NodeTwo extends StackPane {
    public NodeTwo(){
        setStyle("-fx-background-color: red; -fx-font-size: 30px;");
        TextField userTextField = new TextField();
        userTextField.setMaxWidth(300);
        userTextField.setAlignment(Pos.TOP_CENTER);
        Button submit = new Button("Submit");
        submit.setAlignment(Pos.BOTTOM_CENTER);

        userTextField.setOnAction(event -> {
            String userInput = userTextField.getText();
            setTextArea(userInput);

        });

        getChildren().addAll(userTextField, submit);

    }


}
*/