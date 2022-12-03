package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.PostException;
import com.blog.modal.Post;
import com.blog.service.CommentService;
import com.blog.service.PostService;



@RestController
@RequestMapping("/api")
public class PostController {
	
	
	@Autowired
	private PostService pService;
	
	
	
	@PostMapping("/posts")
	public ResponseEntity<Post> addPost(@RequestBody Post p) throws PostException{
		return new ResponseEntity<Post>(pService.addPost(p),HttpStatus.OK);
	}
	
	@PostMapping("/posts/{id}")
	public ResponseEntity<Post> update(@RequestBody Post p, @PathVariable("id") Integer id) throws PostException{
		return new ResponseEntity<Post>(pService.update(p, id),HttpStatus.OK);
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") Integer id) throws PostException{
		return new ResponseEntity<Post>(pService.getPostById(id),HttpStatus.OK);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> viewAllPost() throws PostException{
		return new ResponseEntity<List<Post>>(pService.viewAllPost(),HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable Integer id) throws PostException{
		return new ResponseEntity<Post>(pService.deletePost(id),HttpStatus.OK);
	}

}
