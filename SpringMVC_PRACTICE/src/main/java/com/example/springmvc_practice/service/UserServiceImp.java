package com.example.springmvc_practice.service;

import com.example.springmvc_practice.DAO.UserRepository;
import com.example.springmvc_practice.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public List<user> findAll() {
        return userRepository.findAll();
    }

    @Override
    public user findById(int theId) {
        Optional<user> result = userRepository.findById(theId);
        user theUser = null;
        if(result.isPresent()) {
            theUser = result.get();
        }else {
            throw  new RuntimeException("Not found for id:" + theId);
        }
        return theUser;
    }

    @Override
    public void save(user user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }

}
