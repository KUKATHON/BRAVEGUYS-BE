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
public class Post {
    @Id
    private String postId;
    private String category;
    private String title;
    private String content;
    private String image;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int likeNum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Member member;

}