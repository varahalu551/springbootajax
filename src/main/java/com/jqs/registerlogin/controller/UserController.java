package com.jqs.registerlogin.controller;

import org.springframework.web.bind.annotation.RestController;
import com.jqs.registerlogin.model.User;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
public class UserController {

    private List<User> users=new ArrayList<>( List.of(new User(1,"Rama","Rama@gmail.com"),
        new User(2,"Sita","Sita@gmail.com")));

    @GetMapping("/users")
    public List<User> getAllusers(){
        System.out.println("Get all users called");
        return users;
    }

   @PostMapping("/saveUser") 
   public ResponseEntity<User> saveUser(@RequestBody User user){
            int newId=users.size()+1;
            user.setId(newId);
            users.add(user);
            return ResponseEntity.ok(user);
   }
    
}
