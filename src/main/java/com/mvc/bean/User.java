package com.mvc.bean;

public class User 
{
    private String name,role,username,password;
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
