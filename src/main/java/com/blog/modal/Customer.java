package com.blog.modal;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cId;
	
	@NotNull
	private String fName;
	@NotNull
	private String lName;
	
	private String mobile;
	@Email
	private String email;
	private String password;	


	
}
