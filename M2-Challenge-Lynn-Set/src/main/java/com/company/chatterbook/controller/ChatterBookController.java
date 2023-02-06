package com.company.chatterbook.controller;
import com.company.chatterbook.models.ChatterPosts;
import com.company.chatterbook.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
public class ChatterBookController {

    @RequestMapping(value = "/", method = RequestMethod.GET) // I don't know how to make it readable in the browser
    public List<User> getAllUsers() {
        return userList;
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable String name) {
        User user = null;
        for (User u : userList) {
            if (u.getName().equalsIgnoreCase(name)) {
                user = u;
            }
        }
        return user;
    }

    @RequestMapping(value = "/user/{name}/chatterposts", method = RequestMethod.GET)
    public List<ChatterPosts> getChatterPosts(@PathVariable String name) {
        User user = null;
        for (User u : userList) {
            if (u.getName().equalsIgnoreCase(name)) {
                user = u;
            }
        }
        return user.getChatterPosts();
    }

    private List<User> userList;

    public ChatterBookController() {
        User luis = new User("Luis");
        User sue = new User("Sue");
        User timothy = new User("Timothy");
        User george = new User("George");
        User arturo = new User("Arturo");
        User mariella = new User("Mariella");
        User paolo = new User("Paolo");
        User tri = new User("Tri");
        User jane = new User("Jane");
        User carol = new User("Carol");
        User carl = new User("Carl");

            luis.setChatterPosts(Arrays.asList(new ChatterPosts("Hey! This is my first post!"), new ChatterPosts("Anybody want to be friends?")));
        sue.setChatterPosts(Arrays.asList(new ChatterPosts("I'm bored"), new ChatterPosts("Who wants to hang?")));
        timothy.setChatterPosts(Arrays.asList(new ChatterPosts("My life is awesome!"), new ChatterPosts("Click here to buy my vegan shakes!")));
        george.setChatterPosts(Arrays.asList(new ChatterPosts("I like pigs."), new ChatterPosts("I love lamp.")));
        arturo.setChatterPosts(Arrays.asList(new ChatterPosts("My cat is so cute"), new ChatterPosts("My kitten is purr-fect.")));
        mariella.setChatterPosts(Arrays.asList(new ChatterPosts("I'll never post again")));
        paolo.setChatterPosts(Arrays.asList(new ChatterPosts("Have you ever heard of the band Nirvana?"), new ChatterPosts("Pearl Jam 4 Life")));
        tri.setChatterPosts(Arrays.asList(new ChatterPosts("You definitely grew up in the 90s if you get these 10 references."), new ChatterPosts("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setChatterPosts(Arrays.asList(new ChatterPosts("I just wrecked my dad's car. He's going to kill me!"), new ChatterPosts("Grounded.... for 5 months :( ")));
        carol.setChatterPosts(Arrays.asList(new ChatterPosts("Does anyone have some imodium?")));
        carl.setChatterPosts(Arrays.asList(new ChatterPosts("My roommate is awful!!!!"), new ChatterPosts("Anyone know a room for rent in Hyde Park?")));

        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);
    }

}

