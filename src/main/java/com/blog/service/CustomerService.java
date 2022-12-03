package com.blog.service;



import com.blog.exception.CustomerException;
import com.blog.modal.Customer;


public interface CustomerService {

	public Customer addCustomer(Customer customer) throws CustomerException;

}
