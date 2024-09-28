package tabs;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import randomrecipes.RecipesRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class AddView {

    private RecipesRepository recipesRepository;
    private boolean addingRecipe;
    private String recipeName;
    private Label label;
    private TextField textField;
    private Button addRecipe;

    public AddView(RecipesRepository recipesRepository){
        this.recipesRepository = recipesRepository;
        this.addingRecipe = false;
    }
    public StackPane getView(){

        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);

        label = new Label("Enter your recipe name ");
        textField = new TextField();
        addRecipe = new Button("add");

        textField.setMaxWidth(150);

        HBox addPaneHBox = getHbox();

        layout.getChildren().add(addPaneHBox);

        addRecipe.setOnAction(event -> handleAddRecipe());

        return layout;
    }

    public HBox getHbox(){
        HBox hBox = new HBox();
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(label,textField, addRecipe);
        return hBox;
    }

    public void handleAddRecipe(){
        if (!addingRecipe) {
            recipeName = textField.getText(); // Tofu
            textField.clear();
            label.setText("Now, add your ingredients ");
            addingRecipe = true;
        } else {
            String[] ingredients = textField.getText().split(" ");
            ArrayList<String> ingredientsList = new ArrayList<>(Arrays.asList(ingredients));
            recipesRepository.addRecipes(recipeName, ingredientsList);
            label.setText("Enter your recipe name ");
            resetForm();
        }
    }

    private void resetForm() {
        label.setText("Enter your recipe name:");
        textField.clear();
        addingRecipe = false;
    }
}
