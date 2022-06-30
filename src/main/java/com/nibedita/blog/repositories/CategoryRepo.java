package com.nibedita.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nibedita.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
