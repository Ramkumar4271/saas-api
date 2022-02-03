package com.ram.api.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SigninRequest {

	@NotBlank(message = "Please provide email")
	private String email;

	@NotBlank(message = "Please provide password")
	private String password;
}
