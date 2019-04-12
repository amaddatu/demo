package com.teaneck_squad.demo.Services;

import com.teaneck_squad.demo.Models.User;
import com.teaneck_squad.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean createUser(User user){
//        User user = new User();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
        if(user.getFirstName().length() > 0){
            final User save = userRepository.save(user);
            return true;
        }
        else return false;
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
