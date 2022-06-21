package com.api.clientpoint.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.clientpoint.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
