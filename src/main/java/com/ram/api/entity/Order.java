package com.ram.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long order_id;
	
	@NotEmpty(message = "Please provide service id!")
	private String service_id;
	
	@NotEmpty(message = "Please provide service name!")
	private String service_name;
	
	@NotEmpty(message = "Please provide pricing id!")
	private String pricing_id;
	
	@NotEmpty(message = "Please provide pricing name!")
	private String pricing_name;
	
	private double price;
}
