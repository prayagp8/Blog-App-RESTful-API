package com.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.CommentException;
import com.blog.exception.PostException;
import com.blog.modal.Comments;
import com.blog.modal.Post;
import com.blog.repo.CommentRepo;
import com.blog.repo.PostRepo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepo cRepo;
	@Autowired
	private PostRepo pRepo;
	

	@Override
	public Comments addComment(Integer pId, Comments comment) throws CommentException, PostException {
		     Optional<Post> pOpt = pRepo.findById(pId);
		     
		     if(pOpt.isEmpty()) {
		    	 throw new PostException("post not found!!!");
		     }else {
		    	 Post p = pOpt.get();
		    	 List<Comments> ls = p.getComments();
		    	 Comments  com= cRepo.save(comment);
		    	 
		    	 if(com!=null) {
		    		 ls.add(comment);
			    	 pRepo.save(p); 
			    	 return com;
		    	 }else {
		    		 throw new CommentException("comment not added!!");
		    	 }
		    	 
		     }
		
        
	}

	@Override
	public Comments update(Comments c,Integer id) throws CommentException {
		   Optional<Comments> opt = cRepo.findById(id);
		     if(opt.isEmpty()) {
		    	 throw new CommentException("comment not found with this id " + id);
		     }
//		   checking book id which comes with comment
				Optional<Comments> cOpt = cRepo.findById(c.getCommentId());
				if (cOpt.isEmpty())
					throw new CommentException("comment not found with this id " + c.getCommentId());

				return cRepo.save(c);
			
	}

	@Override
	public List<Comments> viewAllCommentByPostId(Integer pId) throws CommentException, PostException {
		 Optional<Post> pOpt = pRepo.findById(pId);
	     
	     if(pOpt.isEmpty()) {
	    	 throw new PostException("post not found!!!");
	     }else {
	    	 
	    	 Post p =pOpt.get();
	    	 List<Comments> ls = p.getComments();
	    	 if(ls.size()==0) {
	    		 throw new CommentException("no comment found for this post!!");
	    	 }else {
	    		 return ls;
	    	 }
	    	 
	     }
		

	}

	@Override
	public Comments deleteComment(Integer id) throws CommentException {
		Optional<Comments> comment = cRepo.findById(id);
		  
	     if(comment.isPresent()) {
	    	 Comments temp = comment.get();
	    	 cRepo.delete(temp);
	    	 return temp;
	     }else {
	    	 throw new CommentException("comment not found !!");
	     }
	}

}
