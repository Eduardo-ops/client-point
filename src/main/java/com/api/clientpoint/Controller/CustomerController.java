package com.api.clientpoint.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.clientpoint.Model.Customer;
import com.api.clientpoint.Service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("http://localhost:4200")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> findAllCustomers() {
		return customerService.findAll();
	}

	@GetMapping("{id}")
	public Customer findById(@PathVariable Integer id) {
		return customerService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Customer updateCustomer(@Valid @PathVariable Integer id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(Customer customer) {
		customerService.deleteCustomer(customer);
	}

//	@DeleteMapping("{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteCustomer(Integer id) {
//		customerService.deleteCustomer(id);
//	}
}
