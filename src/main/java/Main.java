import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import randomrecipes.RecipesRepository;
import tabs.AddView;
import tabs.GetRandomRecipeView;

public class Main extends Application {
    private RecipesRepository recipesRepository = new RecipesRepository();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane layout = new BorderPane();

        AddView addView = new AddView(recipesRepository);
        GetRandomRecipeView getRandomRecipeView = new GetRandomRecipeView(recipesRepository);

        HBox hBox = createControlBox(addView,getRandomRecipeView,layout);

        layout.setTop(hBox);

        Scene scene = new Scene(layout,800,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createControlBox(AddView addView, GetRandomRecipeView getRandomRecipeView, BorderPane layout) {
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(5, 5, 5, 5));
        hBox.setSpacing(10);

        Button addViewButton = new Button("Add a Recipe");
        Button randomRecipeButton = new Button("Get a Random Recipe");
        Button allRecipesButton = new Button("See All Recipes");

        addViewButton.setOnAction(event -> layout.setCenter(addView.getView()));
        randomRecipeButton.setOnAction(event -> layout.setCenter(getRandomRecipeView.getView()));
        allRecipesButton.setOnAction(event -> {});

        hBox.getChildren().addAll(addViewButton, randomRecipeButton, allRecipesButton);
        return hBox;
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