package com.nibedita.blog.services;

import java.util.List;

import com.nibedita.blog.payloads.CategoryDto;

public interface CategoryService {
	
	 CategoryDto createCategory(CategoryDto categoryDto);
	 CategoryDto updateCategory(CategoryDto categoryDto,Integer cid);
	 void deleteCategory(Integer cid);
	 CategoryDto getCategory(Integer cid);
	 List<CategoryDto> getAllCategories();
	

}
