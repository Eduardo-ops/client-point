package com.api.clientpoint.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, name = "login")
	@NotEmpty(message = "{mandatory.username.field}")
	private String username;

	@Column(name = "senha")
	@NotEmpty(message = "{mandatory.password.field}")
	private String password;

}
