package com.epam.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {

    private long id;

    @NotEmpty(message = "Please, specify username")
    @Size(max = 40, message = "Username must no exceed 40 characters")
    private String username;

    private int amountOfPosts;
}
