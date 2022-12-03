package com.blog.modal;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer commentId;
	private LocalDate date;

	@NotNull
	private String discription;
	

	
	
	
}
