package com.rizvi.springboot.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty(message = "First name is required cannot be empty")
    private String firstName;
    @NotEmpty(message = "Last name is required cannot be empty")
    private String lastName;
    @NotEmpty(message = "Email is required cannot be empty")
    @Email(message = "Please provide a valid email address")
    private String email;
}
