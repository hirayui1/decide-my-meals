package randomrecipes;

import java.util.HashMap;
import java.util.List;

public class RecipesRepository {
    private HashMap<String, List<String>> recipes;

    public RecipesRepository() {
        recipes = new HashMap<>();
    }

    public HashMap<String, List<String>> getRecipes() {
        return recipes;
    }

    public void addRecipes(String recipeName, List<String> ingredients) {
        recipes.put(recipeName, ingredients);
    }

    public void printAll() {
        for (String key : recipes.keySet()) {
            System.out.println("Recipe: " + key);
            for (String ingredient : recipes.get(key)) {
                System.out.println("- " + ingredient);
            }
        }
    }
}
