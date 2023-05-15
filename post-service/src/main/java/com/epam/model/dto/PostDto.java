package com.epam.model.dto;

import com.epam.validation.group.PostCreateValidationGroup;
import com.epam.validation.group.PostUpdateValidationGroup;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class PostDto {

    private long id;

    @Positive(message = "Please, specify the correct authorId", groups = {PostCreateValidationGroup.class})
    private long authorId;

    @NotEmpty(message = "Please, enter the text", groups = {PostCreateValidationGroup.class, PostUpdateValidationGroup.class})
    private String text;

    private Date postedAt;
}
