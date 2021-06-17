package com.example.springmvc_practice.DAO;

import com.example.springmvc_practice.models.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<user, Integer> {
}
