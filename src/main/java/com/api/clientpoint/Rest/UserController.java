package com.api.clientpoint.Rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.clientpoint.Model.Users;
import com.api.clientpoint.Repository.UsersRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    UsersRepository usersRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody @Valid Users user) {
		usersRepository.save(user);
	}
}
