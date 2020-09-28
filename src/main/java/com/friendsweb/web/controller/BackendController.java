package com.friendsweb.web.controller;

import com.friendsweb.web.dto.Dto;
import com.friendsweb.web.exeption.AllReadyExistExeption;
import com.friendsweb.web.exeption.NotExistExeption;
import com.friendsweb.web.model.Admin;
import com.friendsweb.web.model.User;
import com.friendsweb.web.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/back")
public class BackendController {

    private final UserService userService;
    private String adminEmail = "admin@admin";
    private String adminPassword = "admin123";

    public BackendController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<Dto> all() {
        return ResponseEntity.ok(new Dto<>(true, userService.findAll()));
    }

    @PostMapping("/register")
    public ResponseEntity<Dto> register(@RequestBody User user) {
        try {
            return ResponseEntity.ok(new Dto<>(true, userService.add(user)));
        } catch (AllReadyExistExeption allReadyExistExeption) {
           return ResponseEntity.ok(new Dto<>(false,allReadyExistExeption.getMessage()));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Dto> delete(@RequestBody User user) {
        try {
            return ResponseEntity.ok(new Dto<>(true, userService.delete(user.getEmail())));
        } catch (NotExistExeption notExistExeption) {
            return ResponseEntity.ok(new Dto<>(false, notExistExeption.getMessage()));
        }
    }

    @GetMapping("/findbyemail")
    public ResponseEntity<Dto> findByEmail(@RequestBody User user) {
        try {
            return ResponseEntity.ok(new Dto<>(true, userService.findByEmail(user.getEmail())));
        } catch (NotExistExeption notExistExeption) {
            return ResponseEntity.ok(new Dto<>(false, notExistExeption.getMessage()));
        }
    }

    @GetMapping("/adminlogin")
    public ResponseEntity<Boolean> loginAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok
                (admin.getEmail().equalsIgnoreCase(adminEmail) && admin.getPassword().equalsIgnoreCase(adminPassword));
    }





}
