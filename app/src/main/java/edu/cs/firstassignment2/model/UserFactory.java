package edu.cs.firstassignment2.model;

public class UserFactory {
    public IUserDa getModel(){
        return new UserData();
    }
}
