package com.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.modal.Comments;

public interface CommentRepo extends JpaRepository<Comments, Integer>{

}
