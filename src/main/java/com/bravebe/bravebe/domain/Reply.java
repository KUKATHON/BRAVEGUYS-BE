package com.bravebe.bravebe.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Reply {

    @Id
    private String replyId;
    private String userId;
    private String postId;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;


}
