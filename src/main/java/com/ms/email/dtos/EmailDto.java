package com.ms.email.dtos;

import com.ms.email.enums.StatusEmail;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailDto {
    @Id
    Long emailId;

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

    LocalDateTime sendDateEmail;
    StatusEmail statusEmail;
}