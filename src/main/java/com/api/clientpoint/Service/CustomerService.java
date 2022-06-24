package com.api.clientpoint.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.clientpoint.Model.Customer;
import com.api.clientpoint.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
