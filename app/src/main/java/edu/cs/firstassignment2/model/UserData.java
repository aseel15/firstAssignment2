package edu.cs.firstassignment2.model;

import java.util.ArrayList;
import java.util.List;

public class UserData implements IUserDa{
    List<User> list= new ArrayList<>();

    public UserData() {
    }
    public List<User> getUsers(){
        ArrayList<User> dataUser = new ArrayList<>();
        for (User f : list) {
            dataUser.add(f);
        }
        return dataUser;
    }
    public User getUserObj(String f){

        for(int i=0;i< list.size();i++){
            if(f.equals(list.get(i).getName()))
                return list.get(i);
        }
        return null;
    }
    public String[] getUserName() {
        String [] foodsArr=new String[list.size()];
        int i = 0;
        for (String f: foodsArr) {
            f=list.get(i).getName();
            i++;
        }
        return foodsArr;
    }
}
