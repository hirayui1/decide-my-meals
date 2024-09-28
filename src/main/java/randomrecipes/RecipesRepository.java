package randomrecipes;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RecipesRepository {
    private HashMap<String, List<String>> recipes;
    private Random random;

    public RecipesRepository() {
        this.recipes = new HashMap<>();
        this.random = new Random();
    }

    public HashMap<String, List<String>> getRecipes() {
        return recipes;
    }

    public void addRecipes(String recipeName, List<String> ingredients) {
        recipes.put(recipeName, ingredients);
    }

    public String getRandomRecipe() {
        Random random = new Random();
        String key = recipes.keySet().stream()
                .skip(random.nextInt(recipes.size()))
                .limit(1)
                .findFirst()
                .orElse(null);
        return "Recipe Name: "+key + "\nIngredients: " + recipes.get(key);
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
