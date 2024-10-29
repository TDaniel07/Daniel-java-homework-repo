package com.itschool.mvc_application.services;

import com.itschool.mvc_application.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private List<Recipe> recipes = new ArrayList<>();

    public List<Recipe> getRecipes(){
        return recipes;
    }

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
    }
}
