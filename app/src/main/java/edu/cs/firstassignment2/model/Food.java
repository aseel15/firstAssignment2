package edu.cs.firstassignment2.model;

public class Food {
    private String foodName;
    private double numOfCal;
    private double fat;
    private double carb;
    private double protein;
    private String imgUrl;

    public Food() {
    }
    public Food(String foodName, double numOfCal) {
        this.foodName = foodName;
        this.numOfCal = numOfCal;
    }

    public Food(String foodName, double numOfCal, double fat, double carb, double protein, String imgUrl) {
        this.foodName = foodName;
        this.numOfCal = numOfCal;
        this.fat = fat;
        this.carb = carb;
        this.protein = protein;
        this.imgUrl = imgUrl;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getNumOfCal() {
        return numOfCal;
    }

    public void setNumOfCal(double numOfCal) {
        this.numOfCal = numOfCal;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
