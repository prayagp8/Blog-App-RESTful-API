package com.blog.service;

import java.util.List;

import com.blog.exception.PostException;
import com.blog.modal.Post;



public interface PostService {

	public Post addPost(Post post) throws PostException;
	
	public Post update (Post p ,Integer id)throws PostException;
	
	public List<Post> viewAllPost()throws PostException;
	
	public Post deletePost(Integer id) throws PostException;
	
	public Post getPostById(Integer id) throws PostException;
	
	


}
