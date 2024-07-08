package com.ms.email.controllers;

import com.ms.email.dtos.EmailDto;
import com.ms.email.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<Page<EmailDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.emailService.findAll(pageable));
    }

    @PostMapping("send")
    public ResponseEntity<EmailDto> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.emailService.sendEmail(emailDto));
    }
}