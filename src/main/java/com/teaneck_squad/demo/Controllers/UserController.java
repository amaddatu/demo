package com.teaneck_squad.demo.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teaneck_squad.demo.Models.User;
import com.teaneck_squad.demo.Services.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        ResponseEntity<?> out = null;
        ModelMap mm = new ModelMap();
        if (userService.createUser(user)) {
            mm.put("message", "User successfully created");
            System.out.println(mm.toString());
            mm.put("user", user);
            out = new ResponseEntity<>(mm, HttpStatus.OK);
        }
        else{

            mm.put("message", "unable to add this user");
            mm.put("user", user);
            System.out.println(mm.toString());
            out = new ResponseEntity<>(mm, HttpStatus.UNPROCESSABLE_ENTITY);

        }
        return out;
    }
}
