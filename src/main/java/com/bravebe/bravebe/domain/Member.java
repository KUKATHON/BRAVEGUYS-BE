package com.bravebe.bravebe.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Builder
    public Member(String id, String pwd, String name, String phoneNumber) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.createTime = LocalDateTime.now();
        this.deleteTime = null;
    }
}