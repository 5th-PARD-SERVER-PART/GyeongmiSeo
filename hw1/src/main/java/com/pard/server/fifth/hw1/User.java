package com.pard.server.fifth.hw1;
// JSON을 매핑할 DTO class임.
public class User {
    private String name;
    private int age;

    public User(){}

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
}
