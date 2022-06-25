package com.api.clientpoint.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.clientpoint.Model.Customer;
import com.api.clientpoint.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer findById(Integer id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer updateCustomer(Integer id, Customer customer) {
		return customerRepository.findById(id).map(customerObj -> {
			customerObj.setName(customer.getName());
			customerObj.setCpf(customer.getCpf());
			Customer update = customerRepository.save(customerObj);
			return update;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

//	public void deleteCustomer(Integer id) {
//		customerRepository.findById(id).map(customer -> {
//			customerRepository.delete(customer);
//			return Void.TYPE;
//		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//	}

}
