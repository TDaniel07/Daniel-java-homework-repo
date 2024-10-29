package com.itschool.mvc_application.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    String title;
    String ingredients;
    String description;
    String preparationSteps;
    int cookingTime;
}
