package com.intellect.igh.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "AssoId is required")
    private String assoId;

    @NotBlank(message = "AssoLevel is required")
    private String assoLevel;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotNull(message = "Mobile number is required")
    private Long mobileNumber;

    @NotNull(message = "RoleId is required")
    private Integer roleId;
}
