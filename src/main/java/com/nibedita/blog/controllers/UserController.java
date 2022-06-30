package com.nibedita.blog.controllers;

import java.util.List;
import java.util.Map;

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
import com.nibedita.blog.payloads.UserDto;
import com.nibedita.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto created=this.userService.createUser(userDto);
		return  new ResponseEntity<>(created,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getUsers(){
		List<UserDto> userDtos=this.userService.getAllUsers();
		return new ResponseEntity<>(userDtos,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
		UserDto userDto=this.userService.getUserById(userId);
		return new ResponseEntity<>(userDto,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userId){
		UserDto updated=this.userService.updateUser(userDto, userId);
		return new ResponseEntity<>(updated,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity(new ApiResponse("user deleted sucessfully",true),HttpStatus.OK);
		 
		
	}

}
