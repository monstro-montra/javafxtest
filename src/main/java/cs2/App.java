package cs2;
//import necessary libraries

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.application.Application;

public class App extends Application
{
    private final MenuBar menuBar = new MenuBar(); //creates a menu bar
    private final Menu File = new Menu("File");
    private final MenuItem FileItem1 = new MenuItem("Back to main menu");
    private final Menu Options = new Menu("Options"); //add new menu called "Options"
    private final MenuItem OptionsItem1 = new MenuItem("Date/Time");
    private final MenuItem OptionsItem2 = new MenuItem("Write");
    private final MenuItem OptionsItem3 = new MenuItem("Color");
    private final MenuItem OptionsItem4 = new MenuItem("Exit");
    private BorderPane root;
    private final Node mainView = new MainNode(); //branch node for main menu
    private final Node view1 = new NodeOne(); //branch node for the Date/Time Menu
    private final Node view2 = new NodeTwo(); //branch node for the Write Menu
    private final Node view3 = new NodeThree(); //branch node for the Color Menu

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("User Interface"); //set the title to "User Interface Test"
        genMenuBar(); //call the genMenu method
        switchView(mainView);

        // this will be the primary scene.
        Scene mainScene = new Scene(root, 600, 600); //root node: root width: 600, height: 600
        primaryStage.setScene(mainScene); //set mainScene as the primary stage.
        primaryStage.show(); //allows the stage to be visible
    }
    //this method generates the menu bar that will be shared across all nodes.
    private void genMenuBar(){
        File.getItems().add(FileItem1);

        FileItem1.setOnAction(event -> switchView(mainView));

        //add menu items for Options Menu
        Options.getItems().addAll(OptionsItem1, OptionsItem2, OptionsItem3, OptionsItem4);

        //set action event for OptionsItem1. lets user switch to view1 node
        OptionsItem1.setOnAction(event -> switchView(view1)); //on click, exit to view1

        //set action event for OptionItem2. lets user switch to view2 node
        OptionsItem2.setOnAction(event -> switchView(view2)); // on click, exit to view2

        //set action event for OptionItem3. lets user switch to view3 node
        OptionsItem3.setOnAction(event -> switchView(view3)); // on click, exit to view3

        //on click, exit the program
        OptionsItem4.setOnAction(event -> System.exit(0));

        menuBar.getMenus().addAll(File, Options); // add both File and Options menu to menuBar

        root = new BorderPane(); //this will be the root node for mainScene
        root.setTop(menuBar); //set the menuBar to the top of the borderPane
    }
    //the following method is what will allow for the switching of nodes
    private void switchView(Node view){
        root.setCenter(view);
    }

    //boilerplate for any java program that needs to be launched
    public static void main( String[] args )
    {
        //this is boilerplate for javafx programs essentially
        launch(args);
    }
}




