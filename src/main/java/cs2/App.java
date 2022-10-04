package cs2;
//import necessary libraries
import java.time.LocalDate; 
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.application.Application;
import javafx.scene.control.MenuItem;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;


public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        Label popupLabel = new Label("Current Date" + currentDate);
        Popup datePopup = new Popup();
        datePopup.getContent().add(popupLabel);

        

        OptionsItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                
                
                if (!datePopup.isShowing()){
                    datePopup.show(primaryStage);
                }
                else datePopup.hide();
            }
        });

        OptionsItem2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                System.out.println("hello");
            };
        });

        OptionsItem3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                System.out.println("bonjour");
            };
        });

        OptionsItem4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event)
            {
                System.out.println("bonjour");
            };
        });

        
        menuBar.getMenus().addAll(Options); 
        Scene scene = new Scene(menuBar, 600, 600); 

        primaryStage.setScene(scene);
        

    }
}
