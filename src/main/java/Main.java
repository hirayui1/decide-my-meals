import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane layout = new BorderPane();
        Pane addPane = new Pane();
        Pane getPane = new Pane();

        TextField textField = new TextField("Enter your recipe here");
        textField.setMaxWidth(150);

        Label label = new Label("hi");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(5, 5, 5, 5));
        hBox.setSpacing(5);

        Button addButton = new Button("add");
        Button getButton = new Button("get");
        Button allButton = new Button("all");

        //addButtonsToItem(hBox, addButton, getButton, allButton);
        hBox.getChildren().addAll(addButton, getButton, allButton);
        layout.setTop(hBox);

        addPane.getChildren().add(textField);

        Scene scene = new Scene(layout,800,400);

        addButton.setOnAction(event -> layout.setCenter(textField));
        getButton.setOnAction(event -> layout.setCenter(label));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static <T> void addButtonsToItem(T item, Button... buttons) {
        for (Button addButton : buttons) {
            if (item instanceof HBox) {
                HBox hBox = (HBox) item;
                hBox.getChildren().add(addButton);
            } else if (item instanceof VBox) {
                VBox hBox = (VBox) item;
                hBox.getChildren().add(addButton);
            } else {
                System.out.println("No fitting item");
                break;
            }
        }
    }
}