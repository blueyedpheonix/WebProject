package com.friendsweb.web.service;

import com.friendsweb.web.exeption.AllReadyExistExeption;
import com.friendsweb.web.exeption.NotExistExeption;
import com.friendsweb.web.model.User;
import com.friendsweb.web.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User add(User user) throws AllReadyExistExeption {
        try {
            return repository.save(user);
        } catch (Exception e) {
            throw new AllReadyExistExeption();
        }
    }

    public User delete(String email) throws NotExistExeption {
        return repository.findByEmail(email).map(user -> {
            repository.delete(user);
            return user;
        })
                .orElseThrow(NotExistExeption::new);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByEmail(String email) throws NotExistExeption {
       try {
           return repository.findByEmail(email).get();
       }catch (Exception e) {
           throw new NotExistExeption();
       }
    }

}
