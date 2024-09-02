package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class UserForm {

@NotBlank(message = "username is required")
@Size(min = 3, message = "min 3 character is required")
private String name;
@Email(message = "invalid email address")
@NotBlank(message = "email is required")
private String email;
@NotBlank(message = "phone number is required")
@Size(min=8, max = 12, message = "Invalid phone number")
private String phoneNum;
@NotBlank(message = "password is required")
@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,12}$", 
         message = "Password must be between 8-12 characters, contain at least one lowercase letter, one uppercase letter, one digit, and one special character")
// @Size(min=8, max = 12, message = "min 8-12 characters are required")
private String password;
@NotBlank(message = "about is required")
@Size(min=5, max = 100, message = "3-100 characters are required")
private String about;
// private String profileLink;
}
