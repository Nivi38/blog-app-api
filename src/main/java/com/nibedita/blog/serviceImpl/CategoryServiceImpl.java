package com.nibedita.blog.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibedita.blog.entities.Category;
import com.nibedita.blog.entities.User;
import com.nibedita.blog.exceptions.ResourceNotFoundException;
import com.nibedita.blog.payloads.CategoryDto;
import com.nibedita.blog.payloads.UserDto;
import com.nibedita.blog.repositories.CategoryRepo;
import com.nibedita.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category addedCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer cid) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(cid).orElseThrow(()-> new ResourceNotFoundException("category","id",cid));
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		Category updatedCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer cid) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("category","id",cid));
		this.categoryRepo.delete(cat);

	}

	@Override
	public CategoryDto getCategory(Integer cid) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("category","id",cid));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> categories=this.categoryRepo.findAll();
		List<CategoryDto> dtos=categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return dtos;
		
		
	}

}
