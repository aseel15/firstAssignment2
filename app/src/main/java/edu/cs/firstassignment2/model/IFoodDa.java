package edu.cs.firstassignment2.model;

import java.util.List;

public interface IFoodDa {
    public List<Food>getFoods();
    public String[] getFoodName();
    public Food getFoodObj(String f);
}
