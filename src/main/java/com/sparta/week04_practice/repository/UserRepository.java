package com.sparta.week04_practice.repository;

import com.sparta.week04_practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);
}
