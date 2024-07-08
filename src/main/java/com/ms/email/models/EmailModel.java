package com.ms.email.models;

import com.ms.email.enums.StatusEmail;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_EMAIL")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailModel implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long emailId;
    String ownerRef;
    String emailFrom;
    String emailTo;
    String subject;

    @Column(columnDefinition = "TEXT")
    String text;

    @CreationTimestamp
    LocalDateTime sendDateEmail;

    @Enumerated(EnumType.ORDINAL)
    // @Column(columnDefinition = "INT4 DEFAULT 1")
    @ColumnDefault("1")
    @Generated(GenerationTime.INSERT)
    StatusEmail statusEmail;
}