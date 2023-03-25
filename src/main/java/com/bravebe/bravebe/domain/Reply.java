package com.bravebe.bravebe.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Reply {

    @Id
    private String replyId;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "postId")
    private Post post;

}
