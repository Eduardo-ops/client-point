package com.api.clientpoint.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvided {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 150)
	@NotNull(message = "{mandatory.description.field}")
	private String description;

	@ManyToOne
	@JoinColumn(name = "id_customer")
	@NotEmpty(message = "{mandatory.customer.field}")
	private Customer customer;

	@Column()
	@NotNull(message = "{mandatory.price.field}")
	private BigDecimal price;
}
