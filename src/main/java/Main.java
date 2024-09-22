import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import randomrecipes.Recipes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main extends Application {
    Recipes recipes = new Recipes();
    int addRecipeCount = 0;
    String recipeName = "Default";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane layout = new BorderPane();
        StackPane addPane = new StackPane();
        HBox addPaneHBox = new HBox();

        TextField textField = new TextField("Enter your recipe name here.");
        textField.setMaxWidth(150);

        Label label = new Label("hi");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(5, 5, 5, 5));
        hBox.setSpacing(5);

        Button addView = new Button("add a recipe");
        Button addRecipe = new Button("add");
        Button getButton = new Button("get a random recipe");
        Button allButton = new Button("see all recipes");

        hBox.getChildren().addAll(addView, getButton, allButton);
        layout.setTop(hBox);

        addPane.setAlignment(Pos.CENTER);
        addPaneHBox.setSpacing(5);
        addPaneHBox.setAlignment(Pos.CENTER);
        addPaneHBox.getChildren().addAll(textField, addRecipe);
        addPane.getChildren().add(addPaneHBox);

        Scene scene = new Scene(layout,800,400);

        addView.setOnAction(event -> layout.setCenter(addPane));
        getButton.setOnAction(event -> {
            recipes.printAll();
        });

        addRecipe.setOnAction(event -> {
            if (addRecipeCount == 0) {
                recipeName = textField.getText(); // Tofu
                textField.setText("Now, add your ingredients.");
                addRecipeCount++;
            } else {
                String[] ingredients = textField.getText().split(" ");

                ArrayList<String> ingredientsList = new ArrayList<>(Arrays.asList(ingredients));

                recipes.getRecipes().put(recipeName, ingredientsList);

                textField.setText("Enter your recipe name here.");
                addRecipeCount = 0;
            }
        });

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