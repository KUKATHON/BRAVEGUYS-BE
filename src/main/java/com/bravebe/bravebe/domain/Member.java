package com.bravebe.bravebe.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Member {
    @Id
    private String userid;
    private String pwd;
    private String name;
    private String phoneNumber;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;

}