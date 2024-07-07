package com.ms.email.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EmailDto {
    @NotBlank
    String ownerRef;

    @NotBlank
    @Email
    String emailFrom;

    @NotBlank
    @Email
    String emailTo;

    @NotBlank
    String subject;

    @NotBlank
    String text;
}