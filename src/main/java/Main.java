import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import randomrecipes.Recipes;
import tabs.AddView;

import java.util.ArrayList;
import java.util.Arrays;

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

        AddView addView = new AddView();
        StackPane addPane = addView.getView();

        Label label = new Label("hi");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(5, 5, 5, 5));
        hBox.setSpacing(5);

        Button addViewButton = new Button("add a recipe");
        Button getButton = new Button("get a random recipe");
        Button allButton = new Button("see all recipes");

        hBox.getChildren().addAll(addViewButton, getButton, allButton);
        layout.setTop(hBox);


        Scene scene = new Scene(layout,800,400);

        addViewButton.setOnAction(event -> layout.setCenter(addPane));

        getButton.setOnAction(event -> {
            recipes.printAll();
        });

        addView.getAddRecipe().setOnAction(event -> {
            if (addRecipeCount == 0) {
                recipeName = addView.getTextField().getText(); // Tofu
                addView.getTextField().clear();
                addView.setAddPaneLabel("Now, add your ingredients ");
                addRecipeCount++;
            } else {
                String[] ingredients = addView.getTextField().getText().split(" ");

                ArrayList<String> ingredientsList = new ArrayList<>(Arrays.asList(ingredients));

                recipes.addRecipes(recipeName, ingredientsList);
                addView.setAddPaneLabel("Enter your recipe name ");
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