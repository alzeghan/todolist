package com.todo.persistance.modelDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {
	@NotNull
    @NotEmpty
    private String firstName;
     
    @NotNull
    @NotEmpty
    private String lastName;
    
    @NotNull
    @NotEmpty(message = "{registration.error.email.required}")
    private String username;
    
    @NotNull
    @NotEmpty(message = "{registration.error.password.required}")
    @Size(min = 6, message = "{registration.error.password.size}")
    private String password;
    
    @NotNull
    @NotEmpty(message = "{registration.error.confirmationPassword.required}")
    @Size(min = 6, message = "{registration.error.confirmationPassword.size}")

    private String matchingPassword;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
    
}
