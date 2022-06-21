package com.api.clientpoint.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.clientpoint.Model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
