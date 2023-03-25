package com.bravebe.bravebe.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Report {

    @Id
    private String reportId;
    private String postId;
    private String sendId;
    private String receiveId;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;

}
