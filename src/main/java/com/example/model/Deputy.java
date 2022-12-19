package com.example.model;


public class Deputy {

    private int id;
    private String login;
    private String password;
    private String FirstName;
    private String LastName;
    private int age;

    public Deputy(){

    }

    public Deputy(int id, String login, String password, String firstName, String lastName, int age) {
        this.id = id;
        this.login = login;
        this.password = password;
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
