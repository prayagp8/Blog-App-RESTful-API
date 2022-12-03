package com.blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.modal.Customer;



@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {


	public Customer findByEmail(String email);
}
