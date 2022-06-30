package com.nibedita.blog.services;

import java.util.List;

import com.nibedita.blog.payloads.PostDto;
import com.nibedita.blog.payloads.PostResponse;

public interface PostService {
	
	PostDto createPost(PostDto postDto,Integer userId,Integer cid);
	PostDto updatePost(PostDto postDto,Integer postId);
	void deletePost(Integer postId);
	PostResponse getAllPost(Integer pageNumber,Integer pageSize);
	PostDto getPostById(Integer postId);
	List<PostDto> getAllPostByCategory(Integer categoryId);
	List<PostDto> getAllPostByUser(Integer userId);
	List<PostDto> searchPost(String keyword);

}
