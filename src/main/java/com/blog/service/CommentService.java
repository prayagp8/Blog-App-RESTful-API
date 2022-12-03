package com.blog.service;

import java.util.List;

import com.blog.exception.CommentException;
import com.blog.exception.PostException;
import com.blog.modal.Comments;
import com.blog.modal.Post;

public interface CommentService {
	
	public Comments addComment(Integer pId, Comments post) throws CommentException, PostException;
	
	public Comments update (Comments c,Integer id)throws CommentException;
	
	public List<Comments> viewAllCommentByPostId(Integer pId)throws CommentException,PostException;
	
	public Comments deleteComment(Integer id) throws CommentException;
	

}
