package com.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exception.CustomerException;
import com.blog.modal.Customer;
import com.blog.repo.CustomerRepo;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo cRepo;



	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
	
		Customer c = cRepo.save(customer);

		if (c != null) {
			return c;
		} else {
			throw new CustomerException("customer created!!!!");
		}
	}

	
}
