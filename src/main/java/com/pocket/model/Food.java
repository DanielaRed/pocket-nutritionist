package com.pocket.model;

public class Food {

    private String name;
    private String serving;
    private double carbs;
    private double fat;
    private double protein;
    private int calories;

    public Food(String name, String serving, double carbs, double fat, double protein, int calories)
    {
        this.name=name;
        this.serving = serving;
        this.carbs=carbs;
        this.fat = fat;
        this.protein = protein;
        this.calories = calories;
    }



}
