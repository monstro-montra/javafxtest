package cs2;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ViewSwitcherApp extends Application {
    private BorderPane layout;
    private final Node viewOne = new ViewOne();
    private final Node viewTwo = new ViewTwo();

    @Override
    public void start(Stage stage) throws Exception {
        // View menu
        MenuItem viewOneMenuItem = new MenuItem("View One");
        viewOneMenuItem.setOnAction(e -> setView(viewOne));
        MenuItem viewTwoMenuItem = new MenuItem("View Two");
        viewTwoMenuItem.setOnAction(e -> setView(viewTwo));
        Menu viewMenu = new Menu(
                "View", null,
                viewOneMenuItem, viewTwoMenuItem
        );

        // File menu
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> Platform.exit());
        Menu fileMenu = new Menu(
                "File", null,
                exitMenuItem
        );

        MenuBar menuBar = new MenuBar(
                fileMenu, viewMenu
        );
        menuBar.setMinSize(MenuBar.USE_PREF_SIZE, MenuBar.USE_PREF_SIZE);

        // Layout scene
        layout = new BorderPane();
        layout.setTop(menuBar);
        setView(viewOne);

        stage.setScene(
                new Scene(layout, 300, 200)
        );
        stage.show();
    }

    private void setView(Node view) {
        layout.setCenter(view);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class ViewOne extends StackPane {
    public ViewOne() {
        setStyle("-fx-background-color: lightblue; -fx-font-size: 30px;");
        getChildren().add(new Label("View One"));
    }
}

class ViewTwo extends StackPane {
    public ViewTwo() {
        setStyle("-fx-background-color: cornsilk; -fx-font-size: 30px;");
        getChildren().add(new Label("View Two"));
    }
}