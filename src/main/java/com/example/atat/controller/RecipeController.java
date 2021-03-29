package com.example.atat.controller;

import com.example.atat.Service.RecipeService;
import javassist.expr.Instanceof;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{recipeID}/show")
    public String viewRecipe( @PathVariable String recipeID,Model model){
        model.addAttribute("recipe",recipeService.getRecipeById(Long.valueOf(recipeID)));
        return "recipe/show";
    }


}
