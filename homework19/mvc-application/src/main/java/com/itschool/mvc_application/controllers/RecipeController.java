package com.itschool.mvc_application.controllers;

import com.itschool.mvc_application.models.Recipe;
import com.itschool.mvc_application.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @GetMapping
    public String homePage(Model model){
        return "index";
    }

    @GetMapping("/recipes")
    public String recipesPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipes";
    }

    @GetMapping("/recipe/add")
    public String addRecipePage(Model model){
        model.addAttribute("recipe", new Recipe());
        return "add-recipe";
    }

    @PostMapping("/recipe/add")
    public String addRecipe(@ModelAttribute Recipe recipe, Model model){
        model.addAttribute("recipe", recipe);
        recipeService.addRecipe(recipe);
        return "index";
    }
}
