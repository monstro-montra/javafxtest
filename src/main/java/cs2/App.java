package cs2;
//import necessary libraries
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.application.Application;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.paint.Color;


public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("User Interface"); //set the title to "User Interface Test"
        final MenuBar menuBar = new MenuBar(); //creates a menu bar at the top of the window
        Menu Options = new Menu("Options"); //add new menu called "Options"



        //add menu items for m1
        MenuItem OptionsItem1 = new MenuItem("Date");
        MenuItem OptionsItem2 = new MenuItem("Option 2");
        MenuItem OptionsItem3 = new MenuItem("Option 3");
        MenuItem OptionsItem4 = new MenuItem("Option 4");
        Options.getItems().addAll(OptionsItem1, OptionsItem2, OptionsItem3, OptionsItem4);

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        Label popupLabel = new Label("Current Date: " + currentDate + "\n" + "Current Time: " + currentTime);

        final Popup datePopup = new Popup();
        datePopup.getContent().add(popupLabel);



        OptionsItem1.setOnAction(event -> {

            if (!datePopup.isShowing()){
                datePopup.show(primaryStage);
            }
            else datePopup.hide();
        });

        OptionsItem2.setOnAction(event -> System.out.println("hello"));

        OptionsItem3.setOnAction(event -> System.out.println("bonjour"));

        OptionsItem4.setOnAction(event -> System.out.println("bonjour"));


        menuBar.getMenus().addAll(Options);
        Scene scene = new Scene(menuBar, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
