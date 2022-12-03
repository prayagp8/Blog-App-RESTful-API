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

import com.blog.exception.CommentException;
import com.blog.exception.PostException;
import com.blog.modal.Comments;
import com.blog.modal.Post;
import com.blog.service.CommentService;
import com.blog.service.PostService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	

	@Autowired
	private CommentService cService;
	
	
	@PostMapping("/comments/{pId}")
	public ResponseEntity<Comments> addComment( @PathVariable("pId") Integer pId ,@RequestBody Comments c) throws CommentException, PostException {
		return new ResponseEntity<Comments>(cService.addComment(pId, c),HttpStatus.OK);
	}
	
	@PostMapping("/comment/{id}")
	public ResponseEntity<Comments> update(@RequestBody Comments c, @PathVariable("id") Integer id) throws CommentException{
		return new ResponseEntity<Comments>(cService.update(c, id),HttpStatus.OK);
	}

	
	@GetMapping("/comment/{pId}")
	public ResponseEntity<List<Comments>> viewAllComment(@PathVariable("pId") Integer pId) throws CommentException, PostException{
		return new ResponseEntity<List<Comments>>(cService.viewAllCommentByPostId(pId),HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<Comments> deleteComment(@PathVariable Integer id) throws CommentException{
		return new ResponseEntity<Comments>(cService.deleteComment(id),HttpStatus.OK);
	}
	
	
	

}
