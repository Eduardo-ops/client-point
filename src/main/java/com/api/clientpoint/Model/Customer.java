package com.api.clientpoint.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	@NotEmpty
	@CPF
	private String name;

	@Column(nullable = false, length = 11)
	@NotNull
	private String cpf;

	@Column(name = "register_date", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime registerDate;

	@PrePersist
	public void preRegister() {
		setRegisterDate(LocalDateTime.now());
	}

}
