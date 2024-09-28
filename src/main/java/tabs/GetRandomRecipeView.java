package tabs;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import randomrecipes.RecipesRepository;

import java.util.HashMap;
import java.util.List;

public class GetRandomRecipeView {

    private RecipesRepository recipesRepository;
    private Label randomRecipe;

    public GetRandomRecipeView(RecipesRepository recipesRepository){
        this.recipesRepository = recipesRepository;
        this.randomRecipe = new Label();
    }

    public StackPane getView(){
        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);

        randomRecipe.setText(recipesRepository.getRandomRecipe());
        randomRecipe.setFont(Font.font ("Arial", 20));

        layout.getChildren().add(randomRecipe);

        return layout;
    }

}
