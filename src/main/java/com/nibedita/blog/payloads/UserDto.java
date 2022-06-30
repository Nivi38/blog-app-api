package com.nibedita.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;

	@NotEmpty
	@Size(min=4,message="username must be atleast 4 characters")
	private String name;
	@Email(message="email is invalid")
	private String email;
	@NotEmpty
	private String password;
	@NotNull
	@Size(max=500,message="exceeded limit")
	private String about;

}
