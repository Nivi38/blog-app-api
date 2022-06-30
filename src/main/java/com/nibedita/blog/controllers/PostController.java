package com.nibedita.blog.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nibedita.blog.payloads.ApiResponse;
import com.nibedita.blog.payloads.PostDto;
import com.nibedita.blog.payloads.PostResponse;
import com.nibedita.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postservice;
	
	@PostMapping("/user/{uid}/category/{cid}/posts")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto,
			@PathVariable Integer uid,
			@PathVariable Integer cid){
		PostDto post=this.postservice.createPost(postDto, uid, cid);
		return new ResponseEntity<>(post,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user/{userId}/post")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto> posts=this.postservice.getAllPostByUser(userId);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/category/{cId}/post")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer cId){
		List<PostDto> posts=this.postservice.getAllPostByCategory(cId);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value="pageNumber",defaultValue="0",required=false)Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue="10",required=false)Integer pageSize){
		PostResponse  posts=this.postservice.getAllPost(pageNumber, pageSize);
		return new ResponseEntity<PostResponse>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable Integer postId){
		PostDto post=this.postservice.getPostById(postId);
		return new ResponseEntity<>(post,HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId){
		this.postservice.deletePost(postId);
		return new ApiResponse("post is deleted",true);
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto post,@PathVariable Integer postId){
		PostDto postDto=this.postservice.updatePost(post, postId);
		return new ResponseEntity<>(postDto,HttpStatus.OK);
	}
	
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keyword){
		List<PostDto> result=this.postservice.searchPost(keyword);
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}

}
