package com.ms.email.services;

import com.ms.email.dtos.EmailDto;
import com.ms.email.enums.StatusEmail;
import com.ms.email.mappers.EmailMapper;
import com.ms.email.mappers.SimpleMailMessageMapper;
import com.ms.email.repositories.EmailRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailService {

    final EmailRepository emailRepository;
    final JavaMailSender javaMailSender;
    final EmailMapper emailMapper;
    final SimpleMailMessageMapper simpleMailMessageMapper;

    public Page<EmailDto> findAll(Pageable pageable) {
        return this.emailRepository.findAll(pageable).map(this.emailMapper::emailModelToEmailDto);
    }

    public EmailDto sendEmail(EmailDto emailDto) {
        try {
            javaMailSender.send(this.simpleMailMessageMapper.emailDtoToSimpleMailMessage(emailDto));
        } catch (MailException ex) {
            emailDto.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return this.emailMapper.emailModelToEmailDto(this.emailRepository.save(this.emailMapper.emailDtoToEmailModel(emailDto)));
        }
    }
}