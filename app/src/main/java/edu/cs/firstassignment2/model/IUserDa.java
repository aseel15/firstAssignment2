package edu.cs.firstassignment2.model;

import java.util.List;

public interface IUserDa {
    public List<User> getUsers();
    public String[] getUserName();
    public User getUserObj(String f);
}
