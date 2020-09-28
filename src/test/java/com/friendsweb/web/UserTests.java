package com.friendsweb.web;

import com.friendsweb.web.exeption.AllReadyExistExeption;
import com.friendsweb.web.exeption.NotExistExeption;
import com.friendsweb.web.model.User;
import com.friendsweb.web.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTests {

    @Autowired
    private UserService service;

    @Test
    void contextLoads() {
    }

    @Test
    void add() {
        try {
            User userAfterSave = service.add(new User(
              "Yakov", "dydy@gamil.com", "0528684759"
            ));
            System.out.println(userAfterSave);
        } catch (AllReadyExistExeption allReadyExistExeption) {
            allReadyExistExeption.printStackTrace();
        }
    }

    @Test
    void delete() {
        try {
            service.delete("theNewOne@gmail.com");
        } catch (NotExistExeption notExistExeption) {
            notExistExeption.printStackTrace();
        }
    }

    @Test
    void findAll() {
        System.out.println(service.findAll());
    }

    @Test
    void findByEmail() {
        try {
            System.out.println(service.findByEmail("dydy@gamil.com"));
        } catch (NotExistExeption notExistExeption) {
            notExistExeption.printStackTrace();
        }
    }
}
