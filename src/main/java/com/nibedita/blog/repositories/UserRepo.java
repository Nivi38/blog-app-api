package com.nibedita.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibedita.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
