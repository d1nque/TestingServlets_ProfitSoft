package com.example.dao;

import com.example.model.Deputy;

import java.util.ArrayList;
import java.util.List;

public class DeputyDao {

    private List<Deputy> deputies;
    public DeputyDao(){
        deputies = new ArrayList<>();
    }

    public Deputy getById(int id){
        Deputy result_deputy = new Deputy();
        result_deputy.setId(-1);
        for (Deputy deputy : deputies){
            if(deputy.getId() == id)
                result_deputy = deputy;
        }
        return result_deputy;
    }

    public Deputy getDeputyByLoginAndPassword(String login, String password){
        Deputy result_deputy = new Deputy();
        result_deputy.setId(-1);
        for (Deputy deputy : deputies){
            if(deputy.getLogin().equals(login) && deputy.getPassword().equals(password))
                result_deputy = deputy;
        }
        return result_deputy;
    }

    public void setDeputies(List<Deputy> deputies){
        this.deputies = deputies;
    }

    public List<Deputy> getDeputies(){
        return deputies;
    }

}
