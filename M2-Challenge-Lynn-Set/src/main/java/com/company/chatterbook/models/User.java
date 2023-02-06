package com.company.chatterbook.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<ChatterPosts> chatterPosts;

    public User(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChatterPosts> getChatterPosts() {return chatterPosts;}

    public void setChatterPosts(List<ChatterPosts> chatterPosts) {this.chatterPosts = chatterPosts;}
}
