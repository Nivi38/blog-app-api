package com.nibedita.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nibedita.blog.payloads.ApiResponse;
import com.nibedita.blog.payloads.CategoryDto;
import com.nibedita.blog.payloads.UserDto;
import com.nibedita.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto created=this.categoryservice.createCategory(categoryDto);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	
	@PutMapping("/{cid}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer cid){
		CategoryDto updated=this.categoryservice.updateCategory(categoryDto, cid);
		return new ResponseEntity<>(updated,HttpStatus.OK);
		
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<CategoryDto> getCategories(@PathVariable Integer cid){
		CategoryDto get=this.categoryservice.getCategory(cid);
		return new ResponseEntity<>(get,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		List<CategoryDto> dtos=this.categoryservice.getAllCategories();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer cid){
		this.categoryservice.deleteCategory(cid);
		return new ResponseEntity<>(new ApiResponse("category is deleted successfully",true),HttpStatus.OK);
	}
	

}
