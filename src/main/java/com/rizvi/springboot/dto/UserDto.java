package com.rizvi.springboot.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(description = "User Dto model for user details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Schema(description = "User First name ")
    @NotEmpty(message = "First name is required cannot be empty")
    private String firstName;
    @Schema(description = "User Last name")
    @NotEmpty(message = "Last name is required cannot be empty")
    private String lastName;
    @Schema(description = "User Email Address")
    @NotEmpty(message = "Email is required cannot be empty")
    @Email(message = "Please provide a valid email address")
    private String email;
}
