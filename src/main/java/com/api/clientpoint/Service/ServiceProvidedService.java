package com.api.clientpoint.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.clientpoint.Model.ServiceProvided;
import com.api.clientpoint.Repository.ServiceProvidedRepository;

@Service
public class ServiceProvidedService {

	@Autowired
	ServiceProvidedRepository serviceProvidedRepository;

	public List<ServiceProvided> findAll() {
		return serviceProvidedRepository.findAll();
	}

	public ServiceProvided findById(Integer id) {
		return serviceProvidedRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado."));
	}

	public ServiceProvided createServiceProvided(ServiceProvided serviceProvided) {
		return serviceProvidedRepository.save(serviceProvided);
	}
}
