package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_EMAIL")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long emailId;
    String ownerRef;
    String emailFrom;
    String emailTo;
    String subject;

    @Column(columnDefinition = "TEXT")
    String text;

    LocalDateTime sendDateEmail;

    StatusEmail statusEmail;
}