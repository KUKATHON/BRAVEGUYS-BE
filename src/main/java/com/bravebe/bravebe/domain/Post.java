package com.bravebe.bravebe.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Post {
    @Id
    private String postId;
    private String userId;
    private String category;
    private String title;
    private String content;
    private String image;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int likeNum;

}