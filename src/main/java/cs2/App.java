package cs2;
//import necessary libraries
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.application.Application;
import javafx.scene.paint.Color;

import static java.lang.System.out;


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

        //add menu items for Options Menu
        MenuItem OptionsItem1 = new MenuItem("Date");
        MenuItem OptionsItem2 = new MenuItem("Write");
        MenuItem OptionsItem3 = new MenuItem("Option 3");
        MenuItem OptionsItem4 = new MenuItem("Option 4");
        Options.getItems().addAll(OptionsItem1, OptionsItem2, OptionsItem3, OptionsItem4);

        //create pop up using a label which contains the current date and time. this will be used for OptionsItem1
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        Label popupLabel = new Label("Current Date: " + currentDate + "\n" + "Current Time: " + currentTime);
        final Popup datePopup = new Popup();
        datePopup.getContent().add(popupLabel);//add popupLabel to the datePopup

        //set action event for OptionsItem1
        OptionsItem1.setOnAction(event -> {
            if (!datePopup.isShowing()){ //if datePopup is not showing
                datePopup.show(primaryStage); //show datePopup
            }
            else datePopup.hide(); //otherwise, hide datePopup
        });


        TextField writeTextField = new TextField();
        writeTextField.setOnAction(event -> {
            String userInput = writeTextField.getText();
            setTextArea(userInput);

        });
        final Popup writePopup = new Popup();
        writePopup.getContent().add(writeTextField);

        //set action event for OptionItem2
        OptionsItem2.setOnAction(event -> {
            if (!writePopup.isShowing()){ //if datePopup is not showing
                writePopup.show(primaryStage); //show datePopup
            }
            else writePopup.hide(); //otherwise, hide datePopup
        });


        OptionsItem3.setOnAction(event -> out.println("bonjour"));

        OptionsItem4.setOnAction(event -> out.println("bonjour"));


        menuBar.getMenus().addAll(Options);
        Scene scene = new Scene(menuBar, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void setTextArea(String fileName) {

        String line;
        String content = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader buffer = new   BufferedReader(fileReader);

            while ((line = buffer.readLine()) != null) {
                out.println(line);
                content += line;
            }
            buffer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
