package edu.cs.firstassignment2.model;

public class User {
    private String Name;
    private String Weight;
    private String Height;
    private String Gender;

    public User() {
    }

    public User(String name, String weight, String height, String gender) {
        Name = name;
        Weight = weight;
        Height = height;
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
