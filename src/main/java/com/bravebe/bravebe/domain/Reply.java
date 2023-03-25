package com.bravebe.bravebe.domain;

import jakarta.persistence.Id;
import lombok.Builder;

import java.time.LocalDateTime;

public class Reply {
    @Id
    private String postId;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;
    private String id;

    @Builder

    public Reply(String postId, String content, LocalDateTime createTime, LocalDateTime deleteTime, String id) {
        this.postId = postId;
        this.content = content;
        this.createTime = createTime;
        this.deleteTime = null;
        this.id = id;
    }
}
