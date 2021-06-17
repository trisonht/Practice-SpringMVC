package com.example.springmvc_practice.service;

import com.example.springmvc_practice.models.user;

import java.util.List;

public interface UserService {
    public List<user> findAll();

    public user findById(int id);

    public void save(user theUser);

    public void deleteById(int theId);
}
