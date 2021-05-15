package com.pocket.model;

public class Calories {
    private String name;
    private int Calories;
    private double Fats;
    private double Carbs;
    private double Proteins;
    private int day;

    public Calories()
    {}

    public Calories(String name, int Calories, double Fats, double Carbs, double Proteins, int day)
    {
        this.name = name;
        this.Calories = Calories;
        this.Fats = Fats;
        this.Carbs = Carbs;
        this.Proteins = Proteins;
        this.day=day;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getCalories()
    {
        return Calories;
    }

    public void setCalories(int Calories)
    {
        this.Calories = Calories;
    }

    public double getFats()
    {
        return Fats;
    }

    public void setFats(double Fats)
    {
        this.Fats=Fats;
    }

    public double getCarbs()
    {
        return Carbs;
    }

    public void setCarbs(double Carbs)
    {
        this.Carbs=Carbs;
    }

    public double getProteins()
    {
        return Proteins;
    }

    public void setProteins(double Proteins)
    {
        this.Proteins=Proteins;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }



}
