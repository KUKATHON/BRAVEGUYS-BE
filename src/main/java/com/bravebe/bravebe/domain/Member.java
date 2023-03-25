package com.bravebe.bravebe.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Member {
    @Id
    private String id;
    private String pwd;
    private String name;
    private String phoneNumber;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;

}