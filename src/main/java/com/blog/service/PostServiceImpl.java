package com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.exception.PostException;
import com.blog.modal.Post;
import com.blog.repo.PostRepo;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo pRepo;
	

	@Override
	public Post addPost(Post post) throws PostException {
		Post p = pRepo.save(post);
		 
		 if(post!=null) {
			 return p;
		 }else {
			 throw new PostException("post not added!!");
		 }
	}

	@Override
	public Post update(Post p,Integer id) throws PostException {
	    Optional<Post> opt = pRepo.findById(id);
	     if(opt.isEmpty()) {
	    	 throw new PostException("post not found with this id " + id);
	     }
//	   checking book id which comes with book
			Optional<Post> postOpt = pRepo.findById(p.getPostId());
			if (postOpt.isEmpty())
				throw new PostException("post not found with this id " + p.getPostId());

			return pRepo.save(p);
	}

	@Override
	public List<Post> viewAllPost() throws PostException {
		List<Post> ls =  pRepo.findAll();
		if(ls.size()>0) {
			return ls;
		}else {
			throw new PostException("post list is empty!!!");
		}
	}

	@Override
	public Post deletePost(Integer id) throws PostException {
		Optional<Post> post = pRepo.findById(id);
		  
	     if(post.isPresent()) {
	    	 Post temp = post.get();
	    	 pRepo.delete(temp);
	    	 return temp;
	     }else {
	    	 throw new PostException("post not found !!");
	     }
	}

	@Override
	public Post getPostById(Integer id) throws PostException {
         Optional<Post> p = pRepo.findById(id);
		 
		 if(p.isPresent()) {
			 return p.get();
		 }else {
			 throw new PostException("book not found!!");
		 }
	}

}
