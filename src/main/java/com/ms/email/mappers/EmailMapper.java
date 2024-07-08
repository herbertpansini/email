package com.ms.email.mappers;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    EmailDto emailModelToEmailDto(EmailModel emailModel);

    @InheritInverseConfiguration
    EmailModel emailDtoToEmailModel(EmailDto emailDto);
}