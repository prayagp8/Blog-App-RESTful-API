package com.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.modal.Post;

public interface PostRepo extends JpaRepository<Post,Integer> {
	


}
