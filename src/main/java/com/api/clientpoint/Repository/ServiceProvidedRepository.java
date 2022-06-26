package com.api.clientpoint.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.clientpoint.Model.ServiceProvided;

@Repository
public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {

}
