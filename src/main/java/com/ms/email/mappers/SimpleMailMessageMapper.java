package com.ms.email.mappers;

import com.ms.email.dtos.EmailDto;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.mail.SimpleMailMessage;

@Mapper(componentModel = "spring")
public interface SimpleMailMessageMapper {

    @Mapping(source = "emailFrom", target = "from")
//    @Mapping(source = "emailTo", target = "to")
    @Mapping(source = "subject", target = "subject")
    @Mapping(source = "text", target = "text")
    SimpleMailMessage emailDtoToSimpleMailMessage(EmailDto emailDto);

    @BeforeMapping
    default void emailTo(EmailDto emailDto, @MappingTarget SimpleMailMessage message) {
        message.setTo(emailDto.getEmailTo());
    }
}