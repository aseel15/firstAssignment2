package edu.cs.firstassignment2.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FoodData  implements IFoodDa{
    List<Food> foods=new ArrayList<>();


    public FoodData() {
        foods.add(new Food("Boiled Eggs", 68, 4.7, 0.5,5.5,"boiledegges"));
        foods.add(new Food("White Cheese", 70, 5, 0,6,"whitecheese"));
        foods.add(new Food("Labneh", 40, 3, 2,2,"labneh"));
        foods.add(new Food("Potato", 103, 0.1, 20,2,"boiledpotato"));
        foods.add(new Food("Grilled Tomato", 18, 0.1, 2.5,0.5,"grilledtomatoes"));
        foods.add(new Food("Meat",200,11,0,22,"meat"));
        foods.add(new Food("Grilled Chicken",100,0.5,0,22,"chicken"));
        foods.add(new Food("Rice", 170,0,37,4,"rice"));
        foods.add(new Food("Oat Bread",110,2,19,4,"honeyoatbread"));


    }

    public List<Food> getFoods(){
        ArrayList<Food> dataFood = new ArrayList<>();
        for (Food f : foods) {
            dataFood.add(f);
        }
        return dataFood;
    }
    public Food getFoodObj(String f){

       for(int i=0;i< foods.size();i++){
           if(f.equals(foods.get(i).getFoodName()))
               return foods.get(i);
       }
      return null;
    }

   // @Override
    public String[] getFoodName() {
        String [] foodsArr=new String[foods.size()];
        int i = 0;
        for (String f: foodsArr) {
            f=foods.get(i).getFoodName();
            i++;
        }
        return foodsArr;
    }

}
