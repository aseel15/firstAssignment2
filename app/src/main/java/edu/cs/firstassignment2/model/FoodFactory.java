package edu.cs.firstassignment2.model;

public class FoodFactory {
    public IFoodDa getModel(){
        return new FoodData();
    }
}
