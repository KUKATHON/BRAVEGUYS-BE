package com.bravebe.bravebe.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String id;

    @Builder
    public Post(String postId, String category, String title, String content, String image, LocalDateTime createTime, LocalDateTime updateTime, int likeNum, String id) {
        this.postId = postId;
        this.category = category;
        this.title = title;
        this.content = content;
        this.image = image;
        this.createTime = createTime;
        this.updateTime = null;
        this.likeNum = 0;
        this.id = id;
    }
}