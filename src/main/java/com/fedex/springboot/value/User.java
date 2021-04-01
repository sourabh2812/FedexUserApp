package com.fedex.springboot.value;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class User {

	private int id;

	@NotEmpty(message = "First name is a required field.")
	private String firstName;

	@NotEmpty(message = "Last name is a required field.")
	private String lastName;
	
}
