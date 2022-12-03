package com.blog.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	private LocalDate date;
	private String discription;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Comments> comments = new ArrayList<>();
	
}
